package java112.analyzer;

import java.util.*; 
import java.io.*; 

/**
 * This analyzer searches for a given set of tokens, and returns their
 * locations. 
 * 
 * @author jcmann
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {

    /**
     * A TreeMap containing a String, the word being found, and a list of 
     * the locations at which it is found. 
     */
    private Map<String, List<Integer>> foundLocations;

    /**
     * The Properties for the project.
     */
    private Properties properties;

    /**
     * Mimics a counter to track the location of the token being analyzed
     * in processToken(). 
     */
    private int currentTokenLocation;

    /**
     * Empty arg constructor. Will always initialize foundLocations. 
     */
    public TokenLocationSearchAnalyzer() {
        this.foundLocations = new TreeMap<String, List<Integer>>(); 
    }

    /**
     * One-arg constructor that sets the properties object. Will call the
     * no-arg constructor prior. 
     * 
     * @param properties passed in properties file object
     */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this(); 
        this.properties = properties; 
        initializeFoundLocations();
    }

    /**
     * A getter method for foundLocations instance variable. 
     * 
     * @return key (word) value (locations) pairs in a Map
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /**
     * Getter method for properties instance variable
     * 
     * @return Properties object for the analyzer project
     */
    public Properties getProperties() {
        return this.properties; 
    }

    /**
     * Getter method for the currentTokenLocation instance variable
     * 
     * @return the currentTokenLocation instance variable used in processToken()
     * to track the location
     */
    public int getCurrentTokenLocation() {
        return this.currentTokenLocation; 
    }
    
    /**
     * This is called once per input token, from FileAnalysis. It checks
     * the token passed in against each search token. If the search token
     * is matched, the A
     * 
     * @param token the token being processed
     */
    public void processToken(String token) {

        // Increment currentTokenLocation to mimic a counter 
        // This should happen regardless of it's a match, to count all tokens
        this.currentTokenLocation++; // TODO maybe initialize to 1 for position not 0 based

        // check token against all keys in foundLocations
        for (Map.Entry<String, List<Integer>> current : getFoundLocations().entrySet()) {

            String key = current.getKey(); 

            if (token.equals(key)) {
                // add the current token location to the value list
                current.getValue().add(getCurrentTokenLocation()); 
                // System.out.println("Adding: " + token); 
                // System.out.println("Current value of key: " + current.getValue());
                // System.out.println("Current list size: " 
                //         + current.getValue().size()); 

            }

        }       

    }

    /**
     * Generates the output file for the token location search. 
     * 
     * @param inputFilePath the location of the input file being analyzed
     */
    public void generateOutputFile(String inputFilePath) {

        // Open the writer 

        String searchFilePath = (getProperties().getProperty("output.directory")
                + getProperties().getProperty("output.file.token.search.locations"));

        try (
            PrintWriter writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(searchFilePath)));
        ) {

            for (Map.Entry<String, List<Integer>> currentEntry : getFoundLocations().entrySet()) {

                // Output the very first line
                writer.println(currentEntry.getKey() + " =");

                // Output the actual data
                if (currentEntry.getValue().size() == 0) {
                    // If there aren't any locations, just close it right away
                    writer.println("[]");
                } else {

                    writeData(currentEntry, writer);

                }             

                writer.println("");
            }

        } catch (IOException exc) {
            System.out.println("I/O Exception.");
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong.");
            exc.printStackTrace();
        }


    }

    /**
     * Helper method to generate the output file for this analyzer.
     * This writes data when there is data to be written 
     * (i.e. list contains values)
     * 
     * @param currentEntry the entry (string, list) being analyzed
     * @param writer the PrintWriter being used to write the file, not closed here
     */
    public void writeData(Map.Entry<String, List<Integer>> currentEntry,
            PrintWriter writer) {

        final int MAX_LINE_LENGTH = 79; // due to opening bracket

        String currentLine = "["; 
        int loop = 1; 
        int numLocations = currentEntry.getValue().size(); 

        // Loop through list of locations
        for (Integer currentLocation : currentEntry.getValue()) {

            String currentToken = "" + currentLocation; // lazy tostring

            Boolean isLastLocation = loop == numLocations; 

            // Format the token for proper length analysis 
            // If loop is the last in the arraylist, format is token]
            if (isLastLocation) {
                currentToken = currentToken + "]"; 
            } else { 
                currentToken = currentToken + ", ";
            }

            currentLine = buildLine(currentToken, currentLine, MAX_LINE_LENGTH, writer);

            // Duplicated if statement, but it has to run after buildLine()
            if (isLastLocation) {
                writer.println(currentLine);
            }

            loop++; 

        }

    }

    /**
     * A helper method for the writeData method. This must be run on every 
     * loop because it determines how the current line is built based on
     * the current token. 
     * 
     * @param currentToken the current location token being added to a line
     * @param currentLine the current line being added to 
     * @param MAX_LINE_LENGTH the constant from writeData
     * @param writer the writer being used to print, used to flush the current
     * line if it's too long  
     * @return currentLine after it's been processed
     */
    public String buildLine(String currentToken, String currentLine, 
            int MAX_LINE_LENGTH, PrintWriter writer) {
        
        // Check the line length to determine how to add the token
        if (currentLine.length() + currentToken.length()>= MAX_LINE_LENGTH) {

            // if adding these would exceed max length, "newline"
            // Print the current existing line
            writer.println(currentLine.trim()); 

            // "Flush" the current line being written for performance
            currentLine = ""; 

            // Start writing the new line with the current token
            currentLine = currentLine + currentToken; 

        } else {
            // There is space on the current line for this token
            currentLine = currentLine + currentToken; 
            // System.out.println("Current line at end: " + currentLine);

        }

        return currentLine; 
    }
    

    /**
     * Runs in the one-arg constructor, only after Properties has been set. 
     * Uses the file specified in Properties to set the Strings for 
     * the instance variable foundLocations. 
     */
    public void initializeFoundLocations() {

        // Get the filepath to search words from properties object
        String searchFilePath = (getProperties().getProperty("classpath.search.tokens")); 
        //System.out.println(searchFilePath);

        // Read from the file in Properties
        try(
            InputStream inputStream = this.getClass().getResourceAsStream(searchFilePath); 
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)
        ) {

            // Read each line of the file
            while (searchTokensReader.ready()) {

                // Collect each line 
                String currentLine = searchTokensReader.readLine(); 
                
                // Collect an array of all the tokens (words) in each line
                // This will include empty tokens 
                String[] currentLineTokens = currentLine.split("\\W");

                for (String currentToken : currentLineTokens) {
                    
                    /* 
                        If the token isn't empty, add it to the map as the String,
                        and its List<Integer> should be empty
                    */
                    if (currentToken.length() != 0) {

                        this.foundLocations.put(currentToken, new ArrayList<Integer>()); 
                        
                    }
                    
                }

            }

        } catch (FileNotFoundException exc) {
            System.out.println("File was not found."); 
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong."); 
            exc.printStackTrace();
        }

    }
    
}

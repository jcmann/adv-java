package java112.analyzer;

import java.util.*; 
import java.io.*; 

/**
 * An analyzer that collects unique tokens above a minimum length specified 
 * in the provided properties file. Because it relies on distinct tokens, 
 * it extends the DistinctTokensAnalyzer class. 
 * 
 * @author jcmann
 */
public class LargestTokensAnalyzer implements TokenAnalyzer {

    /**
     * A TreeSet containing all of the tokens over the minimum length, 
     * specified via properties and minimumTokenLength, in the file. 
     */
    private Set<String> largestTokens; 

    /**
     * An object representing the properties file passed in by the user
     */
    private Properties properties; 

    /**
     * A value extracted from properties defining the minimum token length
     * to be counted for largestTokens. I.e. "include tokens over this length"
     */
    private int minimumTokenLength; 

    /**
     * Empty class constructor. Initializes largestTokens to a TreeSet of Strings.
     */
    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<String>(); 
    }

    /**
     * A one-arg constructor that initializes all instance variables. Starts
     * by calling the default constructor, then sets properties, then  
     * minimumTokenLength based on properties. 
     * 
     * @param properties the Properties object created via user's specified path
     */
    public LargestTokensAnalyzer(Properties properties) {
        this(); 
        this.properties = properties;  
        this.minimumTokenLength = Integer.parseInt(properties.getProperty("largest.words.minimum.length")); 
    }

    /**
     * Getter method for the instance variable largestTokens. 
     * 
     * @return largestTokens instance variable 
     */
    public Set<String> getLargestTokens() {
        return this.largestTokens; 
    }

    /**
     * Getter method for the instance variable minimumTokenLength. 
     * 
     * @return minimumTokenLength instance variable 
     */
    public int getMinimumTokenLength() {
        return this.minimumTokenLength;
    }

    /**
     * Attempt to add the passed-in token to the set, if above a certain
     * length, specified by properties. 
     * 
     * @param token the token to analyze, from FileAnalysis
     */
    public void processToken(String token) { 
 
        // Use the add method to add the token to the Set
        // This will automatically weed out duplicates, because of its type
        if (token.length() >= this.minimumTokenLength) {
            getLargestTokens().add(token);
        }

    }

    /**
     * Generates an output file containing all of the tokens in the 
     * instance variable largestTokens. 
     * 
     * @param inputFilePath the input filepath specified by the user 
     */
    public void generateOutputFile(String inputFilePath) {

        PrintWriter writer = null; 

        try {
            // Instantiate a writer to actually generate the output file
            String outputPath = "" + (properties.getProperty("output.directory"))
                    + (properties.getProperty("output.file.largest.words")); 

            writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputPath)));

            // Loop through the tokens, writing each to the output file
            for (String current : getLargestTokens()) {
                writer.println(current); 
            }

        } catch (IOException ioException) {
            System.out.println("There was an IO Exception.");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong.");
            exception.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close(); 
            }
        }

    }
    
}

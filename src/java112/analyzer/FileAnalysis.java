package java112.analyzer;

import java.io.*; 
import java.util.*;      
import java112.utilities.PropertiesLoader;

/**
 * Analyzer's main controller class. Controls the correct argument count, and 
 * calls methods to analyze text input and generate reports as output files. 
 * 
 * @author jcmann
 */
public class FileAnalysis implements PropertiesLoader {

    /**
     * The valid number of arguments required for the program to succeed. 
     */
    final static int VALID_ARG_NUMBER = 2; 

    /**
     * A list containing all Analyzer objects used in the app. 
     */
    private List<TokenAnalyzer> analyzers; 

    /** 
     * Initializes both Analyzer instance variables. 
     * 
     * @param properties the Properties object created, based on user filepath
     */
    public void initializeAnalyzers(Properties properties) {
        analyzers = new ArrayList<TokenAnalyzer>(); 
        analyzers.add(new FileSummaryAnalyzer(properties)); 
        analyzers.add(new DistinctTokensAnalyzer(properties));
        analyzers.add(new LargestTokensAnalyzer(properties)); 
        analyzers.add(new DistinctTokenCountsAnalyzer(properties)); 
        analyzers.add(new LexicalDensityAnalyzer(properties)); // does not use properties
        analyzers.add(new TokenLocationSearchAnalyzer(properties)); 
        analyzers.add(new TokenLengthsAnalyzer(properties));
    }

    /**
     * The Getter method for the constant static variable VALID_ARG_NUMBER. 
     * 
     * @return VALID_ARG_NUMBER instance constant variable 
     */
    public int getValidArgNumber() {
        return VALID_ARG_NUMBER; 
    }

    /**
     * Creates and returns an instance of a BufferedReader to be used
     * to read from the input file. NOTE: does not close the reader 
     * 
     * @param inputPath is the user-inputted path to an input file, used to 
     * initialize the BufferedReader. 
     * @return input, an instance of BufferedReader if successfully initialized
     * null if not successfully  initialized.
     */
    public BufferedReader initializeInputReader(String inputPath) {
        
        BufferedReader input = null; 
        
        try {
            // Since this accesses an instance variable, try-with-resources doesn't work  
            input = new BufferedReader(new FileReader(inputPath));
             
        } catch (IOException ioException) {
            System.out.println("IO Exception");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong.");
            exception.printStackTrace();
        } finally {
            return input; 
        }
    }

    /**
     * Loops through the input file, BufferedReader input. Collects each line, 
     * and splits each line into tokens by whitespace. Tokens are placed
     * into an array, currentLineTokens. This method uses an enhanced
     * for loop and runs the processTokens methods in both analyzers on all 
     * non-empty tokens in each line. 
     * 
     * @param input a BufferedReader containing the input file 
     */
    public void generateTokens(BufferedReader input) {

        try {        
            while (input.ready()) {

                // Collect each line 
                String currentLine = input.readLine(); 
                
                // Collect an array of all the tokens (words) in each line
                // This will include empty tokens 
                String[] currentLineTokens = currentLine.split("\\W");

                // if the token is not empty, add it to tokens, otherwise ignore
                for (String currentToken : currentLineTokens) {
                    if (currentToken.length() != 0) {
                        //System.out.println("Adding token: " + currentToken); 
                        
                        for (TokenAnalyzer current : this.analyzers) {
                            current.processToken(currentToken); 
                        }
                    }
                }
                
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found"); 
            fileNotFoundException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong."); 
            exception.printStackTrace();
        } finally {

            // The input can be closed here, as it's not used after this
            try {
                if (input != null) {
                    input.close(); 
                }
            } catch (Exception exception) {
                System.out.println("Something went wrong."); 
                exception.printStackTrace();
            } 

        }

    }

    /**
     * Call the methods for both analyzer instance variables to generate
     * their respective file outputs. 
     * 
     * @param inputPath the user inputted path to the file being analyzed
     */
    public void writeOutputFiles(String inputPath) {

        for (TokenAnalyzer current : this.analyzers) {
            current.generateOutputFile(inputPath); 
        }
    }

    /**
     * A helper method to clean up resources, closing the input if
     * necessary. 
     * 
     * @param input the input reader
     */
    public void closeInput(BufferedReader input) {
        try {
            if (input != null) {
                input.close(); 
            }
        } catch (Exception exception) {
            System.out.println("Something went wrong closing the file.");
        }

    }

    /**
     * Primary controller method for the application system. Validates the
     * amount of arguments passed in from the command line, then calls other 
     * helper methods to carry out analysis tasks.
     * 
     * @param arguments command line args passed in to Driver, must be 1
     */
    public void analyze(String[] arguments) {

        // Make sure only 1 arg was passed in 
        if (arguments.length == getValidArgNumber()) {

            // Collect the input path from args
            String inputPath = arguments[0];
            String propertiesPath = arguments[1];  

            // Initialize instances of DistinctTokensAnalyzer and FileSummaryAnalyzer 
            Properties properties = loadProperties(propertiesPath);
            
            if (properties != null) {
                initializeAnalyzers(properties); 
            
                // Open the input as a BufferedReader using the inputPath passed in 
                BufferedReader input = initializeInputReader(inputPath); 

                // Code Review Addition: 
                // Prevent an unnecessary second exception (NullPointerException) 
                // by making sure initializeInputReader didn't return null
                if (input != null) {
                    // Generate individual tokens and process them
                    generateTokens(input); 

                    // Generate the output files for both analyzer classes 
                    writeOutputFiles(inputPath);

                    // Close the file 
                    closeInput(input); 
                }
            } else {
                System.out.println("Properties is null."); 
            }
            
            

        } else {
            System.out.println("Please enter two arguments:" 
                    + " the input file path name, and properties file path name"); 
        }
    }

    
}

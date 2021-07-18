package java112.analyzer;

import java.util.*;

import java.io.*; 

/**
 * This class tests for the percentage of words that are lexical, or 
 * meaningful, in a given input file. 
 * 
 * @author jcmann
 */
public class LexicalDensityAnalyzer implements TokenAnalyzer {

    /**
     * Represents the properties file, used to direct output.
     */
    protected Properties properties; 

    /**
     * A set containing pre-determined non-lexical words. 
     */
    protected Set<String> nonLexicalWords; 

    /**
     * Each instance of this analyzer will maintain the total number of words
     * in the input, similar to the FileSummaryAnalyzer class
     */
    protected int totalWords = 0; 

    /**
     * The count of non-lexical words, determined by the Set
     */
    protected int nonLexicalCount = 0; 

    /**
     * No-arg default constructor. Will always initialize the nonLexicalWords
     * to a TreeSet, and call its initialize method to fill it with words.
     */
    public LexicalDensityAnalyzer() {
        nonLexicalWords = new TreeSet<String>(); 

        initializeLexicalWords(); 
    }

    /**
     * A constructor that also initializes its Properties instance variable. 
     * Not used in test, but this is used in FileAnalysis class. 
     * 
     * @param properties the properties object
     */
    public LexicalDensityAnalyzer(Properties properties) {
        this(); 
        this.properties = properties; 
    }

    /**
     * Getter method for this instance's properties variable
     * 
     * @return properties the instance variable
     */
    public Properties getProperties() {
        return this.properties;
    }

    /**
     * Setter for the properties variable. 
     * 
     * @param properties properties object
     */
    public void setProperties(Properties properties) {
        this.properties = properties; 
    }

    /**
     * Getter method for the Set of non lexical words instance variable
     * 
     * @return nonLexicalWords set
     */
    public Set<String> getnonLexicalWords() {
        return this.nonLexicalWords;
    }

    /**
     * Getter method for the total word counter
     * 
     * @return totalWords instance variable
     */
    public int getTotalWords() {
        return this.totalWords;
    }

    /**
     * Setter method for the totalWords instance variable
     * 
     * @param totalWords the new value to set totalWords to
     */
    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    /**
     * Calculates the lexical density of the file based on the number of 
     * non-lexical words and total words. 
     * 
     * @return the density percentage out of 100
     */
    public double calculateDensity() {
        return 100.0 - ((double) nonLexicalCount / totalWords) * 100;
    }

    /**
     * Compares the current token to each of the tokens in the lexical map. 
     * If the token corresponds to a word, it is lexical, so the value is
     * incremented. Each token processed must also increment the counter. 
     * 
     * @param token the current token being processed
     */
    public void processToken(String token) {
        
        // Increment the total counter
        this.totalWords++; 

        // If found in lexical list, increment lexical counter
        for (String currentWord : nonLexicalWords) {
            if (currentWord.equals(token)) {
                nonLexicalCount++;
            }
        }

    }

    /**
     * Generates the brief output file displaying total words, lexical words, 
     * and the density rating. 
     * 
     * @param inputFilePath the input filepath provided by user 
     */
    public void generateOutputFile(String inputFilePath) {

        PrintWriter writer = null; 

        try {
            // Instantiate a writer to actually generate the output file
            String outputPath = "" + (properties.getProperty("output.directory"))
                    + (properties.getProperty("output.file.lexical")); 

            writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputPath)));

            // Write each entry to output file with formatting
            writer.println("Total words found: " + totalWords); 
            writer.println("Total lexical words: " + (totalWords - nonLexicalCount));
            writer.println("Density rating: " + calculateDensity());

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

    /**
     * Run in the constructor to initialize the instance variable to contain
     * keys of all lexical words provided via a properties file, and 
     * initialize all values to 0. 
     */
    public void initializeLexicalWords() {

        // Create a Reader to read lexical words from a file 
        try ( 
            BufferedReader reader = new BufferedReader(new FileReader("io/project02/lexicalWords.txt"));
        ) {

            while (reader.ready()) {
                // Each line should only have one word on it
                String token = reader.readLine(); 
                nonLexicalWords.add(token); 
                
            }

        } catch (FileNotFoundException exc) {
            System.out.println("File was not found."); 
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("There was an exception."); 
            exc.printStackTrace();
        }

    }
    
}

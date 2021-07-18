package java112.analyzer;

import java.util.*;
import java.io.*;

/**
 * This analyzer tracks how many tokens there are for any given length. 
 * It generates a simple quantitative display of this data and a histogram
 * representing that data.
 * 
 * @author jcmann
 */
public class TokenLengthsAnalyzer implements TokenAnalyzer {

    /**
     * A map with an Integer key that represents the length of a token, and 
     * an Integer value that represents the number of times that token was found.
     */
    private Map<Integer, Integer> tokenLengths;

    /**
     * The Properties file for the analyzer project.
     */
    private Properties properties;

    /**
     * No-arg constructor. Initializes the tokenLengths instance variable to
     * a TreeMap.
     */
    public TokenLengthsAnalyzer() {
        this.tokenLengths = new TreeMap<Integer, Integer>(); 
    }

    /**
     * One-arg constructor that calls the no-arg, to initialize the map, and
     * also initializes the Properties variable. 
     * 
     * @param properties object to assign to properties instance variable
     */
    public TokenLengthsAnalyzer(Properties properties) {
        this(); 
        this.properties = properties; 
    }

    /**
     * Getter method for the tokenLengths instance variable. 
     * 
     * @return tokenLengths, the lengths of tokens and their quantity
     */
    public Map<Integer, Integer> getTokenLengths() {
        return this.tokenLengths;
    }    

    /**
     * Getter method for the properties instance variable.
     * 
     * @return the properties object for the analyzer project
     */
    public Properties getProperties() {
        return this.properties; 
    }

    /**
     * Measures each token. If that token’s length exists in the map then 
     * increment its value. If the token’s length does not exist in the map, 
     * .put(token.length(), 1) 
     * 
     * @param token the token to analyze
     */
    public void processToken(String token) {

        int tokenLength = token.length(); 
        int count = getTokenLengths().containsKey(tokenLength)
                ? getTokenLengths().get(tokenLength)
                : 0; 

        // System.out.println("Token length: " + tokenLength + ". Count: " + count);
        getTokenLengths().put(tokenLength, ++count);

    }

    /**
     * Responsible for generating the output file for the lengths analyzer. 
     * Calls two helper methods that actually write to a printer
     * 
     * @param inputFilePath path to input file being analyzed
     */
    public void generateOutputFile(String inputFilePath) {

        // Set up the output writer 
        String outputFilePath = (getProperties().getProperty("output.directory")
        + getProperties().getProperty("output.file.token.lengths"));

        try (
            PrintWriter writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputFilePath)));
        ) {

            // Generate the simple output
            int highestValue = generateSimpleOutput(writer);

            // Generate the histogram portion
            // This is not passed the writer because it must append to the file,
            // so a new writer must be created.
            generateHistogram(highestValue, outputFilePath);

        } catch (IOException exc) {
            System.out.println("There was an IO Exception."); 
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong :("); 
            exc.printStackTrace();
        }


    } 

    /**
     * Generates the simple quantitative output: the length, followed by a tab, 
     * followed by the number of words of that length in the file.
     * 
     * @param writer the PrintWriter object opened in the generateOutputFile method 
     * @return the highest value in the map, for histogram
     */
    public int generateSimpleOutput(PrintWriter writer) {

        try {

            for (Map.Entry<Integer, Integer> current : getTokenLengths().entrySet()) {

                // Output the key and value of each entry in the map
                String currentKey = "" + current.getKey() + "\t"; 
                Integer currentValue = current.getValue(); 
                
                String line = currentKey + currentValue; 

                writer.println(line);

            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            // This closes the file because a new one is created to append
            // when writing the histogram.
            writer.println("\n");
            writer.close(); 

            Map.Entry<Integer, Integer> maxEntry = Collections.max(getTokenLengths().entrySet(),
                    (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) 
                    -> e1.getValue().compareTo(e2.getValue())); 

            //System.out.println("Key: " + maxEntry.getKey() + ". Value: " + maxEntry.getValue());
            
            return maxEntry.getValue(); 
        }

    }

    /**
     * Appends a histogram to the existing (from other generate method) output
     * file for this analyzer. Calculates what quantity each star represents
     * compared to the maximum stars (75) which represents the highestValue.
     *
     * @param highestValueInt the highest value, found in generateSimpleOutput
     * @param outputFilePath the output filepath, used to open the PrintWriter
     */
    public void generateHistogram(int highestValueInt, String outputFilePath) {

        final double MAX_COLUMNS = 75; // there are 5 spaces allotted for key\t
        double highestValueDouble = highestValueInt; // converted for int/float math

        // Ceil allows this to always generate at least one star (rounds up always)
        int valuePerStar = (int) Math.ceil((highestValueDouble / MAX_COLUMNS)); 

        try (
            PrintWriter writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputFilePath, true)));
        ) {

            for (Map.Entry<Integer, Integer> current : getTokenLengths().entrySet()) {

                String currentKey = "" + current.getKey(); 
                double currentQuantity = current.getValue(); // double for math
    
                // Since there will always be 1 star, round is sufficient here
                int numStars = (int) Math.round(currentQuantity / valuePerStar); 

                writer.print(currentKey + "\t");
    
                // Would this be more efficient to concat a string, and when 
                // that string was "done", print the whole string?
                for (int loop = 0; loop <= numStars; loop++) {
                    writer.print("*");
                }

                writer.println("");
    
            }
   

        } catch (IOException exc) {
            System.out.println("There was an IO Exception."); 
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong :("); 
            exc.printStackTrace();
        }

    }
}

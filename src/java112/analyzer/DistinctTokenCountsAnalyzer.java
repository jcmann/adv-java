package java112.analyzer;

import java.util.*; 
import java.io.*; 

/**
 * Generates an output file displaying each distinct token as well as 
 * the number of times that token appears in the file. 
 * 
 * @author jcmann
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {

    /**
     * Represents the properties file passed in by the user originally
     */
    private Properties properties; 

    /**
     * A Map containing each distinct token (as a String), and an Integer
     * as the value representing how many times that distinct token
     * appears in the file. 
     */
    private Map<String, Integer> distinctTokenCounts; 

    /**
     * No arg constructor. Will always initialize the instance variable
     * to contain a TreeMap of String/Integer key/value pairs for ordering.
     */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new TreeMap<String, Integer>(); 
    }

    /**
     * When a Properties file is passed in, as it should be, this 
     * will first call the default constructor to initialize the TreeMap
     * and then also initialize the properties instance variable. 
     * 
     * @param properties the properties object
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this(); 
        this.properties = properties; 
    }

    /**
     * The getter method for distinctTokenCounts. 
     * 
     * @return distinctTokenCounts the instance variable 
     */
    public Map<String, Integer> getDistinctTokenCounts() {
        return this.distinctTokenCounts; 
    }

    /**
     * This analyzer processes tokens using the compute method. It uses token
     * as a key, and basically checks to see if that key  exists with an
     * assigned value that is not null. If the value is null, that means
     * the key was not initialized so it should be added with a value 1. 
     * Otherwise, it will increment the current value. 
     * 
     * @param token the current token being analyzed in FileAnalysis
     */
    public void processToken(String token) {
        getDistinctTokenCounts().compute(token, 
                (key, value) -> (value == null) ? 1 : value + 1);
    }

    /**
     * Generates an output file displaying each key/value pair in the TreeMap.
     * Displayed with the key, a tab whitespace, then the value. 
     * 
     * @param inputFilePath input filepath specified by user initially
     */
    public void generateOutputFile(String inputFilePath) {

        PrintWriter writer = null; 

        try {
            // Instantiate a writer to actually generate the output file
            String outputPath = "" + (properties.getProperty("output.directory"))
                    + (properties.getProperty("output.file.distinct.counts")); 

            writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputPath)));

            // Write each entry to output file with formatting
            for (Map.Entry<String, Integer> entry : getDistinctTokenCounts().entrySet()) {
                // Format string: {key}\t{value}
                String outputLine = entry.getKey() + "\t" + entry.getValue(); 
                writer.println(outputLine); 
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

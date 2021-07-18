package java112.analyzer;
import java.util.*; 
import java.io.*; 

/**
 * Creates the report of all distinct tokens in the file.
 * 
 * @author jcmann
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    /**
     * A set containing all the distinct tokens of the file being analyzed 
     */
    private Set<String> distinctTokens;

    /**
     * PropertiesgetDistinctTokens() file originally specified by user on cli
     */
    private Properties properties; 

    /**
     * Empty constructor. Every instance will initialize a TreeSet
     * to the instance variable distinctTokens.
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<String>(); 
    }

    /**
     * One-arg constructor that also initializes the properties instance variable. 
     * 
     * @param properties Properties object based on path provided by  user
     */
    public DistinctTokensAnalyzer(Properties properties) {
        this(); 
        this.properties = properties; 
    }

    /**
     * A getter method for the distinctTokens instance variable. 
     * 
     * @return distinctTokens, the Set instance variable
     */
    public Set<String> getDistinctTokens() {
        return this.distinctTokens;
    }

    /**
     * Attempt to add the token to the Set
     * 
     * @param token the token to analyze, from FileAnalysis
     */
    public void processToken(String token) { 
 
        // Use the add method to add the token to the Set
        // This will automatically weed out duplicates, because of its type
        getDistinctTokens().add(token);

    }

    /**
     * Creates an output file containing, one per line, each of the
     * distinct tokens in the file being analyzed. This must be called 
     * after the tokens are processed, as it pulls from this class' 
     * instance variable, distinctTokens. 
     * 
     * @param inputFilePath path to input file
     */
    public void generateOutputFile(String inputFilePath) {
        
        PrintWriter writer = null; 

        try {
            // Instantiate a writer to actually generate the output file
            String outputPath = "" + (properties.getProperty("output.directory"))
                    + (properties.getProperty("output.file.distinct")); 

            writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputPath)));

            // Loop through the Set of distinctTokens, writing each to the output file
            for (String current : getDistinctTokens()) {
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

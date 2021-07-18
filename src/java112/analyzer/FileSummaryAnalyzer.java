package java112.analyzer;
import java.io.*; 
import java.util.*; 
import java.text.Format; 
import java.text.SimpleDateFormat; 

/**
 * Creates the summary report of the file analysis. 
 * 
 * @author jcmann
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {

    /**
     * No-argument constructor for the class. 
     */
    public FileSummaryAnalyzer() {

    }

    /**
     * One-arg constructor that initializes the properties instance variable
     * 
     * @param properties a Properties object 
     */
    public FileSummaryAnalyzer(Properties properties) {
        this.properties = properties; 
    }

    /**
     * Contains the analyzer properties file as a properties object.
     */
    private Properties properties; 

    /**
     * Contains the total number of tokens counted in the file analysis.
     */
    private int totalTokensCount; 

    /**
     * Getter method for the instance variable totalTokensCount. 
     * 
     * @return totalTokensCount, instance var 
     */
    public int getTotalTokensCount() {
        return totalTokensCount; 
    }

    /**
     * Maintains the count of the total number of tokens in the provided
     * file, from FileAnalysis. 
     * 
     * @param token the token to analyze, already verified to not be empty
     */
    public void processToken(String token) {
        totalTokensCount++; 
    } 

    /**
     * Converts time passed in as a long (representing time in milliseconds). 
     * A Date object is created from the parameter time, and is then processed
     * with a Format object according to app specifications. 
     * 
     * @param time the time in milliseconds 
     * @return date formatted according to specifications
     */
    public String convertTime(long time) {
        Date date = new Date(time); 
        Format format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");  
        //Thu Jan 11 16:21:28 CST 2018
        return format.format(date); 
    }

    /**
     * Creates an ArrayList of each line to be output to the 
     * output file. This output file is a report of general information, metadata,
     * about the file being analyzed.
     * 
     * @param inputFilePath path to input file
     */
    public void generateOutputFile(String inputFilePath) {
        
        // Set information about the app author
        String appName = properties.getProperty("application.name"); 
        String appAuthorName = properties.getProperty("author");
        String appAuthorEmail = properties.getProperty("author.email.address");

        PrintWriter writer = null; 

        try {
            // Instantiate a File object of the input file provided
            File inputFileObject = new File(inputFilePath);

            // Collect metadata about the provided file into variables
            String absolutePath = inputFileObject.getAbsolutePath();
            String lastModified = convertTime(inputFileObject.lastModified());
            String size = "" + inputFileObject.length();
            String uri = "" + inputFileObject.toURI(); 

            // Get the current time, which is the time/date of the analysis
            String analysisDateTime = convertTime(System.currentTimeMillis()); 
             
            // Add collected information to an ArrayList
            ArrayList<String> report = new ArrayList<String>(); 
            report.add("Application: " +  appName); 
            report.add("Author: " +  appAuthorName); 
            report.add("Author email: " + appAuthorEmail); 
            report.add("File: " + absolutePath);
            report.add("Date of analysis: " + analysisDateTime); 
            report.add("Last Modified: " +  lastModified); 
            report.add("File Size: " + size); 
            report.add("File URI: " + uri); 
            report.add("Total Tokens: " + getTotalTokensCount());

            // Instantiate a writer to actually generate the output file
            String outputPath = "" + (properties.getProperty("output.directory"))
                    + (properties.getProperty("output.file.summary")); 

            writer = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputPath)));

            for (String current : report) {
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

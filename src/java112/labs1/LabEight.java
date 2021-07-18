package java112.labs1;
import java.util.*; 
import java.io.*; 

/**
 * Work with the Set interface, and the TreeSet concrete implementation. 
 * 
 * @author jcmann
 */
public class LabEight {

    private SortedSet<String> myStrings; // declare, but not initialized 

    /**
     * Initialize the instance variable to contain a TreeSet, add values, then 
     * call an output writing method to show how TreeSet works.
     * 
     * @param outputFileName the output path
     */
    public void run(String outputFileName) {

        // Initialize myStrings 
        myStrings = new TreeSet<String>(); 

        // Add ten values with duplicates in a weird order
        myStrings.add("one");
        myStrings.add("one");
        myStrings.add("five");
        myStrings.add("two");
        myStrings.add("four");
        myStrings.add("two");
        myStrings.add("three");
        myStrings.add("three");
        myStrings.add("four");
        myStrings.add("three");

        writeSetToOutputFile(outputFileName); 

    }

    /**
     * Called from run() to actually write the output to a file 
     * 
     * @param outputFileName the provided output file path 
     */
    public void writeSetToOutputFile(String outputFileName) {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)))) {
            // Loop through instance variable, outputting each to file

            for (String current : myStrings) {
                writer.println(current); 
            }

        } catch (IOException ioException) {
            System.out.println("IO Exception"); 
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong."); 
            exception.printStackTrace();
        }

    }

    /**
     * Main method to verify necessary args exist, and call LabEight.run()
     * on an instance of LabEight
     * 
     * @param args command line args, used here and 1 required (output file name)
     */
    public static void main(String[] args) {

        //final String PATH = "io/week04/"; // organizes output to directory

        if (args.length == 1) {
            // Capture to variable for clarity
            String outputFileName = /*PATH + */ args[0]; // directs to output dir with path

            // Instantiate and run LabEight
            LabEight lab = new LabEight(); 
            lab.run(outputFileName); 
        } else {
            System.out.println("Please enter one argument on the command line, "
                    + "an output file name"); 
        }
        
    }
    
}

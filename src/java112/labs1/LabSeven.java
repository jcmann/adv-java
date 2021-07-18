package java112.labs1;
import java.util.*; 
import java.io.*; 

/**
 * Work with List interface, ArrayList concrete class
 * 
 * @author jcmann
 */
public class LabSeven {

    private List<String> myStrings; // defined, not initialized instance var

    /**
     * Initializes myStrings instance variable to contain an ArrayList with 
     * ten elements, added here. Calls writeListToOutputFile. 
     * 
     * @param outputFileName the output file name
     */
    public void run(String outputFileName) {
        // System.out.println(outputFileName);

        myStrings = new ArrayList<String>(); // assign AL to instance var

        // Add elements
        myStrings.add("one"); 
        myStrings.add("two");
        myStrings.add("three");
        myStrings.add("four");
        myStrings.add("five");
        myStrings.add("six");
        myStrings.add("seven");
        myStrings.add("eight");
        myStrings.add("nine");
        myStrings.add("ten");

        writeListToOutputFile(outputFileName); 
    }

    /**
     * Creates a PrintWriter object to write to the specified outputFileName 
     * 
     * @param outputFileName the name of the output file
     */
    public void writeListToOutputFile(String outputFileName) {

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
     * Main method validates quantity of arguments, instantiates an instance
     * of LabSeven, and calls its run method. 
     * 
     * @param args command line args, used here
     */
    public static void main(String[] args) {
        
        //final String PATH = "io/week04/"; // organizes output to directory

        // 1 arg expected, the output file name 
        if (args.length == 1) {
            String outputFileName = /*PATH +*/ args[0]; 
            LabSeven lab = new LabSeven(); 
            lab.run(outputFileName); 
        } else {
            System.out.println("Please enter one argument on the command line, "
                    + "an output file name"); 
        }

    }
    
}

package java112.labs1; 
import java.io.*; 
/**
 * Contains all code for lab four to demonstrate file reading 
 * 
 * @author jcmann
 */
public class LabFour {

    /**
     * Main method confirms args are present, and calls the run method 
     * 
     * @param args command line args, used here
     */
    public static void main(String[] args) {

        // Program expects one command line input
        if (args.length == 1) {
            LabFour instance = new LabFour(); 
            instance.run(args[0]); 
        } else {
            System.out.println("Please enter one argument on the command line"); 
        }
        
    }

    /**
     * Called from main method. Opens an input file and outputs its contents
     * to the terminal window. 
     * 
     * @param fileName the name of the input file
     */
    public void run(String fileName) {

        // Initialized in try block for resource protection 
        BufferedReader reader = null; 

        try {
            reader = new BufferedReader(new FileReader(fileName));
        
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found"); 
            fileNotFoundException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong."); 
            exception.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close(); 
                }
            } catch (Exception exception) {
                System.out.println("Something went wrong."); 
                exception.printStackTrace();
            }
        }

    }
    
}

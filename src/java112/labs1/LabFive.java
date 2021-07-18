package java112.labs1; 
import java.io.*; 

/**
 * Lab 5 demonstrates using Writer methods for output 
 * 
 * @author jcmann
 */
public class LabFive {

    /**
     * Confirms necessary args are present before calling run()
     * 
     * @param args command line args 
     */
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, " 
                    + "a file name and a message"); 
        } else {
            LabFive lab = new LabFive(); 

            String file = args[0]; 
            String message = args[1]; 

            lab.run(file, message); 
        }
    
    }

    /**
     * Opens a file to write to, and writes the message to that file 
     * 
     * @param file the file path to write to
     * @param message the message to write to the file
     */
    public void run(String file, String message) {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            writer.println(message); 
        } catch (IOException ioException) {
            System.out.println("IO Exception"); 
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong.");
            exception.printStackTrace();
        }

    }
    
}

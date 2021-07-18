package java112.labs1;
import java.io.*; 
/**
 * Lab Six demonstrates usage of both input and output
 * 
 * @author jcmann
 */
public class LabSix {

    /**
     * Main confirms the proper arguments are present, initializes LabSix, 
     * then calls the run method on that instance. 
     * 
     * @param args command line args 
     */
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, "
                    + "an input file name and an output file name");  
        } else {
            LabSix lab = new LabSix();
            
            // Saving args to pass in. First is input, second is output
            String inputFile = args[0]; 
            String outputFile = args[1]; 

            lab.run(inputFile, outputFile); 
        }
        
    }

    /**
     * Opens an input file path to read and an output file path to write. 
     * Loops through the input line by line and writes each line to output. 
     * Concludes by closing the file. 
     * 
     * @param inputFile path to input file
     * @param outputFile path to output file
     */
    public void run(String inputFile, String outputFile) {

        // try with resources to save a finally block 
        try (
                BufferedReader input = new BufferedReader(new FileReader(inputFile)); 
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))
        ) {

            // Loop through each line of input, and append each line to output
            String line = null; 
            while (input.ready()) {
                line = input.readLine(); 
                writer.println(line);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found."); 
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("IO Exception");
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong.");
            exception.printStackTrace();
        }

    }
    
}

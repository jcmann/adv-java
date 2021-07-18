package java112.demos.week03; 
import java.io.*; 
/**
 * Demonstrate reading a text file and displaying each file line
 * to the console
 * 
 * @author jcmann
 */

public class ReadDemoWithResources {

    /**
     * Main method containing all of the necessary demo code 
     * Use BufferedReader to read file line by line, and output each 
     * to the console 
     * 
     * @param args command line args 
     */
    public static void main(String[] args) {

        try  (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {

            while (reader.ready()) {
                System.out.println(reader.readLine()); 
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File was not found");
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("Line was not found."); 
            ioException.printStackTrace(); 
        } catch (Exception exception) {
            System.out.println("Something went wrong."); 
            exception.printStackTrace(); 
        }
         
        
    }
    
}
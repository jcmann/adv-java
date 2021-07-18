package java112.demos.week03;
import java.io.*; 

/**
 * Demonstrate writing a file
 * 
 * @author jcmann
 */

public class WriteDemo {

    /** 
     * Create a file and write to it
     * 
     * @param args command line args
     */
    public static void main(String[] args) {
        
        // Declare outside try for closing purposes
        PrintWriter writer = null; 
        
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt"))); 
            writer.println("Hello"); 
            writer.println("World");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found."); 
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("IO Exception"); 
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong"); 
            exception.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close(); 
            }
        }

    }
    
}

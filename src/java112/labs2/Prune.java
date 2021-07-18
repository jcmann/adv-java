package java112.labs2;

import java.io.*; 
import java.util.*; 

public class Prune {

    public static void main(String[] args) {

        try (
            BufferedReader reader = new BufferedReader(new FileReader("io/project02/lexicalWords.txt"));
            PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter("io/project02/lexicalWords2.txt")));
        ) {

            while (reader.ready()) {
                String line = reader.readLine(); 
                String[] currentLineTokens = line.split("\\W");
                writer.println(currentLineTokens[0]); 
            }

        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
         
        
    }
    
}

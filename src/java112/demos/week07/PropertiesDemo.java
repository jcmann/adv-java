package java112.demos.week07; 

import java.util.*; 
import java.io.*; 

/**
 * Demonstrate use of the Properties class
 * 
 * @author jcmann
 */
public class PropertiesDemo {

    /**
     * Start the properties demo
     * 
     * @param args command line args (not used here)
     */
    public static void main(String[] args) {
        PropertiesDemo demo = new PropertiesDemo(); 
        demo.run(); 
    }

    /**
     * Create a Properties object, load properties, and display them 
     * to the console.
     */
    public void run() {

        // Instantiate a Properties object 
        Properties properties = new Properties(); 

        // Load properties 
        // Read in the properties file, parse it, then make it available 
        try {
            properties.load(this.getClass().getResourceAsStream("/demo/demo.properties"));
            
        } catch (IOException exc) {
            System.out.println("There was an IO Exception."); 
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong."); 
            exc.printStackTrace();
        }

        System.out.println("Author property: " + properties.getProperty("author"));       
         
        // Get all the properties
        Set<String> propertyNames = properties.stringPropertyNames(); 

        // Display properties 
        System.out.println(propertyNames); 

        // Display key/value pairs 
        for (String key : propertyNames) {
            System.out.println("Key: " + key); 
            System.out.println("Value: " + properties.getProperty(key)); 
        }

    }

}
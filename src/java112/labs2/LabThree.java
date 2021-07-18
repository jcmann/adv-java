package java112.labs2;

import java.util.*; 
import java.io.*; 

/**
 * Unit 2 - Lab 3. Demonstrates how to use Properties class.  
 * 
 * @author jcmann
 */
public class LabThree {

    /**
     * Contains the properties for the instance of LabThree being run.
     */
    private Properties properties; 

    /**
     * A Getter method that returns the properties instance variable. 
     * 
     * @return properties instance variable
     */
    public Properties getProperties() {
        return this.properties; 
    }

    /**
     * Instantiates an instance of LabThree then calls its run method. 
     * 
     * @param args command line args, should have 1 for properties file 
     */
    public static void main(String[] args) {

        if (args.length == 1) {
            LabThree lab = new LabThree(); 
            lab.run(args[0]);
        } else {
            System.out.println("Please enter one config file path."); 
        }
        
    }

    /**
     * Initializes the properties variable to point to the passed-in path, 
     * and loads all the properties in that file. 
     * 
     * @param propertiesFilePath the path to the properties file
     */
    public void loadProperties(String propertiesFilePath)  {
        this.properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioe) {
            System.out.println("Can't load the properties file");
            ioe.printStackTrace();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Calls loadProperties() to instantiate the properties instance variable
     * and load all properties, then displays these properties. 
     * 
     * @param propertiesFilePath the path to the props file being used
     */
    public void run(String propertiesFilePath) {
        loadProperties(propertiesFilePath);

        // Collect all the properties
        Set<String> propertyNames = properties.stringPropertyNames();
        
        // Display all properties and values 
        for (String key : propertyNames) {
            System.out.println("Key: " + key); 
            System.out.println("Value: " + properties.getProperty(key)); 
        }
        
    }
    
}

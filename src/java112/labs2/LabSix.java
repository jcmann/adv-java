package java112.labs2;

import java.util.*; 
import java.io.*; 
import java112.utilities.PropertiesLoaderInterface;

/**
 * Unit 2 - Lab 3. Demonstrates how to use Properties class.  
 * 
 * @author jcmann
 */
public class LabSix implements PropertiesLoaderInterface {

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
     * @param args command line args, needs 1 path to properties file
     */
    public static void main(String[] args) {

        if (args != null &&  args.length == 1) {
            LabSix lab = new LabSix(); 
            lab.run(args[0]);
        } else {
            System.out.println("Please enter one config file path."); 
        }
        
    }

    /**
     * Calls loadProperties() to instantiate the properties instance variable
     * and load all properties, then displays these properties. 
     * 
     * @param propertiesFilePath the path to the properties file
     */
    public void run(String propertiesFilePath) {
        properties = loadProperties(propertiesFilePath);

        if (properties != null) {
            // Collect all the properties
            Set<String> propertyNames = properties.stringPropertyNames();
            
            // Display all properties and values 
            for (String key : propertyNames) {
                System.out.println("Key: " + key); 
                System.out.println("Value: " + properties.getProperty(key)); 
            }
        } else {
            System.out.println("There was an error loading the properties."
                    + " Please make sure the properties filepath is correct."); 
        }
        
    }
    
}

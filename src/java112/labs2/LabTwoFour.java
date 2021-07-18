package java112.labs2;

import java.util.*; 
import java.io.*; 

/**
 * Demonstrate knowledge of Map interface and its HashMap and TreeMap
 * implementations. 
 * 
 * @author jcmann
 */
public class LabTwoFour {

    /**
     * Intended to contain a HashMap, set up in run() method and beyond.
     */
    protected Map<String, Integer> hashMap; 

    /**
     * The second Map type used in this lab, a TreeMap object. 
     */
    protected Map<String, Integer> treeMap; 

    /**
     * Main method that instantiates a LabTwoFour object and calls its
     * run method. 
     * 
     * @param args command line args, used here
     */
    public static void main(String[] args) {

        LabTwoFour lab = new LabTwoFour(); 
        lab.run(); 
        
    }

    /**
     * Instantiates the two instance variables, adding to them and 
     * printing them out in various ways. 
     */
    public void run() {

        // Instantiate the hashMap 
        hashMap = new HashMap<String, Integer>(); 

        // Add entries to the map 
        hashMap.put("One", 1); 
        hashMap.put("Two", 2); 
        hashMap.put("Three", 3); 
        hashMap.put("Ten", 10); 

        // Loop through the map, printing all key/value pairs 
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.print("Key: " + entry.getKey()); 
            System.out.println(". Value: " + entry.getValue());
        }

        // Print the map itself 
        System.out.println("hashMap: " + hashMap); 

        // Use containsKey to see if the key "Three" exists, output result
        System.out.println(
            (hashMap.containsKey("Three")) 
                    ? "Key: Three. Value: " + hashMap.get("Three")
                    : "Key not found." 
        ); 

        // Instantiate treeMap using hashMap in its constructor 
        treeMap = new TreeMap<String, Integer>(hashMap); 

        // Display the treeMap (will display in natural order by key, alphabetical)
        System.out.println("treeMap: " + treeMap); 
        
    }
    
}

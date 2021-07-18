package java112.demos.week07;

import java.util.*; 
import java.io.*; 

public class MapDemo {

    public static void main(String[] args) {
        MapDemo demo = new MapDemo(); 
        demo.run(); 
    }

    public void run() {
        // Create a HashMap object 
        Map<Integer, String> myMap = new HashMap<Integer, String>(); 

        // Add key/value pairs 
        myMap.put(2, "two"); 
        myMap.put(1, "hello"); 
        myMap.put(10, "goodbye");
        myMap.put(5, "butt;");

        // Tostring is implemented on those wrapper classes
        // So printing them out is straightforward 
        System.out.println(myMap); 

        // .entrySet returns a Set of Map.Entry
        // Each thing in the Set is a Map.Entry
        for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
            System.out.println("Key: " + entry.getKey()); 
            System.out.println("Value: " + entry.getValue()); 
        }
    }
    
}

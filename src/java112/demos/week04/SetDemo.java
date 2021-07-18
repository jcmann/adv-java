package java112.demos.week04;
import java.util.*; 

/**
 * Demonstrate using the Set Interface and HashSet concrete class 
 * 
 * @author jcmann
 */

public class SetDemo {

    /**
     * Create a set, add strings to it, and display 
     * 
     */
    public void run() {
        Set<String> set = new HashSet<String>();
        set.add("one"); 
        set.add("one"); 
        set.add("123");
        set.add("two");
        set.add("three"); 

        System.out.println(set); 

        for (String element : set) {
            System.out.println(element); 
        }
    }
    
    /**
     * Instantiate demo class and start it running
     * 
     * @param args command line args, not used 
     */
    public static void main(String[] args) {
        
        SetDemo demo = new SetDemo(); 
        demo.run(); 
        
    }
}

package java112.demos.week04;
import java.util.*; 

/**
 * Demonstrate instance vs local variables
 * 
 * @author jcmann
 */
public class InstanceVarDemo {

    List<String> myList; // defines an instance variable

    public static void main(String[] args) {
        InstanceVarDemo demo = new InstanceVarDemo(); 
        demo.run(); 
    }

    public void run() {
        myList = new ArrayList<String>(); 

    }
    
}

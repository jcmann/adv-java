package java112.labs1; 

/**
 * For lab three, demonstrate using command line input 
 * 
 * @author jcmann
 */
public class LabThree {

    /**
     * Main method to control and run components of the lab 
     * 
     * @param args command line args
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line"); 
        } else {
            LabThree demo = new LabThree(); 
            demo.run(args[0]); 
        }

    }

    /**
     * Run 
     * 
     * @param myString the string being input 
     */
    public void run(String myString) {
        //String input = "test";

        System.out.println("input: " + myString); 

    }
    
}

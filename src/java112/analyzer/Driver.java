package java112.analyzer;

/**
 * Instantiates Analyzer's main processing class, and calls its main()
 * 
 * @author jcmann
 */
public class Driver {

    /**
     * Instantiate an instance of FileAnalysis, and call its run(). 
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // instantiate FileAnalysis
        FileAnalysis instance = new FileAnalysis(); 

        // run main processing class
        instance.analyze(args); 
        
    }
    
}

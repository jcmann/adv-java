package java112.analyzer;

/**
 * An interface whose methods, when implemented, perform an analysis. 
 * 
 * @author jcmann
 */
public interface TokenAnalyzer {

    /**
     * Abstract method that must be implemented by an analyzer to actually
     * process, according to specification, the token.
     * 
     * @param token the token to analyze
     */
    void processToken(String token); 

    /**
     * Generates whatever output file is required by specs. Must be implemented. 
     * 
     * @param inputFilePath path to input file
     */
    void generateOutputFile(String inputFilePath); 
    
}

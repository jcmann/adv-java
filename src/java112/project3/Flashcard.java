package java112.project3;

import java.util.*; 

public class Flashcard {

    private String term;

    private String definition; 

    private int unit;

    public Flashcard() {
    }

    public Flashcard(String term, String definition, int unit) {
        super(); 
        this.term = term; 
        this.definition = definition; 
        this.unit = unit; 
    }

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return this.definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getUnit() {
        return this.unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String toString() {
        return "Term: " + getTerm() + ". Definition: " + getDefinition()         
                + " Unit: " + getUnit();  
    }

    /**
     * Used for the MVC team challenge. 
     * This generates four flashcards, adds them to an ArrayList, then returns
     * that ArrayList to the Study servlet. 
     * 
     * @return flashcards, a list of flashcards
     */
    public static List<Flashcard> generateStudySet() {

        Flashcard card1 = new Flashcard("ANT", 
                "Another Neat Tool, a Java library for building Java projects", 1); 
        Flashcard card2 = new Flashcard("HTTP", "HyperText Transfer Protocol for "
                + "browser requests and server responses.", 2); 
        Flashcard card3 = new Flashcard("Servlet", "A Java class that handles " 
                + "browser requests by sending responses with data.", 2); 
        Flashcard card4 = new Flashcard("JSP", "Java Server Page, server-compiled " 
                + "webpages.", 3);

        ArrayList<Flashcard> flashcards = new ArrayList<Flashcard>(); 
        flashcards.add(card1);
        flashcards.add(card2);
        flashcards.add(card3);
        flashcards.add(card4);
        
        return flashcards; 

    }
    
}

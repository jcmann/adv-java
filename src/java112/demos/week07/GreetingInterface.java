package java112.demos.week07;

public interface GreetingInterface {

    default String createGreeting(String person, String greeting) {
        return greeting + ", " + person + "!"; 
    }
    
}

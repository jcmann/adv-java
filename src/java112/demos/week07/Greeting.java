package java112.demos.week07;

public class Greeting implements GreetingInterface {
    
    public static void main(String[] args) {
        Greeting greeting = new Greeting(); 
        System.out.println(greeting.createGreeting("John Smith", "Hello"));
    }
}

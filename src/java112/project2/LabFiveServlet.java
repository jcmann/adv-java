package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.util.*; 
import java.text.Format; 
import java.text.SimpleDateFormat; 

/**
 * A servlet for unit 2, lab 5. Demonstrate how to set up and configure
 * a Servlet and its init and do methods. 
 * 
 * @author jcmann
 */
@WebServlet(
    name = "lab5", 
    urlPatterns = { "/lab5" }
)
public class LabFiveServlet extends HttpServlet {

    /**
     * The init method initializes this to reflect when the servlet was turned
     * on via ant tcup. 
     */
    private String initializedTimestamp; 

    /**
     * Sets the instance variable initializedTimestamp. Called from init(); 
     */
    public void setInitializedTimestamp() {
        long currentTimestamp = System.currentTimeMillis(); 
        this.initializedTimestamp = convertTime(currentTimestamp);
    }

    /**
     * Returns the instance variable initializedTimestamp. 
     * 
     * @return initializedTimestamp, instance variable 
     */
    public String getInitializedTimestamp() {
        return this.initializedTimestamp; 
    }
    
    /**
     * Overrides the superclass' init method by calling the superclass' 
     * method and then logs a message. 
     * 
     * @throws ServletException servlet failure 
     */
    public void init() throws ServletException {

        super.init(); 

        log("LabFiveServlet is executing init()."); 

        setInitializedTimestamp(); 
        log("Time initialized: " + getInitializedTimestamp());
    
    }

    /**
     * Handles HTTP GET requests. 
     * 
     * @param request the HTTPServletRequest object
     * @param response the HTTPServletResponse object, developed here
     * @throws ServletException servlet failure
     * @throws IOException an error with input/output procedures. 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        log("LabFiveServlet is executing doGet");
        incrementCounter(); 

        response.setContentType("text/html");

        // Write HTML output 
        try (PrintWriter out = response.getWriter();) {
            // Table of three data points
            out.print("<table><tr><th>Date/Time Initialized:</th>"); 
            out.print("<td>" + getInitializedTimestamp() + "</td></tr>"); 
            out.print("<tr><th>Current Time:</th><td>" + convertTime(System.currentTimeMillis())
                    + "</td>");
            out.print("<tr><th>Total Hits:</th><td>" + getCounter() + "</td></tr>");
            out.print("</table>");

            // Answer two questions about logs below table
            out.print("<ol>"); 
            out.print("<li>Prior to actually opening this in the browser, "
                    + "neither log() executed. Only catalina was updated.</li>");
            out.print("<li>Both log()s execute to the localhost output after"
                    + " being accessed in the browser.</li>"); 
            out.print("</ol>");
        } catch (IOException exc) {
            System.out.println("There was an IOException."); 
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong!"); 
            exc.printStackTrace();
        }

    }

    /**
     * Converts time passed in as a long (representing time in milliseconds). 
     * A Date object is created from the parameter time, and is then processed
     * with a Format object according to app specifications. 
     * 
     * @param time the time in milliseconds 
     * @return date formatted according to specifications
     */
    public String convertTime(long time) {
        Date date = new Date(time); 
        Format format = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");  
        //Thu Jan 11 16:21:28 CST 2018
        return format.format(date); 
    }

    /**
     * Used to maintain the hit counter for this lab's servlet. Contains a 
     * try-with-resources block that creates reader and writer objects to 
     * read from a txt file containing the counter, then increments that value,
     * and updates the file to contain the new, updated counter. 
     */
    public void incrementCounter() {

        // get counter by reading from file and immediately close it
        int counter = getCounter(); 
        log("Counter: " + counter);

        // increment counter
        counter++; 
        log("Counter after increment: " + counter); 

        // write output 
        updateCounter(counter); 

    }

    /**
     * This method returns an int representing the current number of hits for
     * the servlet. It does so by reading from the file that contains that
     * counter. All exceptions handled in this method.
     * 
     * @return counter, the previous number of hits not including the current
     */
    public int getCounter() {

        BufferedReader reader = null; 
        int counter = 0; 

        try {

            reader = new BufferedReader(new FileReader("io/week06/hitCounter.txt"));

            if (reader.ready()) {
                counter = Integer.parseInt(reader.readLine());
                log("" + counter); 
            }


        } catch (FileNotFoundException exc) {
            System.out.println("The file was not found."); 
            exc.printStackTrace();
        } catch (IOException exc) {
            System.out.println("There was an IOException."); 
            exc.printStackTrace();
        } catch (Exception exc) {
            System.out.println("Something went wrong."); 
            exc.printStackTrace();
        } finally {

            try {
                if (reader != null) {
                    reader.close(); 
                }
            } catch (Exception exception) {
                System.out.println("Something went wrong."); 
                exception.printStackTrace();
            }

            return counter; 
        }
    }

    /**
     * This method writes the passed in counter variable to the hitCounter.txt
     * output file. The output should have been incremented prior to this
     * method being called.
     * 
     * @param counter the current counter, as in including the current hit
     */
    public void updateCounter(int counter) {

        try (PrintWriter writer = 
                new PrintWriter(new BufferedWriter(new FileWriter("io/week06/hitCounter.txt", false)))) {
            writer.println(counter); 
        } catch (IOException ioException) {
            System.out.println("IO Exception"); 
            ioException.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Something went wrong.");
            exception.printStackTrace();
        }

    }

}

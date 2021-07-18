package java112.project4;
  
import java.io.*;
import java.util.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
  
/**
 * This servlet retrieves data submitted by the forms lab, lab41.jsp, 
 * and outputs it to the browser. 
 *
 *@author    jcmann
 */
@WebServlet(
     name = "lab41Servlet", 
     urlPatterns = { "/Lab41Servlet" }
)
public class Lab41Servlet extends HttpServlet {
  
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
        throws ServletException, IOException {
  
        // General setup
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Access the form parameters
        String firstName = request.getParameter("firstName"); 
        String lastName = request.getParameter("lastName");
        String favoriteAnimal = request.getParameter("favoriteAnimal"); 
        String[] osArray = request.getParameterValues("os"); 

        // Convert the array of checkbox values to something more readable
        String osUsed = "";
        int loopIndex = 0; 
        for (String current : osArray) {
            if (loopIndex != osArray.length - 1) {
                osUsed += current + ", ";
            } else {
                osUsed += current;
            }
            
            loopIndex++; 
        }
  
        // Display information 
        out.print("<html><head></head><body><h1>Forms Lab Servlet</h1>");

        out.print("<dl><dt>First Name</dt><dd>" + firstName + "</dd>");
        out.print("<dt>Last Name</dt><dd>" + lastName + "</dd>"); 
        out.print("<dt>Favorite Animal</dt><dd>" + favoriteAnimal + "</dd>"); 
        out.print("<dt>Operating System(s) Used</dt><dd>" + osUsed + "</dd></dl>"); 
  
  
        out.print("</body></html>");
        out.close();
    }
  
}
  
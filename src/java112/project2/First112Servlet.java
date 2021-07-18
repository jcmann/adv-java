package java112.project2;

import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Generates HTML that contains information about the author, the course, and 
 * an image. 
 * 
 * @author jcmann
 */
@WebServlet(
    name="first112Servlet", 
    urlPatterns = {"/first112Servlet"}
)
public class First112Servlet extends HttpServlet {          

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();

        String header = "<header><h1>First112Servlet</h1>"
                + "<nav><ul><li>"
                + "<a href='/java112'>Home</a>"
                + "</li></ul></nav></header>"; 

        String imgPath = "images/java-logo.png"; 

        out.print("<HTML>");
        out.print("<HEAD><TITLE>First 112 Servlet</TITLE></HEAD>");
        out.print("<BODY>");
        out.print(header);
        out.print("<main><section><p><strong>My Name:</strong> Jen Mann</p>"); 
        out.print("<p><strong>Course:</strong> Java 112: Advanced Java"); 
        out.print("<p><img src='" + imgPath + "' width='100px'></p>");
        out.print("</main></BODY>");
        out.print("</HTML>");
        out.close();
    }
    
}

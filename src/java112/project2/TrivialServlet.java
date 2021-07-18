package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
@WebServlet(
    name = "trivialServlet", 
    urlPatterns = { "/trivial" }
)
public class TrivialServlet extends HttpServlet {

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

        String header = "<header><h1>Jen Was Here!</h1>"
                + "<nav><ul><li>"
                + "<a href='/java112/trivial'>Home</a>"
                + "</li></ul></nav></header>"; 

        String imgPath = "images/cat.jpg"; // this works!
        // tried: java112/trivial/cat.jpg, java112/project2/cat.jpg
        // also tried moving to public_html/images and cat.jpg and images/cat.jpg

        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print(header);
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("<img src='" + imgPath + "' width='500px'>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }

}


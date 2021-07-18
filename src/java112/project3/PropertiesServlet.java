package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*; 
import java112.utilities.PropertiesLoader;

/**
 *  Displays the properties for this project (3) on a JSP. 
 *
 *@author    jcmann
 */
@WebServlet(
    name = "project3PropertiesServlet", 
    urlPatterns = { "/project3-properties" }
)
public class PropertiesServlet extends HttpServlet implements PropertiesLoader {

    /**
     * The Properties object for this project. 
     */
    private Properties properties; 

    /**
     * Overrides the default init method. Ensures that the Properties instance
     * variable is set to the intended properties file. 
     */
    public void init() {
        this.properties = loadProperties("/project3.properties");
    }

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
        
        // add properties to the request as an attribute 
        request.setAttribute("properties", this.properties);

        // Forward to a JSP
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/project3-properties.jsp");
        dispatcher.forward(request, response);
    }

}


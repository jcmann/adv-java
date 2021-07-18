package java112.project2;

import java.util.*; 
import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java112.utilities.PropertiesLoader;

/**
 * Maintains the properties for project 2. 
 * 
 * @author jcmann
 */
@WebServlet(
    name="project2Properties", 
    urlPatterns = {"/project2Properties"}
)
public class ProjectProperties extends HttpServlet implements PropertiesLoader {

    protected Properties properties; 

    /**
     *  Overrides the init method when servlet is launched. Sets the properties
     * to a dedicated properties file for the web app part of project 2. 
     */
    public void init() throws ServletException {
        this.properties = loadProperties("/project2.properties");
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
        // set the response type before sending data
        PrintWriter out  = response.getWriter();

        String htmlHead = "<html><head><title>Project Properties Servlet</title>"
                + "<link rel='stylesheet' href='css/project2.css'></head>"; 

        String header = "<header><h1>Project Properties Servlet</h1>"
                + "<nav><ul><li>"
                + "<a href='/java112'>Home</a>"
                + "</li></ul></nav></header>"; 

        out.print(htmlHead);
        out.print(header);
        out.print("<body><main>"); 
        generatePropertiesTable(out); 
        out.print("</main></body></html>");
        out.close();
    }

    /**
     * Called from doGet to outsource the generation
     *  
     * @param out the PrintWriter generating output 
     */
    public void generatePropertiesTable(PrintWriter out) {

        // Collect all the property names, to access all property info
        Set<String> propertyNames = this.properties.stringPropertyNames();

        // Build table
        out.print("<table><thead><tr><th>Property Name</th>"
                +"<th>Property Value</th></tr></thead><tbody>");

        for (String key : propertyNames) {
            out.print("<tr><td>" + key + "</td>"); 
            out.print("<td>" + this.properties.getProperty(key)
                    + "</td></tr>"); 
        }

        out.print("</tbody></table>"); 
        
    }
    
}

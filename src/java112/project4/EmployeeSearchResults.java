package java112.project4; // todo does this need to go in project4..? 

import java112.utilities.PropertiesLoader;
import java112.employee.*; 

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Receives the data from the employee search form, and handles the 
 * process of querying for that data.  
 *
 * @author   jcmann
 */
@WebServlet(
        name = "employeeSearchResults",
        urlPatterns = { "/employeeSearchResults" }
)
public class EmployeeSearchResults extends HttpServlet implements PropertiesLoader {

    /**
     * Handles GET requests for this servlet, which will contain data 
     * submitted by the user via form. This method processes that data, 
     * and handles querying the database for that data. 
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get scopes used for this method
        ServletContext servletContext = getServletConfig().getServletContext();
        HttpSession session = request.getSession(); 

         // Get the employeeDirectory from the servlet context
        EmployeeDirectory employeeDirectory = 
                (EmployeeDirectory) servletContext.getAttribute("employeeDirectory");

        // Get search type and term from HTML form submission 
        String searchTerm = request.getParameter("searchTerm"); 
        String searchType = request.getParameter("searchType"); 

        // Search for employees via employeeDirectory and add to session
        Search search = employeeDirectory.search(searchTerm, searchType);
        session.setAttribute("search", search); 
        

        //Forward to jsp page
        String url = "/employeeSearchResults.jsp"; 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}


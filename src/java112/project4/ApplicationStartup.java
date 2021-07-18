package java112.project4;

import java112.utilities.PropertiesLoader;
import java112.employee.*; 

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Performs initialization for employee directory application.
 *
 *@author   jcmann
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    /**
     * Overridden init method. This runs on startup to set up the necessary
     * Properties and EmployeeDirectory objects within the servlet context.
     *
     * @throws ServletException standard exception for servlets, not handled here
     */
    public void init() throws ServletException {

        // Create a Properties object and load the project4.properties file
        Properties properties = loadProperties("/project4.properties");

        // Create an EmployeeDirectory instance with Properties parameter
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);

        // Place both Properties and EmployeeDirectory into ServletContext
        ServletContext servletContext = getServletConfig().getServletContext();
        servletContext.setAttribute("project4Properties", properties);
        servletContext.setAttribute("employeeDirectory", employeeDirectory);

    }

}


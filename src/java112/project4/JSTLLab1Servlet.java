package java112.project4;

import java.io.*;
import java.util.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Part 3 of Lab 4-2. Creates a list of Strings, adds this to the request, 
 * forwards the request to a JSP, which then displays those strings.
 *
 *@author jcmann
 */
@WebServlet(
        name = "lab4-2",
        urlPatterns = { "/lab4-2" }
)
public class JSTLLab1Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create the list of strings
        ArrayList<String> plantNames = new ArrayList<String>(); 
        plantNames.add("Burro's Tail"); 
        plantNames.add("Dwarf Palm"); 
        plantNames.add("Aloe Vera"); 

        // Set attribute and forward
        request.setAttribute("list", plantNames);

        String url = "/jstl-lab2.jsp"; 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.forward(request, response); 
    
    }

}


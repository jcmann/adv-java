package java112.project4;

import java.io.*;
import java.util.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet exists solely to forward to the addEmployee.jsp page. 
 *
 *@author   jcmann
 */
@WebServlet(
        name = "addEmployee",
        urlPatterns = { "/addEmployee" }
)
public class AddEmployeeDisplay extends HttpServlet {

    /**
     * This forwards to the JSP, which is intended to only be accessible
     * via this servlet. 
     * 
     * @param request the HTTP Request object
     * @param response the HTTP Response object 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the URL and then forward there.
        String url = "/addEmployee.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        

    }

}


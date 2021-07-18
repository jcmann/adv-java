package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Forwards to the EmployeeSearch JSP page.
 *
 *@author   jcmann
 */
@WebServlet(
        name = "employeeSearch",
        urlPatterns = { "/employeeSearch" }
)
public class EmployeeSearch extends HttpServlet {

    /**
     * Handles GET requests for the employee search page. Only exists
     * to forward to the JSP.
     *
     * @param request the HTTP request being received
     * @param response response sent from the servlet
     * @throws ServletException Standard error thrown by servlets
     * @throws IOException Standard error thrown by servlets
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the URL and then forward there.
        String url = "/employeeSearch.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}


package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Demo for attribute map
 *
 *@author   jcmann
 */
@WebServlet(
        name = "httpDemo2",
        urlPatterns = { "/httpDemo2" }
)
public class HttpReqDemo2 extends HttpServlet {

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

        request.setAttribute("name", "Java Class");
        request.setAttribute("favoriteNumber", 112);

        String url = "/httpReqDemo2.jsp"; // must match desired JSP

        // Knows how to send info to a JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}


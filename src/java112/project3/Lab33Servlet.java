package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  A servlet for lab 3-2. Outputs various information about the request
 *  to the browser.
 *
 *@author   jcmann
 */
@WebServlet(
        name = "lab33Servlet",
        urlPatterns = { "/lab33" }
)
public class Lab33Servlet extends HttpServlet {

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

        Map myMap = new HashMap();

        myMap.put("number", 1);
        myMap.put("text", "This is some sample text.");
        myMap.put("html", "<h2>This is an h2</h2>");
        myMap.put("aDate", new Date());

        request.setAttribute("myMap", myMap);

        String url = "/lab33.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}


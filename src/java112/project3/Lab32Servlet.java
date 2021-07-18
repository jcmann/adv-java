package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  A servlet for lab 3-2. Outputs various information about the request
 *  to the browser.
 *
 *@author   jcmann
 */
@WebServlet(
        name = "lab32Servlet",
        urlPatterns = { "/lab32" }
)
public class Lab32Servlet extends HttpServlet {

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

        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Lab 3-2 Jen Mann</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>About this Request</h1>");
        out.print("<ul>");
        out.print("<li><strong>Current Locale:</strong> " + request.getLocale() + "</li>");
        out.print("<li><strong>Context Path:</strong> " + request.getContextPath() + "</li>");
        out.print("<li><strong>Local Name:</strong> " + request.getLocalName() + "</li>");
        out.print("<li><strong>Scheme:</strong> " + request.getScheme() + "</li>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}


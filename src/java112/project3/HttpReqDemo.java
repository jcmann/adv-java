package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author   jcmann
 */
@WebServlet(
        name = "httpReqDemo",
        urlPatterns = { "/httpReqDemo" }
)
public class HttpReqDemo extends HttpServlet {

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
        out.print("<HEAD><TITLE>Sample Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Server Name</h1>");
        out.print("<p>" + request.getServerName() + "</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}


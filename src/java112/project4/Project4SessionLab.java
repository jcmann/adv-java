package java112.project4;

import java.io.*;
import java.util.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Demonstrates the use of Session scope. 
 *
 *@author   jcmann
 */
@WebServlet(
        name = "sessionLab",
        urlPatterns = { "/sessionLab" }
)
public class Project4SessionLab extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

        HttpSession session  = request.getSession();

        Integer sessionCounter = (Integer) session.getAttribute("project4SessionCounter"); 

        if (sessionCounter == null) {
            sessionCounter = 1; 
        } else {
            sessionCounter++; 
        }

        session.setAttribute("project4SessionCounter", sessionCounter);
 
        //Forward to jsp page
        String url = "/project4Session.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}


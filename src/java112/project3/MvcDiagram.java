package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*; 

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
@WebServlet(
    name = "mvc-diagram", 
    urlPatterns = { "/mvc-diagram" }
)
public class MvcDiagram extends HttpServlet {

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

        response.setContentType("text/html");
        
        // Get the same flashcards values as the proper servlet
        List<Flashcard> flashcards = Flashcard.generateStudySet(); 

        // Send those flashcards to the diagram jsp
        request.setAttribute("flashcards", flashcards);

        // Forward to the JSP
        String url = "/mvc-challenge/mvc-diagram.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }

}


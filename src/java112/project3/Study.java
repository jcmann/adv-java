package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 *  TODO
 *
 *@author   jcmann
 */
@WebServlet(
        name = "study",
        urlPatterns = { "/study" }
)
public class Study extends HttpServlet {

    private List<Flashcard> flashcards; 

    public List<Flashcard> getFlashcards() {
        return this.flashcards; 
    }

    /**
     * Initialization method runs once before the servlet is available 
     * to the browser. Here, it mostly sets the collection. 
     */
    public void init() throws ServletException {

        this.flashcards = Flashcard.generateStudySet(); 

    }


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

    
        // Send the flashcards list with the request for the jsp to access
        request.setAttribute("flashcards", this.flashcards);

        // Determine if the definition or term is being displayed
        if (request.getParameter("side") != null       
                && request.getParameter("side").equals("definition")) {
                    request.setAttribute("side", "definition");
        }

        // If the index attribute is not set, set it to 0
        if (request.getAttribute("index") == null) {
            request.setAttribute("index", 0); 
        }
        
        int index; 

        // If the previous or next parameter is set (by the jsp), 
        // adjust the index attribute accordingly
        if (request.getParameter("next") != null && request.getParameter("next").equals("1")) {

            index = Integer.parseInt(request.getParameter("index"));
            
            if (!(index == getFlashcards().size() - 1)) {
                index++; 
            }

            request.setAttribute("index", index);
        
        } else if (request.getParameter("previous") != null && request.getParameter("previous").equals("1")) {
            index = Integer.parseInt(request.getParameter("index"));

            if (!(index == 0)) {
                index--; 
            }

            request.setAttribute("index", index);
        }

        String url = "/mvc-challenge/study.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}


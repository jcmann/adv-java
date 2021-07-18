package java112.project4;

import java.io.*;
import java.util.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  Demo use of JSTL
 *
 *@author   jcmann
 */
@WebServlet(
        name = "flowerDemo",
        urlPatterns = { "/flowerDemo" }
)
public class FlowerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

    HttpSession  session  = request.getSession();

    List<String> flowers = new ArrayList();
    flowers.add("Tulip");
    flowers.add("Rose");
    flowers.add("Daffodil");
    flowers.add("Petunia");
    flowers.add("Lily");

    session.setAttribute("flowersList", flowers);

    
    }

}


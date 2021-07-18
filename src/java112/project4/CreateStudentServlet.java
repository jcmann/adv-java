package java112.project4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*; 

/**
 *  Creates students, puts them in a list, then forwards to JSP to display
 *
 *@author    eknapp
 */
@WebServlet(
    name = "studentServlet", 
    urlPatterns = { "/createStudents" }
)
public class CreateStudentServlet extends HttpServlet {

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
        
        Student s1 = new Student("Rigby", "Mann", 1);
        Student s2 = new Student("Tanqueray", "Togstad", 2); 
        Student s3 = new Student("Nori", "Peck", 3);  

        List<Student> studentList = new ArrayList<Student>(); 
        studentList.add(s1); 
        studentList.add(s2); 
        studentList.add(s3); 

        request.setAttribute("list", studentList);

        String url = "/displayStudents.jsp"; 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.forward(request, response); 
    }

}


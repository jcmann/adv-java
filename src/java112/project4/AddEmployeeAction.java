package java112.project4;

import java112.employee.*; 

import java.io.*;
import java.util.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Handles the logic of adding a new employee to the database, using the
 * data submitted by the user via a form on the addEmployee JSP.
 *
 *@author   jcmann
 */
@WebServlet(
        name = "addEmployeeAction",
        urlPatterns = { "/addEmployeeAction" }
)
public class AddEmployeeAction extends HttpServlet {

    /**
     * Handles POST requests sent from the add employee form. 
     * 
     * @param request the HTTP request, containing form data
     * @param response the HTTP response, used for a redirect here
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Access the employee directory
        ServletContext servletContext = getServletContext(); 
        EmployeeDirectory employeeDirectory = 
                (EmployeeDirectory) servletContext.getAttribute("employeeDirectory"); 
        HttpSession session = request.getSession();

        // Get the data from the HTML form 
        String firstName = request.getParameter("firstName"); 
        String lastName = request.getParameter("lastName"); 
        int ssn = Integer.parseInt(request.getParameter("ssn")); 
        String department = request.getParameter("department"); 
        String roomNumber = request.getParameter("roomNumber"); 
        String phoneNumber = request.getParameter("phoneNumber"); 

        // Call the addNewEmployee method
        int rowsAffected = employeeDirectory.addNewEmployee(firstName, lastName, ssn, 
                department, roomNumber, phoneNumber); 

        // Add a variable to the session representing whether the employee
        // was successfully added. This is removed in the JSP after first visit. 
        if (rowsAffected > 0) {
            session.setAttribute("justUpdated", true);
        } else {
            session.setAttribute("justUpdated", false);
        }

        // redirect to the display page with a confirmation 
        String url = "/java112/addEmployee.jsp";
        response.sendRedirect(url);


    }

}


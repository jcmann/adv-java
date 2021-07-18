package java112.project3;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.util.*;

/**
 * Demonstrates various information that can be attached to a request 
 * via attributes.
 *
 *@author    jcmann
 */
@WebServlet(
        name = "requestServlet",
        urlPatterns = { "/request-servlet" }
)
public class HttpRequestServlet extends HttpServlet {

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
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();

        // Instantiate HttpRequestData and set all instance variables
        HttpRequestData requestData =  new HttpRequestData(); 
        requestData.setRemoteComputer(request.getRemoteHost());
        requestData.setRemoteAddress(request.getRemoteAddr());
        requestData.setRequestHttpMethod(request.getMethod());
        requestData.setRequestURI(request.getRequestURI());
        requestData.setRequestURL(request.getRequestURL().toString());
        requestData.setRequestProtocol(request.getProtocol());
        requestData.setServerName(request.getServerName());
        requestData.setServerPortNumber("" + request.getServerPort());
        requestData.setServerLocale(request.getLocale());
        requestData.setQueryString(request.getQueryString());
        requestData.setQueryParameterValue(request.getParameter("queryParameter"));
        requestData.setUserAgent(request.getHeader("User-Agent"));

        request.setAttribute("requestBean", requestData);

        //Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/project3-jsp.jsp");
        dispatcher.forward(request, response);

        out.close();
    }

}


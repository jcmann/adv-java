<%@ page import="java.util.*, java112.project3.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MVC Diagram</title>

    <link rel="stylesheet" href="css/mvc.css">
</head>
<body>

    <header>

        <h1>How this Works</h1>

    </header>

    <main>

        <p>This works by bouncing the request between the JSP and the servlet. </p>

        <section>

            <h2>Process</h2>

            <img src="images/mvc-diagram.png">

            <ol>
                <li>
                    <strong>Client:</strong> Client requests the servlet URL, which
                    goes through the doGet method
                </li>
                <li>
                    <strong>Servlet:</strong> The doGet() runs with the 
                    "default" values, the first card's term side. 
                    This information is set as an attribute on the request.
                </li>
                <li>
                    <strong>Servlet:</strong> Forward the request to the JSP
                </li>
                <li>
                    <strong>JSP:</strong> Display the values (cards) with controls 
                    (next, previous, and show definition) as URLs with parameters
                    (for the GET request). Ex: ?index=1
                </li>
                <li>
                    <strong>JSP:</strong> (or the client...) User clicks a URL, 
                    which goes back to the servlet's doGet method
                </li>
                <li>
                    <strong>Servlet:</strong> doGet filters various parameters, 
                    and sets this information as attributes on the new request.
                    This is then forwarded to the JSP again.
                </li>
            </ol>

        </section>

        <section>
            <h2>The Bean Data</h2>
            <table cellspacing="0" cellpadding="0"> 
                <thead>
                    <tr>
                        <th>Term</th>
                        <th>Definition</th>
                        <th>Unit</th>
                    </tr>
                </thead>

                <tbody>
                    <%

                        ArrayList<Flashcard> flashcards = (ArrayList) request.getAttribute("flashcards"); 

                        for (Flashcard current : flashcards) {
                            out.println("<tr>");
                            out.println("<td>" + current.getTerm() + "</td>");
                            out.println("<td>" + current.getDefinition() + "</td>");
                            out.println("<td>" + current.getUnit() + "</td>");
                            out.println("</tr>");
                        }

                    %>
                </tbody>
            </table>
        </section>

    </main>
    

    


    
</body>
</html>
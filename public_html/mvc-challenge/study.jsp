<%@ page import="java.util.*, java112.project3.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Java 112 Flashcards</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

</head>
<body>

    <header>
        <h1 class="text-center"><a href="/java112/study">Java 112 Flashcards</a></h1>
    </header>

    <main class="container d-flex text-center">
        <section class="row m-3 w-100 no-gutters">
            <div class="col-3">

                <%

                    int index; 
                    if (request.getParameter("index") != null) {
                        index = Integer.parseInt(request.getParameter("index")); 
                    } else {
                        index = (int) request.getAttribute("index");
                    }

                    int prevIndex = index - 1; 
                    String prevURL = "/java112/study?previous=1&index=" + prevIndex;

                    out.println("<a href='" + prevURL + "'>Previous</a>");

                %>
                
            </div>

            <article class="col-6">

                <%

                    if (request.getAttribute("flashcards") != null) {

                        ArrayList<Flashcard> flashcards = (ArrayList) request.getAttribute("flashcards");

                        out.println("<h2>"); 
                        if (request.getAttribute("side") != null
                                && request.getAttribute("side").equals("definition")) {
                            out.println(flashcards.get(index).getDefinition()); 
                            out.println("</h2>");

                            String url = "/java112/study?index=" + index ;

                            out.println("<a href='" + url + "'>See term</a>");
                        } else {
                            out.println(flashcards.get(index).getTerm());
                            out.println("</h2>");

                            String url = "/java112/study?index=" + index 
                                    + "&side=definition"; 

                            out.println("<a href='" + url + "'>See definition</a>");
                        }
                        
                        

                    }

                %>
            </article>
    
            <div class="col-3">
                <%

                    int nextIndex = index + 1; 
                    String nextURL = "/java112/study?next=1&index=" + nextIndex;

                    out.println("<a href='" + nextURL + "'>Next</a>");

                %>
                
            </div>
        </section>
    </main>

    <footer class="text-center">
        Made by Jen Mann, Spring 2021
    </footer>
    
</body>
</html>
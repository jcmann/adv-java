<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="templates/headTag.jsp" />
<body>

    <div class="wrapper">

        <c:import url="templates/headerTag.jsp" />

        <c:import url="templates/sidebar.jsp" />

        <main id="content">

            <%!

                public void jspInit() {
                    ServletContext servletContext = getServletConfig().getServletContext(); 
                    servletContext.setAttribute("name", "jen"); 
                }

            %>

            <p>Output: <%= getServletConfig().getServletContext().getAttribute("name") %></p>

        </main>

        <c:import url="templates/footer.jsp" />

    </div>

    

    
</body>
</html>
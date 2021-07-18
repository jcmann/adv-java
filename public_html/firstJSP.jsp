<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<c:import url="templates/headTag.jsp" />

  <body>

    <div class="wrapper">

        <c:import url="templates/headerTag.jsp" />

        <c:import url="templates/sidebar.jsp" />

        <!-- HTML Comment -->
        <%-- This is a JSP comment --%>

        <h3>This is a simple first look at a JSP page.</h3>

        <p>A change that gets compiled. Another change</p>

        <p>Right now it is <%= new java.util.Date() %></p>
    
        <p><a href="/java112">Home</a></p>

        <c:import url="templates/footer.jsp" />

    </div>
  
    
  </body>
</html>

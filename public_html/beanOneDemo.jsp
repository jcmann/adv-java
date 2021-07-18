<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 
<html>
  <c:import url="templates/headTag.jsp" />
 
  <body>
    <div class="wrapper">

      <c:import url="templates/headerTag.jsp" />

      <c:import url="templates/sidebar.jsp" />

      <main id="content">

        <h3>MVC Demo</h3>
     
        <p>Data from my bean: ${myCoolBean.data}</p>
        
        <br />
        
        <a href="/java112">Home</a>

      </main>

      <c:import url="templates/footer.jsp" />
      
  </div>
  </body>
</html>

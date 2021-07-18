<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
    <c:set var="myTagVariable" value="I'm a Tag!" />
<html>
<c:import url="templates/headTag.jsp" />
<body>

    

    <div class="wrapper">

        <c:import url="templates/headerTag.jsp" />

        <c:import url="templates/sidebar.jsp" />
        
        <p>My tag variable message: ${myTagVariable}</p>    
    </div>
    
    <c:import url="templates/footer.jsp" />
    
</body>
</html>

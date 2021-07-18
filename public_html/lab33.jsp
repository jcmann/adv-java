

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="templates/headTag.jsp" />

<body>

<div class="wrapper">

    <c:import url="templates/headerTag.jsp" />

    <c:import url="templates/sidebar.jsp" />

    <main id="content">

        <h2>Map on a JSP Page</h2>
        <p>${myMap["number"]}</p>
        <p>${myMap["text"]}</p>
        ${myMap["html"]}
        <p>${myMap["aDate"]}</p>



    </main>

    <c:import url="templates/footer.jsp" />

</div>

</body>

</html>
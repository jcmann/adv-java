<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<c:import url="/templates/headTag.jsp"/>
<body>

    <div class="wrapper">
        <c:import url="/templates/headerTag.jsp"/>

        <main id="content">
            <h1>Unit 4 Sessions Lab</h1>
            <p>Session Count: ${project4SessionCounter}</p>
        </main>


        <c:import url="/templates/footer.jsp"/>
    </div>
</body>
</html>
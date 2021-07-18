<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<c:import url="templates/headTag.jsp" />
<body>

    <div class="wrapper">

        <c:import url="templates/headerTag.jsp" />

        <c:import url="templates/sidebar.jsp" />

        <h2>JSTL Lab 2</h2>

        <table>
            <c:forEach var="plantName" items="${list}">
                <tr>
                    <th>Plant Name:</th>
                    <td>${plantName}</td>
                </tr>
            </c:forEach>
        </table>


        <c:import url="templates/footer.jsp" />
    </div>
    
</body>
</html>
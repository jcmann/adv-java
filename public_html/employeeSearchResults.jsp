<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="templates/headTag.jsp" />

<body>

<div class="wrapper">

    <c:import url="templates/headerTag.jsp" />

    <c:import url="templates/sidebar.jsp" />

    <main id="content">

        <h2>Search Results</h2>

        <c:if test="${search.employeesFound}">
            
            <table>

                <thead>
                    <tr>
                        <th>Empl ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>SSN</th>
                        <th>Department</th>
                        <th>Room</th>
                        <th>Phone Number</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach var="current" items="${search.results}">
                        <tr>
                            <td>${current.id}</td>
                            <td>${current.firstName}</td>
                            <td>${current.lastName}</td>
                            <td>${current.ssn}</td>
                            <td>${current.department}</td>
                            <td>${current.roomNumber}</td>
                            <td>${current.phoneNumber}</td>
                        </tr>
                    </c:forEach>

                </tbody>

            </table>


        </c:if>

        <c:if test="${!search.employeesFound}">
            Employees were not found!
        </c:if>


    </main>

    <c:import url="templates/footer.jsp" />

</div>

</body>

</html>
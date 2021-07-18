<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="templates/headTag.jsp" />

<body>

<div class="wrapper">

    <c:import url="templates/headerTag.jsp" />

    <c:import url="templates/sidebar.jsp" />

    <main id="content">

        <c:if test="${justUpdated}">
            <section class="successMessage">
                <h2>Employee successfully added!</h2>
            </section>
            <c:remove var="justUpdated" scope="session" />
        </c:if>

        <h2>Add a New Employee</h2>

        <form action="/java112/addEmployeeAction" method="post">

            <label for="firstName">
                First Name:
                <input type="text" name="firstName" id="firstName">
            </label>

            <label for="lastName">
                Last Name:
                <input type="text" name="lastName" id="lastName">
            </label>

            <label for="ssn">
                Social Security Number:
                <input type="text" name="ssn" id="ssn">
            </label>

            <label for="department">
                Department:
                <input type="text" name="department" id="department">
            </label>

            <label for="roomNumber">
                Room Number:
                <input type="text" name="roomNumber" id="roomNumber">
            </label>

            <label for="phoneNumber">
                Phone Number:
                <input type="text" name="phoneNumber" id="phoneNumber">
            </label>

            <button type="submit">Submit</button>

        </form>

    </main>

    <c:import url="templates/footer.jsp" />

</div>

</body>

</html>
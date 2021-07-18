<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="templates/headTag.jsp" />

<body>

<div class="wrapper">

    <c:import url="templates/headerTag.jsp" />

    <c:import url="templates/sidebar.jsp" />

    <main id="content">
        
        <h2>Search for an Employee</h2>

        <form action="/java112/employeeSearchResults" method="GET">
        
            <label for="searchTerm">
                Enter a search term:
                <input type="text" name="searchTerm" id="searchTerm">
            </label>

            <fieldset>
                <legend>What field are you searching by?</legend>

                <label for="id">
                    <input type="radio" name="searchType" id="id" value="id">
                    ID
                </label>

                <label for="firstName">
                    <input type="radio" name="searchType" id="firstName" value="firstName">
                    First Name
                </label>

                <label for="lastName">
                    <input type="radio" name="searchType" id="lastName" value="lastName">
                    Last Name
                </label>
            </fieldset>

            <button type="submit">Search</button>
        
        </form>

    </main>

    <c:import url="templates/footer.jsp" />

</div>

</body>

</html>
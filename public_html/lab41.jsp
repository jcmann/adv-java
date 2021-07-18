<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="templates/headTag.jsp" />
<body>

    <div class="wrapper">

        <c:import url="templates/headerTag.jsp" />

        <c:import url="templates/sidebar.jsp" />

        <h1>Forms Lab</h1>
        <form method="get" action="/java112/Lab41Servlet" >
        
            <label for="firstName">First Name:
                <input type="text" name="firstName" id="firstName">
            </label>

            <label for="lastName">Last Name:
                <input type="text" name="lastName" id="lastName">
            </label>

            <label for="favoriteAnimal">Favorite Animal: 
                <select name="favoriteAnimal" id="favoriteAnimal">
                    <option>Cat</option>
                    <option>Dog</option>
                    <option>Bird</option>
                    <option>Other</option>
                </select>
            </label>

            <fieldset>
                <legend>What operating system(s) do you use?</legend>
                <label for="os-win">
                    Windows <input type="checkbox" name="os" id="os-win" value="Windows">
                </label>
                <label for="os-mac">
                    MacOS <input type="checkbox" name="os" id="os-mac" value="Mac">
                </label>
                <label for="os-linux">
                    Linux <input type="checkbox" name="os" id="os-linux" value="Linux">
                </label>
                
            </fieldset>

            <input type="submit" value="Submit">

        </form>

    </div>

    <c:import url="templates/footer.jsp" />
    
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
  <head>
    <title>Display Students</title>
  </head>
  <body>
    <ul>
      <c:forEach var="flower" items="${list}">
        <li>${flower}</li>
      </c:forEach>
    </ul>
  </body>
</html>

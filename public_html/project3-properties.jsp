<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="templates/headTag.jsp" %>

<body>

    <div class="wrapper">
        <%@ include file="templates/headerTag.jsp" %>

        <%@ include file="templates/sidebar.jsp" %>

        <main id="content"> 

            <table>
                <tr>
                    <th>Author Name</th>
                    <td>${properties["author.name"]}</td>
                </tr>
                <tr>
                    <th>Author Email</th>
                    <td>${properties["author.email"]}</td>
                </tr>
                <tr>
                    <th>Course Title</th>
                    <td>${properties["course.title"]}</td>
                </tr>
                <tr>
                    <th>Course Meeting Times</th>
                    <td>${properties["course.meeting.time"]}</td>
                </tr>
                <tr>
                    <th>Instructor Name</th>
                    <td>${properties["course.instructor.name"]}</td>
                </tr>
                <tr>
                    <th>Project Description</th>
                    <td>${properties["project.description"]}</td>
                </tr>
            </table>

        </main>

        <%@ include file="templates/footer.jsp" %>
    </div>

</body>

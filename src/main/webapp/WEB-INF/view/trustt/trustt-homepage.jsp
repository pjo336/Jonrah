<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Jonrah</title>
    <c:import url="/WEB-INF/view/parts/header.jsp"/>
</head>
<body>

<c:import url="/WEB-INF/view/parts/top-navbar.jsp"/>
<div class="container">
<H1>Create an Issue</H1>

    <c:url var="createIssue" value="createIssue.html" />
    <form:form id="issueForm" class="form-signin" modelAttribute="issue" method="post"
               action="${createIssue}">

        <table width="600px" height="350px">
            <tr>
                <td><form:label path="title">Title</form:label></td>
                <td><form:input path="title" /></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Create" /></td>
            </tr>
        </table>
    </form:form>


</div>
<c:import url="/WEB-INF/view/parts/footer.jsp"/>
</body>
</html>
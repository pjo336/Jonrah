<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <%--create an issue section--%>
    <H1>Create an Issue</H1>

    <c:url var="createIssue" value="/trustt/create-issue"/>
    <form:form id="issueForm" class="form-signin" method="post" commandName="issue"
               action="${createIssue}">

        <table width="600px" height="350px">
            <tr>
                <td><form:label path="title">Title</form:label></td>
                <td><form:input path="title"/></td>
            </tr>

            <tr>
                <td><form:label path="description">Description</form:label></td>
                <td><form:input path="description"/></td>
            </tr>

            <tr>
                <td><form:label path="type">Description</form:label></td>
                <td><form:select path="type" items="${types}" /></td>
            </tr>

            <tr>
                <td><form:button type="submit" value="Create">Create</form:button></td>
            </tr>
        </table>
    </form:form>
</div>
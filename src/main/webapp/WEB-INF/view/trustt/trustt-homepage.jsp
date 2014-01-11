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

    <%--search bar--%>
    <div class="searchbar">
    <div class="container">
        <div class="row" style="position: relative;">
            <div class="col-lg-3">
                <div class="input-group custom-search-form" style="position: absolute; bottom: 25px; left:900px;">
                    <input type="text" class="form-control">
              <span class="input-group-btn">
              <button class="btn btn-default" type="button">
                  <span class="glyphicon glyphicon-search"></span>
              </button>
             </span>
                </div>
                <!-- /input-group -->
            </div>
        </div>
    </div>
    </div>

    <%--table of bugs--%>
    <div class="span7">
        <div class="widget stacked widget-table action-table">

            <div class="widget-header">
                <i class="icon-th-list"></i>

                <h3>Issues</h3>
            </div>
            <!-- /widget-header -->

            <div class="widget-content">
                <c:if test="${!empty issues}">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Title</th>
                        <th class="td-actions"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${issues}" var="issue">
                    <tr>
                        <td><c:out value="${issue.dateAdded}"/></td>
                        <td><c:out value="${issue.title}"/></td>
                        <td class="td-actions">
                            <a href="javascript:;" class="btn btn-small btn-primary">
                                <i class="btn-icon-only icon-ok"></i>
                            </a>

                            <a href="javascript:;" class="btn btn-small">
                                <i class="btn-icon-only icon-remove"></i>
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>

            </div>
            <!-- /widget-content -->

        </div>
        <!-- /widget -->
    </div>

    <%--full bug list--%>
    <div style="color: teal; font-size: 30px">Jonrah | Trustt</div>
    <br/>
    <c:if test="${!empty issues}">
        <table border="1" bgcolor="black" width="700px">
            <tr
                    style="background-color: teal; color: white; text-align: center;"
                    height="40px">
                <td>Issue Number</td>
                <td>Title</td>
                <td>Type</td>
                <td>Status</td>
                <td>Priority</td>
                <td>Created By</td>
                <td>Assigned To</td>
                <td>Created On</td>
            </tr>

            <c:forEach items="${issues}" var="issue">
                <tr
                        style="background-color: white; color: black; text-align: center;"
                        height="30px">
                    <td><c:out value="${issue.id}"/></td>
                    <td><c:out value="${issue.title}"/></td>
                    <td><c:out value="${issue.type}"/></td>
                    <td><c:out value="${issue.status}"/></td>
                    <td><c:out value="${issue.priority}"/></td>
                    <td><c:out value="${issue.createdById.userName}"/></td>
                    <td><c:out value="${issue.assignedToId.userName}"/></td>
                    <td><c:out value="${issue.dateAdded}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <%--create an issue section--%>
    <H1>Create an Issue</H1>

    <c:url var="createIssue" value="createIssue.html"/>
    <form:form id="issueForm" class="form-signin" modelAttribute="issue" method="post"
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

            <%--<tr>--%>
                <%--<td><form:label path="type">Description</form:label></td>--%>
                <%--<td><<form:radiobuttons path="type" items="${model.types}"/></td>--%>
            <%--</tr>--%>

            <tr>
                <td></td>
                <td><input type="submit" value="Create"/></td>
            </tr>
        </table>
    </form:form>


</div>
<c:import url="/WEB-INF/view/parts/footer.jsp"/>
</body>
</html>
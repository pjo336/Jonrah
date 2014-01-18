<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">

    <%--table of bugs--%>
    <div class="tabbable">
        <ul class="nav nav-pills">
            <li class="active"><a href="#pane1" data-toggle="tab">Open Issues</a>
            </li>
            <li>
                <a href="#pane2" data-toggle="tab">Closed Issues</a>
            </li>
        </ul>
        <div class="tab-content">
    <div id="pane1" class="span7 tab-pane active">
        <div class="widget stacked widget-table action-table">

            <div class="widget-header">
                <i class="icon-th-list"></i>

                <h3>Issues</h3>
            </div>
            <!-- /widget-header -->

            <div class="widget-content">
                <c:if test="${!empty openIssues}">
                    <table class="table table-striped table-bordered">
                        <thead class="issue-table-header">
                        <tr>
                            <th>Opened Date</th>
                            <th>Title</th>
                            <th>Priority</th>
                            <th>Status</th>
                            <th>Type</th>
                            <th>Assigned To</th>
                            <th class="td-actions">Open Issue</th>
                        </tr>
                        </thead>
                        <tbody class="issue-table">
                        <c:forEach items="${openIssues}" var="issue">
                            <tr ondblclick="document.location = '/trustt/issue/${issue.id}';">

                                <td><fmt:formatDate value="${issue.dateAdded}" pattern="MM-dd-yyyy" /></td>
                                <td class="issue-title-table"><c:out value="${issue.title}"/></td>
                                <%--issue priority--%>
                                <c:choose>
                                    <c:when test="${empty issue.priority}">
                                        <td class="td-actions">
                                            <a href="javascript:;" class="btn btn-small btn-primary">
                                                <i class="btn-icon-only icon-ok"></i>
                                                Set Priority
                                            </a>
                                        </td>
                                    </c:when>
                                    <c:when test="${!empty issue.priority}">
                                        <td>
                                            <c:out value="${issue.priority}"/>
                                        </td>
                                    </c:when>
                                </c:choose>
                                <%--end issue priority--%>

                                <td><c:out value="${issue.status}"/></td>

                                <%--issue type--%>
                                <c:choose>
                                    <c:when test="${empty issue.type}">
                                        <td class="td-actions">
                                            <a href="javascript:;" class="btn btn-small btn-primary">
                                                <i class="btn-icon-only icon-ok"></i>
                                                Set Type
                                            </a>
                                        </td>
                                    </c:when>
                                    <c:when test="${!empty issue.type}">
                                        <td>
                                            <c:out value="${issue.type}"/>
                                        </td>
                                    </c:when>
                                </c:choose>
                                <%--end issue type--%>
                                <%--issue assigned to--%>
                                <c:choose>
                                    <c:when test="${empty issue.assignedToId}">
                                        <td id="assignedUser-${issue.id}" class="td-actions">
                                            <form:form id="assignUsersForm-${issue.id}" method="post">
                                                <button id="${issue.id}" class="assignUsersButtonMain btn btn-small btn-primary">Assign</button>
                                                <%--Hidden text field and submit button--%>
                                                <input id="inputAssignedUserName-${issue.id}" class="inputAssignedUserName" type="text" width="75px"/>
                                                <button id="inputAssignedUserNameButton-${issue.id}" class="inputAssignedUserName glyphicon glyphicon-ok-sign"/>
                                            </form:form>
                                        </td>
                                    </c:when>
                                    <c:when test="${!empty issue.assignedToId}">
                                        <td>
                                            <a href="/userList">
                                            <c:out value="${issue.assignedToId.firstName} ${issue.assignedToId.lastName}"/>
                                            </a>
                                        </td>
                                    </c:when>
                                </c:choose>
                                <%--end issue assigned to--%>

                                <td class="td-actions">
                                    <a href="/trustt/issue/${issue.id}" class="btn btn-small btn-info">
                                        <i class="btn-icon-only icon-ok"></i>
                                        Open Issue
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

        <div id="pane2" class="span7 tab-pane">
            <div class="widget stacked widget-table action-table">

                <div class="widget-header">
                    <i class="icon-th-list"></i>

                    <h3>Issues</h3>
                </div>
                <!-- /widget-header -->

                <div class="widget-content">
                    <c:if test="${!empty closedIssues}">
                        <table class="table table-striped table-bordered">
                            <thead class="issue-table-header">
                            <tr>
                                <th>Closed Date</th>
                                <th>Title</th>
                                <th>Priority</th>
                                <th>Status</th>
                                <th>Type</th>
                                <th>Assigned To</th>
                                <th class="td-actions">Open Issue</th>
                            </tr>
                            </thead>
                            <tbody class="issue-table">
                            <c:forEach items="${closedIssues}" var="issue">
                                <tr ondblclick="document.location = '/trustt/issue/${issue.id}';">

                                    <td><fmt:formatDate value="${issue.dateAdded}" pattern="MM-dd-yyyy" /></td>
                                    <td class="issue-title-table"><c:out value="${issue.title}"/></td>
                                        <%--issue priority--%>
                                    <c:choose>
                                        <c:when test="${empty issue.priority}">
                                            <td class="td-actions">
                                                <a href="javascript:;" class="btn btn-small btn-primary">
                                                    <i class="btn-icon-only icon-ok"></i>
                                                    Set Priority
                                                </a>
                                            </td>
                                        </c:when>
                                        <c:when test="${!empty issue.priority}">
                                            <td>
                                                <c:out value="${issue.priority}"/>
                                            </td>
                                        </c:when>
                                    </c:choose>
                                        <%--end issue priority--%>

                                    <td><c:out value="${issue.status}"/></td>

                                        <%--issue type--%>
                                    <c:choose>
                                        <c:when test="${empty issue.type}">
                                            <td class="td-actions">
                                                <a href="javascript:;" class="btn btn-small btn-primary">
                                                    <i class="btn-icon-only icon-ok"></i>
                                                    Set Type
                                                </a>
                                            </td>
                                        </c:when>
                                        <c:when test="${!empty issue.type}">
                                            <td>
                                                <c:out value="${issue.type}"/>
                                            </td>
                                        </c:when>
                                    </c:choose>
                                        <%--end issue type--%>

                                        <%--issue assigned to--%>
                                    <c:choose>
                                        <c:when test="${empty issue.assignedToId}">
                                            <td class="td-actions">
                                                <a href="javascript:;" class="btn btn-small btn-primary">
                                                    <i class="btn-icon-only icon-ok"></i>
                                                    Assign
                                                </a>
                                            </td>
                                        </c:when>
                                        <c:when test="${!empty issue.assignedToId}">
                                            <td>
                                                <a href="/userList">
                                                    <c:out value="${issue.assignedToId.firstName} ${issue.assignedToId.lastName}"/>
                                                </a>
                                            </td>
                                        </c:when>
                                    </c:choose>
                                        <%--end issue assigned to--%>

                                    <td class="td-actions">
                                        <a href="/trustt/issue/${issue.id}" class="btn btn-small btn-primary">
                                            <i class="btn-icon-only icon-ok"></i>
                                            Open Issue
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>

                </div>
            </div>
        </div>
        </div>
    </div>
</div>
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
                                            <form:form id="assignUsers" method="post">
                                            <input type="hidden" id="assignedUserIssueId" value="${issue.id}"/>
                                            <input type="submit" class="btn btn-small btn-primary" value="Assign"/>
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
                <!-- /widget-content -->

            </div>
        </div>
            <!-- /widget -->
        </div>

    </div>
    <%--full bug list--%>
    <%--<div style="color: teal; font-size: 30px">Jonrah | Trustt</div>--%>
    <%--<br/>--%>
    <%--<c:if test="${!empty issues}">--%>
        <%--<table border="1" bgcolor="black" width="700px">--%>
            <%--<tr--%>
                    <%--style="background-color: teal; color: white; text-align: center;"--%>
                    <%--height="40px">--%>
                <%--<td>Issue Number</td>--%>
                <%--<td>Title</td>--%>
                <%--<td>Type</td>--%>
                <%--<td>Status</td>--%>
                <%--<td>Priority</td>--%>
                <%--<td>Created By</td>--%>
                <%--<td>Assigned To</td>--%>
                <%--<td>Created On</td>--%>
            <%--</tr>--%>

            <%--<c:forEach items="${issues}" var="issue">--%>
                <%--<tr--%>
                        <%--style="background-color: white; color: black; text-align: center;"--%>
                        <%--height="30px">--%>
                    <%--<td><c:out value="${issue.id}"/></td>--%>
                    <%--<td><c:out value="${issue.title}"/></td>--%>
                    <%--<td><c:out value="${issue.type}"/></td>--%>
                    <%--<td><c:out value="${issue.status}"/></td>--%>
                    <%--<td><c:out value="${issue.priority}"/></td>--%>
                    <%--<td><c:out value="${issue.createdById.userName}"/></td>--%>
                    <%--<td><c:out value="${issue.assignedToId.userName}"/></td>--%>
                    <%--<td><c:out value="${issue.dateAdded}"/></td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
        <%--</table>--%>
    <%--</c:if>--%>
</div>
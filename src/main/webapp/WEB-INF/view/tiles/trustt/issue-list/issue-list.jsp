<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container withsidenav">

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
                            <th>Type</th>
                            <th>Opened Date</th>
                            <th>Title</th>
                            <th>Priority</th>
                            <th>Status</th>
                            <th>Assigned To</th>
                            <th class="td-actions">Open Issue</th>
                        </tr>
                        </thead>
                        <tbody class="issue-table">
                            <c:forEach items="${openIssues}" var="issue">
                                <tr>
                                    <td>
                                        <%--XXX This could be done better to not be hardcoded but Im annoyed trying right now--%>
                                        <c:choose>
                                            <c:when test="${issue.type.name eq 'BUG'}">
                                                <span class="label label-pill label-danger">${issue.type.name}</span>
                                            </c:when>
                                            <c:when test="${issue.type.name eq 'FEATURE'}">
                                                <span class="label label-pill label-primary">${issue.type.name}</span>
                                            </c:when>
                                            <c:when test="${issue.type.name eq 'TASK'}">
                                                <span class="label label-pill label-info">${issue.type.name}</span>
                                            </c:when>
                                            <c:when test="${issue.type.name eq 'DUPLICATE'}">
                                                <span class="label label-pill label-warning">${issue.type.name}</span>
                                            </c:when>
                                            <c:when test="${issue.type.name eq 'ENHANCEMENT'}">
                                                <span class="label label-pill label-default">${issue.type.name}</span>
                                            </c:when>
                                            <c:when test="${issue.type.name eq 'EPIC'}">
                                                <span class="label label-pill label-success">${issue.type.name}</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="label label-pill">${issue.type.name}</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td><fmt:formatDate value="${issue.dateAdded}" pattern="MM-dd-yyyy h:mm:ss a" /></td>
                                    <td class="issue-title-table"><c:out value="${issue.title}"/></td>
                                    <%--issue priority--%>
                                    <td>
                                        <c:out value="${issue.priority.issuePriorityName}"/>
                                    </td>
                                    <%--end issue priority--%>

                                    <%--Issue status--%>
                                    <td>
                                        <c:out value="${issue.status.issueStatusName}"/>
                                    </td>
                                    <%--End issue status--%>

                                    <style>
                                        .ui-state-active,
                                        .ui-widget-content .ui-state-active,
                                        .ui-widget-header .ui-state-active,
                                        .ui-autocomplete, .ui-autocomplete:hover,
                                        .ui-menu-item, .ui-menu-item:hover,
                                        .ui-menu-item a, .ui-menu-item a:hover,
                                        .ui-widget-content .ui-state-focus,
                                        .ui-widget-header .ui-state-focus,
                                        .ui-widget-content .ui-state-hover,
                                        .ui-widget-header .ui-state-hover,
                                        .ui-menu .ui-menu-item a.ui-state-focus,
                                        .ui-menu .ui-menu-item a.ui-state-active,
                                        .ui-menu .ui-menu-item a
                                        { background: #ffffff none no-repeat;
                                            padding:0;
                                            margin:0;
                                            display:block;
                                            border:0;border-collapse:collapse;
                                        }
                                        .ui-helper-hidden-accessible {
                                            display:none;
                                        }
                                    </style>
                                    <%--issue assigned to--%>
                                    <c:choose>
                                        <c:when test="${empty issue.assignedToId}">
                                            <td id="assignedUser-${issue.id}" class="td-actions">
                                                    <button id="${issue.id}" class="assignUsersButtonMain btn btn-small btn-primary">Assign</button>
                                                    <%--Hidden text field and submit button--%>
                                                    <input id="inputAssignedUserName-${issue.id}" class="inputAssignedUserName" type="text" width="75px"/>
                                            </td>
                                        </c:when>
                                        <c:when test="${!empty issue.assignedToId}">
                                            <td>
                                                <button id="existingAssignedUser-${issue.id}" type="button" onclick="showAssignUserInputField(${issue.id})" class="btn btn-link">
                                                    <c:out value="${issue.assignedToId.userName}"/>
                                                </button>
                                                <input id="inputAssignedUserName-${issue.id}" class="inputAssignedUserName" type="text" width="75px"/>
                                            </td>
                                        </c:when>
                                    </c:choose>
                                    <%--end issue assigned to--%>

                                    <td class="td-actions">
                                        <a href="/trustt/issue/${issue.id}" class="btn btn-small btn-info">
                                            <i class="btn-icon-only icon-ok"></i>
                                            View Issue
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
                                    <td><fmt:formatDate value="${issue.dateAdded}" pattern="MM-dd-yyyy" /></td>
                                    <td class="issue-title-table"><c:out value="${issue.title}"/></td>
                                        <%--issue priority--%>
                                    <c:choose>
                                        <c:when test="${empty issue.priority}">
                                            <td class="td-actions">

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
                                            View Issue
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
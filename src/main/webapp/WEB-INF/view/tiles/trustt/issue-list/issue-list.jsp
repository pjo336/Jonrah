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
                                        <td id="issuePriority-${issue.id}" class="td-actions">
                                            <button id="${issue.id}"
                                                    class="assignUsersButtonMain btn btn-small btn-primary">
                                                Set Priority
                                            </button>
                                                <%--Hidden drop down for priority--%>
                                            <select class="inputIssuePriority" name='priority'>
                                                <c:forEach items="${priorities}" var="priority">
                                                    <option value="${priority.issuePriorityName}">${priority.issuePriorityName}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </c:when>
                                    <c:when test="${!empty issue.priority}">
                                        <td>
                                            <c:out value="${issue.priority}"/>
                                        </td>
                                    </c:when>
                                </c:choose>
                                <%--end issue priority--%>

                                <%--Issue status--%>
                                <c:choose>
                                    <c:when test="${empty issue.status}">
                                        <td id="issueStatus-${issue.id}" class="td-actions">
                                            <button id="${issue.id}"
                                                    class="setStatusButtonMain btn btn-small btn-primary">
                                                Set Status
                                            </button>
                                                <%--Hidden drop down for priority--%>
                                            <select class="inputIssueStatus name='status'>
                                                <c:forEach items="${statuses}" var="status">
                                                    <option value="${status.issueStatusName}">
                                                            ${status.issueStatusName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </c:when>
                                    <c:when test="${!empty issue.status}">
                                        <td>
                                            <c:out value="${issue.status.issueStatusName}"/>
                                        </td>
                                    </c:when>
                                </c:choose>
                                <%--End issue status--%>

                                <%--issue type--%>
                                <c:choose>
                                    <c:when test="${empty issue.type}">
                                        <td id="issueType-${issue.id}" class="td-actions">
                                            <button id="${issue.id}"
                                                    class="setIssueTypeButtonMain btn btn-small btn-primary">
                                                Set Type
                                            </button>
                                                <%--Hidden drop down for priority--%>
                                            <select class="inputIssuePriority" name='type'>
                                                <c:forEach items="${types}" var="type">
                                                    <option value="${type.name}">
                                                            ${type.name}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </c:when>
                                    <c:when test="${!empty issue.type}">
                                        <td>
                                            <c:out value="${issue.type.name}"/>
                                        </td>
                                    </c:when>
                                </c:choose>
                                <%--end issue type--%>
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
    <div id="saveIssueChanges">
        <button id="saveIssue" class="assignUsersButtonMain btn btn-large btn-primary">Save Updates</button>
    </div>
</div>
<div class="container">

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
</div>
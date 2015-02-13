<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container withsidenav">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">${issue.title}</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <table class="table">
                        <tr>
                            <td>Type:</td>
                            <td>${issue.type.name}</td>
                        </tr>
                        <tr>
                            <td>Status:</td>
                            <td>${issue.status}</td>
                        </tr>
                    </table>
                </div>
                <div class="col-md-8">
                    <p>${issue.description}</p>
                </div>
            </div>
        </div>
    </div>

    <%--Comments--%>
    <div class="container">
        <c:if test="${!empty comments}">
                <table class="table table-condensed">
            <c:forEach items="${comments}" var="comment">
                    <tr class="issue-detail-comment" cols="50" name="comment">
                            <td>
                                <p class="issue-comment">${comment.comment}</p>
                                <br />
                                <p>
                                    <b>posted by: </b> ${comment.commenter.userName}
                                    <br />
                                    <b>date posted: </b> ${comment.dateAdded}
                                </p>
                            </td>
                    </tr>
            </c:forEach>
                </table>
        </c:if>
    </div>

    <%--Add a new Comment--%>
    <div class="container">
        <div class="row" style="margin-top:40px;">
            <div class="col-md-6">
                <div class="well well-sm">
                    <div class="text-right">
                        <a class="btn btn-small btn-info" href="#reviews-anchor" id="open-review-box">Comment</a>
                    </div>

                    <div class="row" id="post-review-box" style="display:none;">
                        <div class="col-md-12">
                            <form:form modelAttribute="newComment" accept-charset="UTF-8" action="" method="post">
                                <textarea class="form-control animated" cols="50" id="new-review" name="comment" placeholder="Enter your comment here" rows="5" path="comment"></textarea>

                                <div class="text-right commentbuttons">
                                    <a class="btn btn-danger btn-sm" href="#" id="close-review-box" style="display:none; margin-right: 10px;">
                                        <span class="glyphicon glyphicon-remove"></span>Cancel</a>
                                    <button class="btn btn-small btn-primary" type="submit">Add Comment</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
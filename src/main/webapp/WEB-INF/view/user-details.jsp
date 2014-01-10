<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Jonrah | User Details</title>
    <c:import url="/WEB-INF/view/parts/header.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/view/parts/top-navbar.jsp"/>
<center>
    <div style="color: teal; font-size: 30px">Jonrah | User
        Details
    </div>
    <c:if test="${!empty user}">
        <table id="userTable" border="1" bgcolor="black" width="700px">
            <tr
                    style="background-color: teal; color: white; text-align: center;"
                    height="40px">
                <td id="username">Username</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Gender</td>
                <td>Email Address</td>
                <td>User Type</td>
                <td>Delete User</td>
            </tr>

            <c:forEach items="${user}" var="user">
                <c:url var="userDelete" value="deleteUser.html"/>
                <tr
                        style="background-color: white; color: black; text-align: center;"
                        height="30px">
                    <td><c:out value="${user.userName}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.gender}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.userType}"/></td>
                    <td>
                        <c:if test="${!empty user}">

                            <form:form id="deleteForm" modelAttribute="user" method="post"
                                       action="${userDelete}">
                                <input type="hidden" name="id" value="${user.id}"/>
                                <input type="submit" value="Delete"/>
                            </form:form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <a href="register.html">Click Here to add new User</a>
</center>


<%--users information section--%>
<div class="well col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">

    <c:forEach items="${user}" var="user">
        <div class="row user-row">
            <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                <img class="img-circle"
                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                     alt="User Pic">
            </div>
            <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
                <strong>${user.userName}</strong><br>
                <span class="text-muted">User Permissions: ${user.userType}</span>
            </div>
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 dropdown-user" data-for=".cyruxx">
                <i name="panelsButton" class="glyphicon glyphicon-chevron-down text-muted"></i>
            </div>
        </div>


        <div class="row user-infos cyruxx">
            <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-xs-offset-0 col-sm-offset-0 col-md-offset-1 col-lg-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">User information</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
                                <img class="img-circle"
                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                                     alt="User Pic">
                            </div>
                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
                                <strong>${user.userName}</strong><br>
                                <dl>
                                    <dt>Name:</dt>
                                    <dd>${user.firstName} ${user.lastName}</dd>
                                    <dt>User Permissions:</dt>
                                    <dd>${user.userType}</dd>
                                    <dt>Registered since:</dt>
                                    <dd>${user.dateAdded}</dd>
                                    <dt>Email:</dt>
                                    <dd>${user.email}</dd>
                                    <dt>Gender:</dt>
                                    <dd>${user.gender}</dd>
                                </dl>
                            </div>
                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
                                <strong>${user.userType}</strong><br>
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>Name:</td>
                                        <td>${user.firstName} ${user.lastName}</td>
                                    </tr>
                                    <tr>
                                        <td>User Permissions:</td>
                                        <td>${user.userType}</td>
                                    </tr>
                                    <tr>
                                        <td>Registered since:</td>
                                        <td>${user.dateAdded}</td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td>${user.email}</td>
                                    </tr>
                                    <tr>
                                        <td>Gender:</td>
                                        <td>${user.gender}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-sm btn-primary" type="button"
                                data-toggle="tooltip"
                                data-original-title="Send message to user"><i class="glyphicon glyphicon-envelope"></i>
                        </button>
                        <span class="pull-right">
                            <button class="btn btn-sm btn-warning" type="button"
                                    data-toggle="tooltip"
                                    data-original-title="Edit this user"><i class="glyphicon glyphicon-edit"></i>
                            </button>
                            <button class="btn btn-sm btn-danger" type="button"
                                    data-toggle="tooltip"
                                    data-original-title="Remove this user"><i class="glyphicon glyphicon-remove"></i>
                            </button>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

    <script type="text/javascript">

    var buttons = document.getElementsByName("panelsButton");
    for(var x in buttons) {
        x.onclick = function() {
            var button = document.getElementsByName("panelsButton")[x];
            console.log(button.className);
            if(button.className === "glyphicon glyphicon-chevron-up text-muted") {
                button.className = "glyphicon glyphicon-chevron-down text-muted";
            } else if (button.className === "glyphicon glyphicon-chevron-down text-muted") {
                button.className = "glyphicon glyphicon-chevron-up text-muted";
            }
        }
    };
    </script>
</div>
<%--end of user information tabs--%>

<c:import url="/WEB-INF/view/parts/footer.jsp"/>
</body>
</html>
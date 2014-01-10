<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Jonrah | Registration Form</title>
    <c:import url="/WEB-INF/view/parts/header.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/view/parts/top-navbar.jsp"/>




<div class="background-panel-signup">

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
            <legend><a href="http://www.jquery2dotnet.com"><i class="glyphicon glyphicon-globe"></i></a> Sign up for Jonrah!</legend>
            <c:url var="userRegistration" value="saveUser.html" />
            <form id="registerForm" modelAttribute="user" method="post" class="form" role="form"
                    action="${userRegistration}">
                <div class="row">
                    <div class="col-xs-6 col-md-6">
                        <input class="form-control" name="firstName" placeholder="First Name" type="text" path="firstName"
                               required autofocus />
                    </div>
                    <div class="col-xs-6 col-md-6">
                        <input class="form-control" name="lastName" placeholder="Last Name" type="text" path="lastName" required />
                    </div>
                </div>
                <input class="form-control" name="email" placeholder="Your Email" type="email" path="email"/>
                <input class="form-control" name="password" placeholder="New Password" type="password" path="password"/>
                <input class="form-control" name="userName" placeholder="Select a User Name" type="userName" path="userName"/>
                <label class="radio-inline">
                    <input type="radio" name="sex" id="inlineCheckbox1" value="male" />
                    Male
                </label>
                <label class="radio-inline">
                    <input type="radio" name="sex" id="inlineCheckbox2" value="female" />
                    Female
                </label>
                <br />
                <br />
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign up</button>
            </form>
        </div>
    </div>
</div>
    <%--end of signup form--%>
</div>
<%--end of panel--%>

    <%--<div class="container">--%>

        <%--<div style="color: teal; font-size: 30px">Jonrah |--%>
            <%--Registration Form</div>--%>

		<%--<c:url var="userRegistration" value="saveUser.html" />--%>
		<%--<form:form id="registerForm" class="form-signin" modelAttribute="user" method="post"--%>
			<%--action="${userRegistration}">--%>

			<%--<table width="600px" height="350px">--%>
                <%--<tr>--%>
                    <%--<td><form:label path="userName">User Name</form:label></td>--%>
                    <%--<td><form:input path="userName" /></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td><form:label path="password">Password</form:label></td>--%>
                    <%--<td><form:input path="password" /></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
					<%--<td><form:label path="firstName">First Name</form:label></td>--%>
					<%--<td><form:input path="firstName" /></td>--%>
				<%--</tr>--%>
				<%--<tr>--%>
					<%--<td><form:label path="lastName">Last Name</form:label></td>--%>
					<%--<td><form:input path="lastName" /></td>--%>
				<%--</tr>--%>
				<%--<tr>--%>
					<%--<td><form:label path="gender">Gender</form:label></td>--%>
					<%--<td><form:radiobuttons path="gender" items="${model.gender}" /></td>--%>
				<%--</tr>--%>
				<%--<tr>--%>
                    <%--<td><form:label path="email">Email Address</form:label></td>--%>
                    <%--<td><form:input path="email" /></td>--%>
                <%--</tr>--%>
				<%--<tr>--%>
					<%--<td></td>--%>
					<%--<td><input type="submit" value="Register" /></td>--%>
				<%--</tr>--%>
			<%--</table>--%>
		<%--</form:form>--%>

    <%--</div>--%>
    <c:import url="/WEB-INF/view/parts/footer.jsp"/>
</body>
</html>
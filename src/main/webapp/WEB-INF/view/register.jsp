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
	<center>

		<div style="color: teal; font-size: 30px">Jonrah |
			Registration Form</div>

		<c:url var="userRegistration" value="saveUser.html" />
		<form:form id="registerForm" modelAttribute="user" method="post"
			action="${userRegistration}">
			<table width="500px" height="200px">
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender</form:label></td>
					<td><form:radiobuttons path="gender" items="${model.gender}" /></td>
				</tr>
				<tr>
                    <td><form:label path="email">Email Address</form:label></td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td><form:label path="userType">User Type</form:label></td>
                    <td><form:select path="userType" items="${model.userType}" /></td>
                </tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>


		<a href="userList.html">Click Here to see User List</a>
	</center>
</body>
</html>
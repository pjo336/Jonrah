<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jonrah | User Details</title>
</head>
<body>
	<center>
		<div style="color: teal; font-size: 30px">Jonrah | User
			Details</div>
		<c:if test="${!empty user}">
			<table border="1" bgcolor="black" width="700px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					<td>User Id</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Gender</td>
					<td>Email Address</td>
					<td>User Type</td>
                    <td>Delete User</td>
				</tr>

				<c:forEach items="${user}" var="user">
                <c:url var="userDelete" value="deleteUser.html" />
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.gender}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.userType}" /></td>
                        <td>
                            <c:if test="${!empty user}">

                            <form:form id="deleteForm" modelAttribute="user" method="post"
                                action="${userDelete}">
                                <input type="hidden" name="id" value="${user.id}"/>
                                <input type="submit" value="Delete" />
                            </form:form>
                            </c:if>
                        </td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="register.html">Click Here to add new User</a>
	</center>
</body>
</html>
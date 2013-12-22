<%--
  Created by IntelliJ IDEA.
  User: pjo336
  Date: 12/21/13
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
    <c:import url="/WEB-INF/view/parts/header.jsp"/>
    <style>
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>

</head>
<body onload='document.f.j_username.focus();'>
<div class="container">

<c:if test="${not empty error}">
    <div class="errorblock">
        Your login attempt was not successful, try again.<br /> Caused :
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if>
<form name='f' class="form-signin" action="<c:url value='j_spring_security_check' />"
      method='POST' style="display: table;
    margin: 0 auto;">

<h2 class="form-signin-heading">Please sign in</h2>
    <table>
        <tr>
            <td><input type='text' name='j_username' value='' class="form-control" placeholder="Email Address">
            </td>
        </tr>
        <tr>
            <td><input type='password' name='j_password' class="form-control" placeholder="Password"/>
            </td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit"
                                   value="submit" class="btn btn-lg btn-primary btn-block"/>
            </td>
        </tr>
        <div></div>
        <tr>
            <td colspan='2'><input name="reset" type="reset" class="btn btn-lg btn-primary btn-block"/>
            </td>
        </tr>
    </table>
</form>

</div>
</body>
</html>
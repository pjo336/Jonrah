<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
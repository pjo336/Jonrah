<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
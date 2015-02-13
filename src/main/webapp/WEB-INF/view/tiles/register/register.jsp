<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">

    <div class="main-body">
        <div class="jumbotron">

            <form:form modelAttribute="user" class="form-signin" method="post" action="/register" role="form">
                <h2 class="form-signin-heading">Sign up for access</h2>

                <p>Username</p>
                <input type="text" id="inputUsername" name="userName" class="form-control" placeholder="Username" required autofocus>

                <p>First Name</p>
                <input type="text" id="inputFirstName" name="firstName" class="form-control" placeholder="First Name" required autofocus>

                <p>Last Name</p>
                <input type="text" id="inputLastName" name="lastName" class="form-control" placeholder="Last Name" required autofocus>

                <p>Email address</p>
                <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>

                <p>Password</p>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>

                <p>Gender</p>
                <select id="inputGender" name="gender" class="form-control" required autofocus>
                    <option value="0">Male</option>
                    <option value="1">Female</option>
                </select> <br />

                <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
            </form:form>
        </div>
    </div>

</div>
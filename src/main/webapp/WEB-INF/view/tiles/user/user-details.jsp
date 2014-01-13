<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="searchbar">
    <div class="container">
        <div class="row" style="position: relative;">
            <div class="col-lg-3">
                <div class="input-group custom-search-form" style="position: absolute; bottom: 25px; left:900px;">
                    <input type="text" class="form-control">
              <span class="input-group-btn">
              <button class="btn btn-default" type="button">
                  <span class="glyphicon glyphicon-search"></span>
              </button>
             </span>
                </div>
                <!-- /input-group -->
            </div>
        </div>
    </div>
</div>
<div class="user-list-section">
<section class="ac-container">

    <c:forEach items="${user}" var="user">
        <div>
            <input id="ac-${user.id}" name="accordion-1" type="checkbox"/>
            <label for="ac-${user.id}"><div class="row user-row">
                <div class="col-xs-3 col-sm-2 col-md-1 col-lg-1">
                    <img class="img-circle"
                         src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
                         alt="User Pic">
                </div>
            </div>
                <b>Username: </b> ${user.userName} <br/>
                <b>Name: </b> ${user.firstName} ${user.lastName}
            </label>


            <div class="ac-small">
                <div class="main-user-header well col-xs-8 col-sm-8 col-md-8 col-lg-8 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">

                    <div class="row user-row">

                        <div class="col-xs-8 col-sm-9 col-md-10 col-lg-10">
                            <strong>${user.userName}</strong><br>
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
                                            data-original-title="Send message to user"><i
                                            class="glyphicon glyphicon-envelope"></i>
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
                </div>
            </div>
        </div>

    </c:forEach>
</section>
</div>
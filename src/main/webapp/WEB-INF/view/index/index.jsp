<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Jonrah</title>
    <c:import url="/WEB-INF/view/parts/header.jsp"/>
</head>
<!-- NAVBAR
================================================== -->
<body>
<c:import url="/WEB-INF/view/parts/top-navbar.jsp"/>

<div class="container">
<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide" alt="Trustt">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Trustt Issue Management</h1>
                    <p>Bug tracking software that doesn't bite</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Trustt</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide" alt="Solace">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Solace Source Control</h1>
                    <p>Every branch right at your fingertips.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Solace</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide" alt="Valor">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Valor Timesheets</h1>
                    <p>Highly integrated with what you do. More results, less work.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Valor</a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div><!-- /.carousel -->



<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="/static/images/david.jpeg" alt="Deja Vu" style="height: 145px; width: 145px;">
            <h2>Nerds</h2>
            <p>They totally write the best code</p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" data-src="holder.js/140x140" alt="Prodigy">
            <h2>Prodigy</h2>
            <p>Payroll? I dont remember what the other app is</p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" data-src="holder.js/140x140" alt="Jonrah">
            <h2>Jonrah Development Portal</h2>
            <p>Everything a developer needs, in one spot.</p>
            <p><a class="btn btn-default" href="#" role="button">Read more &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading" style="color: teal;">Deja Vu <br /><span class="text-muted">Don't get caught repeating yourself.</span></h2>
            <p class="lead">Deja Vu determines common coding patterns and integrates them automatically into your code. You get all the consistency with none of the work.</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive" src="/static/images/valor.jpg" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-5">
            <img class="featurette-image img-responsive" src="/static/images/Trustt.jpg" alt="Generic placeholder image">
        </div>
        <div class="col-md-7">
            <h2 class="featurette-heading" style="color: teal;">Trustt Issue Management <br /><span class="text-muted"> Bug tracking software that doesn't bite</span></h2>
            <p class="lead">Tied directly in with your IDE and source control. No more keeping track of bug numbers. Find exactly what you're looking for in seconds.</p>
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading" style="color: teal;">Solace Source Control<br /><span class="text-muted"> Every Branch at your fingertips</span></h2>
            <p class="lead">Blah blah blah. Ingegration! Buzz words!</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive" src="/static/images/Solace.jpg" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->


    <!-- FOOTER -->
    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2013 Jonrah, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>

</div><!-- /.container -->
<script type="text/javascript" src="/static/lib/bootstrap/js/holder.js"></script>
<c:import url="/WEB-INF/view/parts/footer.jsp"/>
</body>
</html>

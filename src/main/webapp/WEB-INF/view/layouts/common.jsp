<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><tiles:insertAttribute name="title" defaultValue="Jonrah"/></title>
    <tiles:insertAttribute name="html-header"/>
    <tiles:insertAttribute name="custom-styles " defaultValue=""/>
</head>
<body>
<tiles:insertAttribute name="top-navbar" />
<tiles:insertAttribute name="sidebar" defaultValue="" />
<tiles:insertAttribute name="header" defaultValue=""/>
<tiles:insertAttribute name="body" />
</body>
<footer>
<tiles:insertAttribute name="footer" />
<tiles:insertAttribute name="custom-scripts" defaultValue=""/>
</footer>
</html>

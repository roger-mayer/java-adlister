<%--
  Created by IntelliJ IDEA.
  User: rogermayer
  Date: 1/7/20
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <style type="text/css">
        <%@include file="./resources/static/css/general.css" %>
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>
<%@ include file="partials/banner.jsp" %>
<h1>Hello ${param.username}!</h1>
</body>
</html>

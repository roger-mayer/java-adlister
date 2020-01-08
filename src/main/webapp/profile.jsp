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
    <jsp:include page="/partials/head.jsp" >
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<div class="container">
<h1>Hello ${param.username}!</h1>
</div>

</body>
</html>


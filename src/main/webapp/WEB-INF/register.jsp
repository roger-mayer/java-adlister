<%--
  Created by IntelliJ IDEA.
  User: rogermayer
  Date: 1/15/20
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Please Register</h1>
    <form action="/register" method="POST">
        <div class="form-group">
            <label for="newUsername">Username</label>
            <input id="newUsername" name="newUsername" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="newEmail">Email</label>
            <input id="newEmail" name="newEmail" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="newPassword">Password</label>
            <input id="newPassword" name="newPassword" class="form-control" type="password" required>
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Log In">
    </form>
</div>
</body>
</html>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
    <c:if test="true">
        <h1>INDEX</h1>
    </c:if>
    <c:if test="false">
        <h1>heres a false test </h1>
    </c:if>
</body>
</html>


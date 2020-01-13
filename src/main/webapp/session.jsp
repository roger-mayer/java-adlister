<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rogermayer
  Date: 1/13/20
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
<h1>This is a session Jsp</h1>
<br>
<h2><c:out value="${requestScope.reqAt}"/></h2>
<h2><c:out value="${sessionScope.sesAt}"/></h2>
<h2><c:out value="${applicationScope.sesAt}"/></h2>


<h2>This is how to get session data: <c:out value="${sessionScope.name}"/></h2>
<h2>You have: <c:out value="${sessionScope.cart.numItems}"/> items in your cart</h2>
<br>
<p>Timeout in seconds: <c:out value="${pageContext.session.maxInactiveInterval}"/></p>

</h2>

</body>
</html>

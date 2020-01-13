<%--
VIEW- INDEX PAGE FOR ALL ADDS. Receivces info from AdsServlet
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to the Adlister!</h1>
        <c:forEach var="ad" items="${ads}">
        <div class="col-md-6" >
            <h2>${ad.title}</h2>
            <h3>${ad.description}</h3>
        </div>
    </c:forEach>
    </div>
</body>
</html>


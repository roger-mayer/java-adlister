<%--
  Created by IntelliJ IDEA.
  User: rogermayer
  Date: 1/10/20
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
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
<div class="container">
    <h1>Here are your contacts!</h1>
    <c:forEach var="contact" items="${contacts}">
        <div class="col-md-6" >
            <h2>${contact.firstName} ${contact.lastName}</h2>
            <h3>${contact.phoneNumber}</h3>
            <form id="${contact.id}" action="/UpdateContact" method="post">
                <button>Edit Contact</button>
            </form>



        </div>
    </c:forEach>




</div>
<form action="ContactsManager/AddContact.jsp">
    <button>Add Contact</button>
</form>
<form action="ContactsManager/UpdateContact.jsp">
    <button>Update Contact</button>
</form>
<form action="DeleteContactServlet">
    <button>Delete Contact</button>
</form>


</body>
</html>

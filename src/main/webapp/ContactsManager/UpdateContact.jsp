<%--
  Created by IntelliJ IDEA.
  User: rogermayer
  Date: 1/10/20
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <form action="/ContactsServlet" method="post">
        <label name="updateFirstName">First Name </label>
        <input type="text" name="updateFirstName" id="updateFirstName" value="${updateContact.firstName}">
        <br>
        <label name="updateLastName">Last Name </label>
        <input type="text" name="updateLastName" id="updateLastName" value="${updateContact.lastName}">
        <br>
        <label name="updatePhoneNumber">Phone Number </label>
        <input type="text" name="updatePhoneNumber" id="updatePhoneNumber" value="${updateContact.phoneNumber}">
        <br>
        <input type="submit">
        <button type="submit">Edit Contact</button>


<%--        <form action="UpdateContactServlet">--%>
<%--            <button>Update Contact</button>--%>
<%--        </form>--%>
    </form>


</head>
<body>

</body>
</html>

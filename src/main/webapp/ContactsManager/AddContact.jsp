<%--VIEW contact from--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Add A Contact</title>
</head>
<body>
<form action="/AddContact" method="post">
    <label name="firstName">First Name </label>
    <input type="text" name="firstName" id="firstName">
    <br>
    <label name="lastName">Last Name </label>
    <input type="text" name="lastName" id="lastName">
    <br>
    <label name="phoneNumber">Phone Number </label>
    <input type="text" name="phoneNumber" id="phoneNumber">
    <br>
    <input type="submit">

</form>

</body>
</html>

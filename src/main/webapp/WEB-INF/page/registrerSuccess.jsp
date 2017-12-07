<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2017/12/2
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="success">
    Confirmation message : ${success}
    <br>
    Would you like to <a href="<c:url value='/register' />">Add More Users</a>?
    <br/>
    Go to <a href="<c:url value='/home' />">Admin Page</a> OR <a href="<c:url value="/logout" />">Logout</a>
</div>

</body>
</html>

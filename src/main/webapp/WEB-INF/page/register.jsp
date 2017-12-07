<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2017/12/2
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="form-container">

    <h1>New User Registration Form</h1>
    <c:url var="register" value="/register" />
    <form:form method="POST" modelAttribute="user" action="${register}" class="form-horizontal">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="userName">userName</label>
                <div class="col-md-7">
                    <form:input type="text" path="userName" id="userName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="userName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="passWord">passWord</label>
                <div class="col-md-7">
                    <form:input type="password" path="passWord" id="passWord" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="passWord" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


<%--        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="userToProfileidHashSet">Roles</label>
                <div class="col-md-7">
                    <form:select path="userToProfileidHashSet" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="userToProfileidHashSet" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>--%>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="profileids">Roles</label>
                <div class="col-md-7">
                    <form:select path="profileids" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="profileids" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Register" class="btn btn-primary btn-sm"> or <a href="<c:url value='/admin' />">Cancel</a>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04.05.17
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8"/>
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>Регистрация</h1>

<sf:form method="POST" commandName="user" acceptCharset="UTF-8">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <sf:label path="username"
              cssErrorClass="error">Логин:</sf:label>
    <sf:input path="username" cssErrorClass="error"/><br/>
    <sf:label path="firstName"
              cssErrorClass="error">Имя:</sf:label>
    <sf:input path="firstName" cssErrorClass="error"/><br/>
    <sf:label path="lastName"
              cssErrorClass="error">Фамилия:</sf:label>
    <sf:input path="lastName" cssErrorClass="error"/><br/>
    <sf:label path="email"
              cssErrorClass="error">Email:</sf:label>
    <sf:input path="email" cssErrorClass="error"/><br/>
    <sf:label path="password"
              cssErrorClass="error">Пароль:</sf:label>
    <sf:password path="password" cssErrorClass="error"/><br/>
    <input type="submit" value="Подтвердить"/>
</sf:form>
</body>
</html>

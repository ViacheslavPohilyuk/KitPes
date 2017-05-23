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
          href="<c:url value="/resources/page.css" />">
</head>
<body>
<a href="<c:url value="/" />">На главную</a><br/>
<h1>Регистрация</h1>

<sf:form method="POST" commandName="user" acceptCharset="UTF-8">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <table>
        <tr>
            <td><sf:label path="username"
                          cssErrorClass="error">Логин:</sf:label></td>
            <td><sf:input path="username" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><sf:label path="firstName"
                          cssErrorClass="error">Имя:</sf:label></td>
            <td><sf:input path="firstName" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><sf:label path="lastName"
                          cssErrorClass="error">Фамилия:</sf:label></td>
            <td><sf:input path="lastName" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><sf:label path="email"
                          cssErrorClass="error">Email:</sf:label></td>
            <td><sf:input path="email" cssErrorClass="error"/></td>
        </tr>
        <tr>
            <td><sf:label path="password"
                          cssErrorClass="error">Пароль:</sf:label></td>
            <td><sf:password path="password" cssErrorClass="error"/></td>
        </tr>
    </table>
    <input type="submit" value="Подтвердить"/>
</sf:form>
</body>
</html>

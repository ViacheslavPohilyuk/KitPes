<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 11.04.17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
</head>
<body>
<h1>Вход</h1>

<sf:form method="POST" commandName="user">
    <sf:errors path="username" element="div" cssClass="errors"/>
    <sf:errors path="password" element="div" cssClass="errors"/>
    <sf:label path="username"
              cssErrorClass="error">Логин:</sf:label>
    <sf:input path="username" cssErrorClass="error"/><br/>
    <sf:label path="password"
              cssErrorClass="error">Пароль:</sf:label>
    <sf:password path="password" cssErrorClass="error"/><br/>
    <input type="submit" value="Подтвердить"/>
</sf:form>
</body>
</html>
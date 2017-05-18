<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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

<sf:form method="POST" commandName="organization" acceptCharset="UTF-8">
    <sf:errors path="*" element="div" cssClass="errors"/>
    <sf:label path="name"
              cssErrorClass="error">Логин:</sf:label>
    <sf:input path="name" cssErrorClass="error"/><br/>
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

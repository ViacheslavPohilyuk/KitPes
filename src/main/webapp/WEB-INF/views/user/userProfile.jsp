<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04.05.17
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8"/>
    <title>Профиль пользователя</title>
</head>
<body>
<h1>Профиль пользователя <c:out value="${user.username}"/></h1>
<table>
    <tr>
        <td>Логин:</td>
        <td><c:out value="${user.username}"/><br/></td>
    </tr>
    <tr>
        <td>Имя:</td>
        <td><c:out value="${user.firstName}"/><br/></td>
    </tr>
    <tr>
        <td>Фамилия:</td>
        <td><c:out value="${user.lastName}"/><br/></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><c:out value="${user.email}"/><br/></td>
    </tr>
    <tr>
        <td>Пароль:</td>
        <td><c:out value="${user.password}"/><br/></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/user/edit/${user.id}" />">редактировать</a> |
            <a href="<c:url value="/user/delete/${user.id}" />">удалить</a></td>
    </tr>
</table>
</body>
</html>

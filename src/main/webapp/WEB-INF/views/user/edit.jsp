<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04.05.17
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Редактировать данные</title>
</head>
<body>
<form action="/user/edit" method="POST">
    <h1>Редактировать данные</h1>
    <table>
        <tr>
            <td><input type="hidden" name="id" value="<c:out value="${user.id}" />"/></td>
        </tr>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="username" value="<c:out value="${user.username}"/>"/><br/></td>
        </tr>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="firstName" value="<c:out value="${user.firstName}"/>"/><br/></td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><input type="text" name="lastName" value="<c:out value="${user.lastName}"/>"/><br/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="<c:out value="${user.email}"/>"/><br/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="text" name="password" value="<c:out value="${user.password}"/>"/><br/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Изменить"/></td>
            <td><%-- Cancel the editing --%>
                <form action="/user/${user.id}" method="GET">
                    <input type="submit" value="Отменить"/>
                </form>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

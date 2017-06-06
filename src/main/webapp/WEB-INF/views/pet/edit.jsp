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
    <title>Pet</title>
</head>
<body>
<a href="<c:url value="/" />">На главную</a> |
<a href="<c:url value="/pet/${pet.id}?userID=${pet.userID}" />">В профиль питомца</a>
<form action="/pet/edit" method="POST">
    <h1>Изменить данные питомца</h1>
    <table>
        <tr>
            <td><input type="hidden" name="id" value="<c:out value="${pet.id}" />"/></td>
        </tr>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="name" value="<c:out value="${pet.name}" />"/></td>
        </tr>
        <tr>
            <td>Вид:</td>
            <td><input type="text" name="animal" value="<c:out value="${pet.animal}" />"/></td>
        </tr>
        <tr>
            <td>Возраст:</td>
            <td><input type="text" name="age" value="<c:out value="${pet.age}" />"/></td>
        </tr>
        <tr>
            <td>Пол:</td>
            <td><input type="text" name="sex" value="<c:out value="${pet.sex}" />"/></td>
        </tr>
        <tr>
            <td>Состояние здоровья:</td>
            <td><input type="text" name="status" value="<c:out value="${pet.status}" />"/></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type="text" name="description" value="<c:out value="${pet.description}" />"/></td>
        </tr>
    </table>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>

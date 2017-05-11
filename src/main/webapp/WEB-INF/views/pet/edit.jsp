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
<form action="/pet/edit" method="POST">
    <%-- ТУТ БЕРУТЬСЯ ДАНІ З МОДЕЛІ PET --%>
    <h1>Изменить данные питомца</h1>
    <table>
        <tr>
            <td><input type="hidden" name="id" value="<c:out value="${pet.id}" />"/></td>
        </tr>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name" value="<c:out value="${pet.name}" />"/></td>
        </tr>
        <tr>
            <td>animal:</td>
            <td><input type="text" name="animal" value="<c:out value="${pet.animal}" />"/></td>
        </tr>
        <tr>
            <td>age:</td>
            <td><input type="text" name="age" value="<c:out value="${pet.age}" />"/></td>
        </tr>
        <tr>
            <td>sex:</td>
            <td><input type="text" name="sex" value="<c:out value="${pet.sex}" />"/></td>
        </tr>
        <tr>
            <td>description:</td>
            <td><input type="text" name="description" value="<c:out value="${pet.description}" />"/></td>
        </tr>
        <tr>
            <td>status:</td>
            <td><input type="text" name="status" value="<c:out value="${pet.status}" />"/></td>
        </tr>
        <tr>
            <td>organization:</td>
            <td><input type="text" name="organization" value="<c:out value="${pet.organization}" />"/></td>
        </tr>
    </table>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>

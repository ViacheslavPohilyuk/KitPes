<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Добавить организейшн</title>
</head>
<body>
<a href="<c:url value="/" />">На главную</a> |
<a href="<c:url value="/user/${userID}" />">В профиль</a>
<h1>Добавить организацию</h1>
<form action="/organization/new" method="POST">
    <table>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name"/><br/></td>
        </tr>

        <tr>
            <td>address:</td>
            <td><input type="text" name="address"/><br/></td>
        </tr>
        <tr>
            <td>description:</td>
            <td><input type="text" name="description"/><br/></td>
        </tr>
        <tr>
            <td><input type="hidden" name="userID" value="<c:out value="${userID}"/>"/></td>
        </tr>
    </table>
    <input type="submit" value="Создать"/>
</form>
</body>
</html>


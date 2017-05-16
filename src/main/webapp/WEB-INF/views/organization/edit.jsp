<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Organization</title>
</head>
<body>
<form action="/organization/edit" method="POST">
    <%-- ТУТ БЕРУТЬСЯ ДАНІ З МОДЕЛІ ORGANIZATION --%>
    <h1>Изменить данные организации</h1>
    <table>
        <tr>
            <td><input type="hidden" name="id" value="<c:out value="${organization.id}" />"/></td>
        </tr>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name" value="<c:out value="${organization.name}" />"/></td>
        </tr>
        <tr>
            <td>address:</td>
            <td><input type="text" name="address" value="<c:out value="${organization.address}" />"/></td>
        </tr>
        <tr>
            <td>cellNumber:</td>
            <td><input type="number" name="age" value="<c:out value="${pet.age}" />"/></td>
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

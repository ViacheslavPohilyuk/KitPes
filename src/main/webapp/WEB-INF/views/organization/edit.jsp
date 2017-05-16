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
            <td><input type="number" name="cellNumber" value="<c:out value="${organization.cellNumber}" />"/></td>
        </tr>
        <tr>
            <td>openingHours:</td>
            <td><input type="time" name="openingHours" value="<c:out value="${organization.openingHours}" />"/></td>
        </tr>
        <tr>
            <td>workingDays:</td>
            <td><input type="text" name="workingDays" value="<c:out value="${organization.workingDays}" />"/></td>
        </tr>
        <tr>
            <td>description:</td>
            <td><input type="text" name="description" value="<c:out value="${organization.description}" />"/></td>
        </tr>
    </table>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04.05.17
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Pet</title>
</head>
<body>
    <c:choose>
        <c:when test="${pet.id != null}">
            <h1>Профиль питомца <c:out value="${pet.name}"/></h1>
            name: <c:out value="${pet.name}"/><br/>
            animal: <c:out value="${pet.animal}"/><br/>
            age: <c:out value="${pet.age}"/><br/>
            sex: <c:out value="${pet.sex}"/><br/>
            description: <c:out value="${pet.description}"/><br/>
            status: <c:out value="${pet.status}"/><br/>
            organization: <c:out value="${pet.organization}"/><br/>
        </c:when>
        <c:otherwise>
            <text>No pet with such id</text>
        </c:otherwise>
    </c:choose>
</body>
</html>

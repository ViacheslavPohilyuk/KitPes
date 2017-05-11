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
    <h1>Профиль питомца <c:out value="${pet.name}"/></h1>
    name: <c:out value="${pet.name}"/><br/>
    animal: <c:out value="${pet.animal}"/><br/>
    age: <c:out value="${pet.age}"/><br/>
    sex: <c:out value="${pet.sex}"/><br/>
    description: <c:out value="${pet.description}"/><br/>
    status: <c:out value="${pet.status}"/><br/>
    organization: <c:out value="${pet.organization}"/><br/>
    <a href="<c:url value="/pet/edit/${pet.id}" />">редактировать</a> |
    <a href="<c:url value="/pet/delete/${pet.id}" />">удалить</a>
</body>
</html>

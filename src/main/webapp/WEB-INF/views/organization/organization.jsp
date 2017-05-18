<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Organization</title>
</head>
<body>
    <h1>Organization профиль <c:out value="${organization.name}"/></h1>
    name: <c:out value="${organization.name}"/><br/>
    address: <c:out value="${organization.address}"/><br/>
    description: <c:out value="${organization.description}"/><br/>
    <a href="<c:url value="/organization/edit/${organization.id}" />">редактировать</a> |
    <a href="<c:url value="/organization/delete/${organization.id}" />">удалить</a>
</body>
</html>

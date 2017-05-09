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
    <title>Pet</title>
</head>
<h1>Изменить данные питомца</h1>
<body>
<form action="/pet/edit" method="POST">
    id: <input type="text" name="id" value="<c:out value="${pet.id}" />"/><br/>
    name: <input type="text" name="name" value="<c:out value="${pet.name}" />"/><br/>
    animal: <input type="text" name="animal" value="<c:out value="${pet.animal}" />"/><br/>
    age: <input type="text" name="age" value="<c:out value="${pet.age}" />"/><br/>
    sex: <input type="text" name="sex" value="<c:out value="${pet.sex}" />"/><br/>
    description: <input type="text" name="description" value="<c:out value="${pet.description}" />"/><br/>
    status: <input type="text" name="status" value="<c:out value="${pet.status}" />"/><br/>
    organization: <input type="text" name="organization" value="<c:out value="${pet.organization}" />"/><br/>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>

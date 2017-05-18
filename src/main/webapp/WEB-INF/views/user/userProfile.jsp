<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04.05.17
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
    <title>Профиль пользователя</title>
</head>
<body>
<h1>Профиль пользователя <c:out value="${user.username}"/></h1>
<table>
    <tr>
        <td>Логин:</td>
        <td><c:out value="${user.username}"/><br/></td>
    </tr>
    <tr>
        <td>Имя:</td>
        <td><c:out value="${user.firstName}"/><br/></td>
    </tr>
    <tr>
        <td>Фамилия:</td>
        <td><c:out value="${user.lastName}"/><br/></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><c:out value="${user.email}"/><br/></td>
    </tr>
    <tr>
        <td>Пароль:</td>
        <td><c:out value="${user.password}"/><br/></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/user/edit/${user.id}" />">редактировать</a> |
            <a href="<c:url value="/user/delete/${user.id}" />">удалить</a></td>
    </tr>

    <%-- All pets of this user --%>
    <tr>
        <div class="listTitle">
            <ul class="petList">
                <table border="1">
                    <h3>Питомцы пользователя</h3>
                    <a href="<c:url value="/pet/new?userID=${user.id}" />">добавить питомца</a>
                    <c:forEach var="pet" items="${petList}">
                        <tr>
                            <td>
                                <div id="pet_<c:out value="pet.id"/>">
                                    id: <c:out value="${pet.id}"/><br/>
                                    name: <c:out value="${pet.name}"/><br/>
                                    animal: <c:out value="${pet.animal}"/><br/>
                                    age: <c:out value="${pet.age}"/><br/>
                                    sex: <c:out value="${pet.sex}"/><br/>
                                    description: <c:out value="${pet.description}"/><br/>
                                    status: <c:out value="${pet.status}"/><br/>
                                    organization: <c:out value="${pet.organization}"/><br/>
                                    <a href="<c:url value="/pet/edit/${pet.id}" />">редактировать</a> |
                                    <a href="<c:url value="/pet/delete/${pet.id}" />">удалить</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </ul>
        </div>
    </tr>
</table>
</body>
</html>

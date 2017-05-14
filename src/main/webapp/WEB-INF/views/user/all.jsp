<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 09.05.17
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8"/>
    <title>Питомцы</title>
</head>
<body>
<div class="listTitle">
    <h1>Пользователи</h1>
    <ul class="petList">
        <table border="1">
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>
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
                        </table>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </ul>
</div>
</body>
<%@ page import="java.io.File" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.nio.file.Paths" %><%--
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
          href="<c:url value="/resources/page.css" />">
    <title>Профиль пользователя</title>
</head>
<body>
<h1>Профиль пользователя <c:out value="${user.username}"/></h1>


<table>
    <tr>
        <td>
            <label>Аватар:</label><br/>
            <img alt="profile" width="200" height="200" src="<c:url value="/resources/images/profile.png" />"/>
            <form method="POST" action="/fileupload" enctype="multipart/form-data">
                <input type="file"
                       name="profilePicture"
                       accept="image/jpeg,image/png,image/gif"/><br/>
                <input type="hidden" name="userID" value="<c:out value="${user.id}"/>"/>
                <input type="submit" value="Добавить"/>
            </form>
        </td>
    </tr>
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
    <tr>
        <td>
            <%-- All pets of this user --%>
            <div class="listTitle">
                <ul class="petList">
                    <table border="1">
                        <h3>Питомцы пользователя</h3>
                        <a href="<c:url value="/pet/new?userID=${user.id}" />">добавить питомца</a>
                        <c:forEach var="pet" items="${petList}">
                            <tr>
                                <td>
                                    <div id="pet_<c:out value="pet.id"/>">
                                        name: <c:out value="${pet.name}"/><br/>
                                        animal: <c:out value="${pet.animal}"/><br/>
                                        age: <c:out value="${pet.age}"/><br/>
                                        sex: <c:out value="${pet.sex}"/><br/>
                                        description: <c:out value="${pet.description}"/><br/>
                                        status: <c:out value="${pet.status}"/><br/>
                                        organization: <c:out value="${pet.organization}"/><br/>
                                        <a href="<c:url value="/pet/edit/${pet.id}" />">редактировать</a> |
                                        <a href="<c:url value="/pet/delete/${pet.id}?userID=${user.id}" />">удалить</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </ul>
            </div>

            <%-- All organizations of this user --%>
            <div class="listTitle">
                <ul class="organizationList">
                    <table border="1">
                        <h3>Организации пользователя</h3>
                        <a href="<c:url value="/organization/new?userID=${user.id}" />">добавить организацию</a>
                        <c:forEach var="organization" items="${organizationList}">
                            <tr>
                                <td>
                                    <div id="organization<c:out value="organization.id"/>">
                                        name: <c:out value="${organization.name}"/><br/>
                                        address: <c:out value="${organization.address}"/><br/>
                                        description: <c:out value="${organization.description}"/><br/>
                                        <a href="<c:url value="/organization/edit/${organization.id}" />">редактировать</a>
                                        |
                                        <a href="<c:url value="/organization/delete/${organization.id}?userID=${user.id}" />">удалить</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </ul>
            </div>
        </td>
    </tr>
</table>

</body>
</html>

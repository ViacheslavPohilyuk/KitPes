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
    <title>Pet</title>
</head>
<body>

<a href="<c:url value="/" />">На главную</a> |

<%-- Resolving the redirection to a user's page or organisation's one --%>
<c:set var="redirection"/>
<c:choose>
    <c:when test="${pet.userID != 0}">
        <%-- To an user's profile--%>
        <a href="<c:url value="/user/${pet.userID}" />">В профиль</a>

        <%-- Assign redirection for the delete operation--%>
        <c:set var="redirection" value="userID=${pet.userID}"/>
    </c:when>
    <c:otherwise>
        <%-- To an organization's profile--%>
        <a href="<c:url value="/user/${userOrgID}" />">В профиль</a> |
        <a href="<c:url value="/organization/${pet.organizationID}" />">В профиль организации</a>

        <%-- Assign redirection for the delete operation--%>
        <c:set var="redirection" value="organizationID=${pet.organizationID}"/>
    </c:otherwise>
</c:choose>

<h1>Профиль питомца <c:out value="${pet.name}"/></h1>
<table>
    <tr>
        <td>
            <label>Аватар:</label><br/>
            <img alt="profile" width="240" height="200" id="profileImage" src="${pet.profileImgURL}"/>
            <form method="POST" action="/pet/fileupload" enctype="multipart/form-data">
                <input type="file"
                       name="profilePicture"
                       accept="image/jpeg,image/png,image/gif"/><br/>
                <input type="hidden" name="petID" value="<c:out value="${pet.id}"/>"/>
                <input type="submit" value="Добавить"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>name: <c:out value="${pet.name}"/></td>
    </tr>
    <tr>
        <td>animal: <c:out value="${pet.animal}"/></td>
    </tr>
    <tr>
        <td>age: <c:out value="${pet.age}"/></td>
    </tr>
    <tr>
        <td>sex: <c:out value="${pet.sex}"/></td>
    </tr>
    <tr>
        <td>description: <c:out value="${pet.description}"/></td>
    </tr>
    <tr>
        <td>status: <c:out value="${pet.status}"/></td>
    </tr>
    <tr>
        <td>
            <a href="<c:url value="/pet/edit/${pet.id}" />">редактировать</a> |
            <a href="<c:url value="/pet/delete/${pet.id}?${redirection}" />">удалить</a>
        </td>
    </tr>
</table>
</body>
</html>

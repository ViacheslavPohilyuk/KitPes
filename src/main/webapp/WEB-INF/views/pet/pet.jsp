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
    <c:when test="${userID != null}">
        <%-- To an user's profile--%>
        <a href="<c:url value="/user/${userID}" />">В профиль</a>

        <%-- Assign redirection for the delete operation--%>
        <c:set var="redirection" value="userID=${userID}"/>
    </c:when>
    <c:otherwise>
        <%-- To an organization's profile--%>
        <a href="<c:url value="/user/${userOrgID}" />">В профиль</a> |
        <a href="<c:url value="/organization/${organizationID}" />">В профиль организации</a>

        <%-- Assign redirection for the delete operation--%>
        <c:set var="redirection" value="organizationID=${organizationID}"/>
    </c:otherwise>
</c:choose>

<h1>Профиль питомца <c:out value="${pet.name}"/></h1>
<table>
    <tr>
        <td>
            name: <c:out value="${pet.name}"/><br/>
        </td>
    </tr>
    <tr>
        <td>
            animal: <c:out value="${pet.animal}"/><br/>
        </td>
    </tr>
    <tr>
        <td>
            age: <c:out value="${pet.age}"/><br/>
        </td>
    </tr>
    <tr>
        <td>
            sex: <c:out value="${pet.sex}"/><br/>
        </td>
    </tr>
    <tr>
        <td>
            description: <c:out value="${pet.description}"/><br/>
        </td>
    </tr>
    <tr>
        <td>
            status: <c:out value="${pet.status}"/><br/>
        </td>
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

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
    <h1>Питомцы</h1>
    <ul class="petList">
        <table border="1">
            <c:forEach var="pet" items="${petList}">
                <tr>
                    <td>
                            <%-- Resolving the redirection to a user's page or organisation's one --%>
                        <c:set var="redirection"/>
                        <c:choose>
                            <c:when test="${pet.userID != 0}">
                                <%-- Assign redirection for the delete operation--%>
                                <c:set var="redirection" value="userID=${pet.userID}"/>
                            </c:when>
                            <c:otherwise>
                                <%-- Assign redirection for the delete operation--%>
                                <c:set var="redirection" value="organizationID=${pet.organizationID}"/>
                            </c:otherwise>
                        </c:choose>

                        <div id="pet_<c:out value="pet.id"/>">
                            <table>
                                <tr>
                                    <td>
                                        <img alt="profile" width="120" height="100" id="petImage"
                                             src="${pet.profileImgURL}"/>
                                    </td>
                                    <td>
                                        <table>
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
                                                <td><a href="<c:url value="/pet/${pet.id}?${redirection}" />">
                                                    Перейти в профиль</a></td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </ul>
</div>
</body>
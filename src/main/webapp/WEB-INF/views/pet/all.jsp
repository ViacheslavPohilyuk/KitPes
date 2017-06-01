<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/page.css" />">
    <title>Приютить</title>
</head>
<body>

<div class="listTitle">
    <a href="<c:url value="/" />">На главную</a>
    <h1>Приютить</h1>
    <div class="filter">
        <label>Фильтровать результаты</label>

        <form action="/pet">
            <div class="selections">
                <select name="sex" id="sex">
                    <option value="sex">Пол</option>
                    <option value="male">Мужской</option>
                    <option value="female">Женский</option>
                </select>

                <select name="species" id="species">
                    <option value="species">Вид</option>
                    <option value="cat">Кот</option>
                    <option value="dog">Собака</option>
                </select>

                <select name="age" id="age">
                    <option value="age">Возраст</option>
                    <option value="0">менее года</option>
                    <option value="1">1-2 года</option>
                    <option value="2">2-3 года</option>
                    <option value="3">3-4 года</option>
                    <option value="4">4-5 года</option>
                    <option value="5">более 5 лет</option>
                </select>

                <select name="status" id="status">
                    <option value="status">Состояние</option>
                    <option value="healthy">Здоров</option>
                    <option value="ill">Болен</option>
                </select>

                <select name="org" id="org">
                    <option value="org">Организация</option>
                    <c:forEach var="org" items="${orgs}">
                        <option value="<c:out value="${org.id}"/>"><c:out value="${org.name}"/></option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Фильтровать"/>
        </form>
    </div>

    <ul class="petList">
        <c:forEach var="pet" items="${petList}">
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

            <div class="pet">
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
        </c:forEach>
    </ul>
</div>
</body>
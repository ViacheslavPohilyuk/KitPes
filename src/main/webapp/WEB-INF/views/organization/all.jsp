<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>Организации</title>
</head>
<body>

<div>
    <a href="<c:url value="/" />">На главную</a>
    <h1>Организации</h1>
    <div class="filter">
        <label>Фильтровать результаты</label>
        <form action="/organization">
            <div class="selections">
                <select name="type" id="type">
                    <option value="type">Тип</option>
                    <option value="0">Ветклиника</option>
                    <option value="1">Приют</option>
                </select>
            </div>
            <input type="submit" value="Фильтровать"/>
        </form>
    </div>

    <ul class="organizationList">
        <table border="1">
            <c:forEach var="organization" items="${organizationList}">
                <tr>
                    <td>
                        <div id="organization<c:out value="organization.id"/>">
                            <table>
                                <tr>
                                    <td>
                                        <img alt="profile" width="120" height="100" id="organizationImage"
                                             src="${organization.profileImgURL}"/>
                                    </td>
                                    <td>
                                        <table>
                                            <tr>
                                                <%-- Resolving a type's name of organization --%>
                                                <c:if test="${organization.type == 0}">
                                                    <c:set var="typeName" value="Ветклиника"/>
                                                </c:if>
                                                <c:if test="${organization.type == 1}">
                                                    <c:set var="typeName" value="Приют"/>
                                                </c:if>

                                                <td><c:out value="${typeName}"/> "<c:out value="${organization.name}"/>"
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Адрес:</td>
                                                <td><c:out value="${organization.address}"/></td>
                                            </tr>
                                            <tr>
                                                <td>Описание:</td>
                                                <td><c:out value="${organization.description}"/></td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <a href="<c:url value="/organization/${organization.id}" />">
                                                        Перейти в профиль</a>
                                                </td>
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
</html>
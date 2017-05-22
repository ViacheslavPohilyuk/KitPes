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
<div class="listTitle">
    <h1>Организации</h1>
    <ul class="organizationList">
        <table border="1">
            <c:forEach var="organization" items="${organizationList}">
                <table>
                    <tr>
                        <td>
                            name:
                        <td>
                            <c:out value="${organization.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            address:
                        </td>
                        <td>
                            <c:out value="${organization.address}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            description:
                        </td>
                        <td>
                            <c:out value="${organization.description}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="<c:url value="/organization/${organization.id}" />">Перейти в профиль</a>
                        </td>
                    </tr>
                </table>
            </c:forEach>
        </table>
    </ul>
</div>
</body>
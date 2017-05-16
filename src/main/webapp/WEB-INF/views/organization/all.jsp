<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>Организации</title>
</head>
<body>
<div class="listTitle">
    <h1>Организации</h1>
    <ul class="organizationList">
        <table border="1">
            <c:forEach var="organization" items="${organizationList}">
                <tr>
                    <td>
                        <div id="organization_<c:out value="organization.id"/>">
                            id: <c:out value="${organization.id}"/><br/>
                            name: <c:out value="${organization.name}"/><br/>
                            address: <c:out value="${organization.address}"/><br/>
                            cellNumber: <c:out value="${organization.cellNumber}"/><br/>
                            openingHours: <c:out value="${organization.openingHours}"/><br/>
                            workingDays: <c:out value="${organization.workingDays}"/><br/>
                            <a href="<c:url value="/organization/edit/${organization.id}" />">редактировать</a> |
                            <a href="<c:url value="/organization/delete/${organization.id}" />">удалить</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </ul>
</div>
</body>
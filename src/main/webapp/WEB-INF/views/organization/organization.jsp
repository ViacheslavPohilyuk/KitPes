<%@ page import="org.kitpes.entity.Organization" %>
<%@ page import="org.kitpes.entity.Pet" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Organization</title>
</head>
<body>
<a href="<c:url value="/" />">На главную</a> |
<a href="<c:url value="/user/${organization.userID}" />">В профиль</a>
<h1>Organization профиль <c:out value="${organization.name}"/></h1>

<table>
    <tr>
        <td>
            name:
        <td>
            <c:out value="${organization.name}"/><br/>
        </td>
    </tr>
    <tr>
        <td>
            address:
        </td>
        <td>
            <c:out value="${organization.address}"/><br/>
        </td>
    </tr>
    <tr>
        <td>
            description:
        </td>
        <td>
            <c:out value="${organization.description}"/><br/>
        </td>
    </tr>
    <tr>
        <td>
            <a href="<c:url value="/organization/edit/${organization.id}" />">редактировать</a> |
            <a href="<c:url value="/organization/delete/${organization.id}?userID=${organization.userID}" />">удалить</a>
        </td>
    </tr>


    <%-- All pets of this organization --%>
    <tr>
        <td>
            <div class="listTitle">
                <ul class="petList">
                    <table border="1">
                        <h3>Питомцы организации</h3>
                        <a href="<c:url value="/pet/new?organizationID=${organization.id}&userOrgID=${organization.userID}"/>">
                            добавить питомца
                        </a>
                        <c:forEach var="pet" items="${organization.pets}">
                            <tr>
                                <td>
                                    <div id="pet_<c:out value="pet.id"/>">
                                        <table>
                                            <tr>
                                                <td>
                                                    name: <c:out value="${pet.name}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    animal: <c:out value="${pet.animal}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    age: <c:out value="${pet.age}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    sex: <c:out value="${pet.sex}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    description: <c:out value="${pet.description}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    status: <c:out value="${pet.status}"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <a href="<c:url value="/pet/${pet.id}?organizationID=${organization.id}&userOrgID=${organization.userID}" />">
                                                        Перейти в профиль
                                                    </a>
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
        </td>
    </tr>
</table>
</body>
</html>

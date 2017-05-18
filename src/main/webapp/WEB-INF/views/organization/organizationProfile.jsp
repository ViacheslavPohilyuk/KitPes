<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
    <title>Профиль организации</title>
</head>
<body>
<h1>Профиль организации <c:out value="${organization.name}"/></h1>
<table>
    <tr>
        <td>имя:</td>
        <td><c:out value="${organization.name}"/><br/></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><c:out value="${organization.email}"/><br/></td>
    </tr>
    <tr>
        <td>Пароль:</td>
        <td><c:out value="${organization.password}"/><br/></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/organization/edit/${organization.id}" />">редактировать</a> |
            <a href="<c:url value="/organization/delete/${organization.id}" />">удалить</a></td>
    </tr>

    <%-- All pets of this organization--%>
    <tr>
        <div class="listTitle">
            <ul class="petList">
                <table border="1">
                    <h3>Питомцы организации</h3>
                    <a href="<c:url value="/pet/new?organizationID=${organization.id}" />">добавить питомца</a>
                    <c:forEach var="pet" items="${petList}">
                        <tr>
                            <td>
                                <div id="pet_<c:out value="pet.id"/>">
                                    id: <c:out value="${pet.id}"/><br/>
                                    name: <c:out value="${pet.name}"/><br/>
                                    animal: <c:out value="${pet.animal}"/><br/>
                                    age: <c:out value="${pet.age}"/><br/>
                                    sex: <c:out value="${pet.sex}"/><br/>
                                    description: <c:out value="${pet.description}"/><br/>
                                    status: <c:out value="${pet.status}"/><br/>
                                    organization: <c:out value="${pet.organization}"/><br/>
                                    <a href="<c:url value="/pet/edit/${pet.id}" />">редактировать</a> |
                                    <a href="<c:url value="/pet/delete/${pet.id}" />">удалить</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </ul>
        </div>
    </tr>
</table>
</body>
</html>

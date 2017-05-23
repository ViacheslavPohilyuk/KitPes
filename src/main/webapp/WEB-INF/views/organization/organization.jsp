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
            <label>Аватар:</label><br/>
            <img alt="profile" width="240" height="200" id="profileImage" src="${organization.profileImgURL}"/>
            <form method="POST" action="/organization/fileupload" enctype="multipart/form-data">
                <input type="file"
                       name="profilePicture"
                       accept="image/jpeg,image/png,image/gif"/><br/>
                <input type="hidden" name="organizationID" value="<c:out value="${organization.id}"/>"/>
                <input type="submit" value="Добавить"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>name:</td>
        <td><c:out value="${organization.name}"/></td>
    </tr>
    <tr>
        <td>address:</td>
        <td><c:out value="${organization.address}"/></td>
    </tr>
    <tr>
        <td>description:</td>
        <td><c:out value="${organization.description}"/></td>
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
                <h3>Питомцы организации</h3>
                <a href="<c:url value="/pet/new?organizationID=${organization.id}&userOrgID=${organization.userID}"/>">
                    добавить питомца
                </a>
                <ul class="petList">
                    <table border="1">
                        <c:forEach var="pet" items="${organization.pets}">
                            <tr>
                                <td>
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
                                                            <td>name:</td>
                                                            <td><c:out value="${pet.name}"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td>animal:</td>
                                                            <td><c:out value="${pet.animal}"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td>age:</td>
                                                            <td><c:out value="${pet.age}"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td>sex:</td>
                                                            <td><c:out value="${pet.sex}"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td>description:</td>
                                                            <td><c:out value="${pet.description}"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td>status:</td>
                                                            <td><c:out value="${pet.status}"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <a href="<c:url value="/pet/${pet.id}?organizationID=${organization.id}&userOrgID=${organization.userID}" />">
                                                                    Перейти в профиль
                                                                </a>
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
        </td>
    </tr>
</table>
</body>
</html>

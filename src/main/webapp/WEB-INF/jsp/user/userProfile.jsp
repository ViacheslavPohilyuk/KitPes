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
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/page.css" />">
    <title>Профиль пользователя</title>
</head>
<body>
<a href="<c:url value="/" />">На главную</a><br/>
<h1>Профиль пользователя <c:out value="${user.username}"/></h1>

<table>
    <tr>
        <td>
            <label>Аватар:</label><br/>
            <img alt="profile" width="200" height="200" id="profileImage" src="${user.profileImgURL}"/>
            <form method="POST" action="/user/fileupload" enctype="multipart/form-data">
                <input type="file"
                       name="profilePicture"
                       accept="image/jpeg,image/png,image/gif"/><br/>
                <input type="hidden" name="username" value="<c:out value="${user.username}"/>"/>
                <input type="submit" value="Добавить"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><c:out value="${user.username}"/><br/></td>
    </tr>
    <tr>
        <td>Имя:</td>
        <td><c:out value="${user.firstName}"/><br/></td>
    </tr>
    <tr>
        <td>Фамилия:</td>
        <td><c:out value="${user.lastName}"/><br/></td>
    </tr>
    <tr>
        <td>Пароль:</td>
        <td><c:out value="${user.password}"/><br/></td>
    </tr>
    <tr>
        <td><a href="<c:url value="/user/edit/${user.id}" />">редактировать</a></td>
    </tr>
    <tr>
        <td>
            <%-- All pets of this user --%>
            <div class="listTitle">
                <h3>Питомцы пользователя</h3>
                <a href="<c:url value="/pet/new?userID=${user.id}" />">добавить питомца</a>
                <ul class="petList">
                    <table border="1">
                        <c:forEach var="pet" items="${user.pets}">
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
                                                            <td>species:</td>
                                                            <td><c:out value="${pet.species}"/></td>
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
                                                                <a href="<c:url value="/pet/${pet.id}?userID=${user.id}" />">
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

            <%-- All organizations of this user --%>
            <div class="listTitle">
                <h3>Организации пользователя</h3>
                <a href="<c:url value="/organization/new?userID=${user.id}" />">добавить организацию</a>
                <ul class="organizationList">
                    <table border="1">
                        <c:forEach var="organization" items="${user.organizations}">
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
        </td>
    </tr>
</table>

</body>
</html>

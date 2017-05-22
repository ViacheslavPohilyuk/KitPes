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
            <c:forEach var="pet" items="${petList}" />

                <tr>
                    <td>
                        <div id="pet_<c:out value="pet.id"/>">
                            name: <c:out value="${pet.name}"/><br/>
                            animal: <c:out value="${pet.animal}"/><br/>
                            age: <c:out value="${pet.age}"/><br/>
                            sex: <c:out value="${pet.sex}"/><br/>
                            description: <c:out value="${pet.description}"/><br/>
                            status: <c:out value="${pet.status}"/><br/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="<c:url value="/pet/${pet.id}" />">Перейти в профиль</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </ul>
</div>
</body>
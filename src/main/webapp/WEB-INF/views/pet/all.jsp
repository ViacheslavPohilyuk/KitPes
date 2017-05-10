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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
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
                        <div id="pet_<c:out value="pet.id"/>">
                            id: <c:out value="${pet.id}"/><br/>
                            name: <c:out value="${pet.name}"/><br/>
                            animal: <c:out value="${pet.animal}"/><br/>
                            age: <c:out value="${pet.age}"/><br/>
                            sex: <c:out value="${pet.sex}"/><br/>
                            description: <c:out value="${pet.description}"/><br/>
                            status: <c:out value="${pet.status}"/><br/>
                            organization: <c:out value="${pet.organization}"/><br/>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </ul>
</div>
</body>
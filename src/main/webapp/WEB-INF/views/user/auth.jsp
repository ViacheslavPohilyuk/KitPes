<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 11.04.17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/page.css" />">
</head>
<body>
<h1>Вход</h1>

<form method="POST">
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="username"/> <br/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="text" name="password"/> <br/></td>
        </tr>
    </table>
    <input type="submit" value="Подтвердить"/>
</form>
</body>
</html>

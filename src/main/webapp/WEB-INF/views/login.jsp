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
<a href="<c:url value="/" />">На главную</a><br/>
<h1>Вход</h1>

<form name="f" action="/login" method="POST">
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="username"/> <br/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password"/> <br/></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Подтвердить"/></td>
        </tr>
    </table>
</form>
</body>
</html>

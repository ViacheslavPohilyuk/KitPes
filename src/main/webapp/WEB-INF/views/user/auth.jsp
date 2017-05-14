<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 11.04.17
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<h1>Вход</h1>

<form method="POST">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email"/><br/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password"/><br/></td>
        </tr>
    </table>
    <input type="submit" value="Вход"/>
</form>
</body>
</html>

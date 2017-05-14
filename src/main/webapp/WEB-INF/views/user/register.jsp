<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04.05.17
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8" />
    <title>Регистрация</title>
</head>
<body>
<h1>Регистрация</h1>
<form method="POST" accept-charset="UTF-8">
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="username" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="firstName" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><input type="text" name="lastName" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><input type="email" name="email" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" content="text/html; charset=utf-8"/><br/></td>
        </tr>
    </table>
    <input type="submit" value="Подтвердить" />
</form>
</body>
</html>


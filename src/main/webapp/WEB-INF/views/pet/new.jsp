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
    <title>Добавить нового питомца</title>
</head>
<body>
<h1>Добавить нового питомца</h1>
<form method="POST" accept-charset="UTF-8">
    <table>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>animal:</td>
            <td><input type="text" name="animal" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>age:</td>
            <td><input type="text" name="age" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>sex:</td>
            <td><input type="text" name="sex" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>description:</td>
            <td><input type="text" name="description" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>status:</td>
            <td><input type="text" name="status" content="text/html; charset=utf-8"/><br/></td>
        </tr>
        <tr>
            <td>organization:</td>
            <td><input type="text" name="organization" content="text/html; charset=utf-8"/><br/></td>
        </tr>
    </table>
    <input type="submit" value="Создать" />
</form>
</body>
</html>


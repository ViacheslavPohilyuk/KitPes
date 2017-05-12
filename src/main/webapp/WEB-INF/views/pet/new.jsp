<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 04.05.17
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>Добавить нового питомца</title>
</head>
<body>
<h1>Добавить нового питомца</h1>
<form method="POST">
    <table>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name"/><br/></td>
        </tr>
        <tr>
            <td>animal:</td>
            <td><input type="text" name="animal"/><br/></td>
        </tr>
        <tr>
            <td>age:</td>
            <td><input type="text" name="age"/><br/></td>
        </tr>
        <tr>
            <td>sex:</td>
            <td><input type="text" name="sex"/><br/></td>
        </tr>
        <tr>
            <td>description:</td>
            <td><input type="text" name="description"/><br/></td>
        </tr>
        <tr>
            <td>status:</td>
            <td><input type="text" name="status"/><br/></td>
        </tr>
        <tr>
            <td>organization:</td>
            <td><input type="text" name="organization"/><br/></td>
        </tr>
    </table>
    <input type="submit" value="Создать"/>
</form>
</body>
</html>


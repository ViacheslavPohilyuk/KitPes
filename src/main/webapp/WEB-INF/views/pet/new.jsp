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
    <title>Добавить нового питомца</title>
</head>
<body>
<h1>Добавить нового питомца</h1>
<form method="POST">
    id: <input type="text"name="id"/><br/>
    name: <input type="text" name="name"/><br/>
    animal: <input type="text" name="animal"/><br/>
    age: <input type="text" name="age"/><br/>
    sex: <input type="text" name="sex"/><br/>
    description: <input type="text" name="description"/><br/>
    status: <input type="text" name="status"/><br/>
    organization: <input type="text" name="organization"/><br/>
    <input type="submit" value="Создать"/>
</form>
</body>
</html>


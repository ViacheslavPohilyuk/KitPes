<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 11.04.17
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KitPes</title>
</head>
<body>
    <h1>Welcome to KitPes</h1>

    <a href="<c:url value="/user/auth" />">Вход</a> |
    <a href="<c:url value="/user/register" />">Регистрация</a>
</body>
</html>
]
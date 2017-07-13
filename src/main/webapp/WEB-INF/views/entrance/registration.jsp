<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 13.07.17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/style.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/login_and_register/style.css" />">
    <script src="<c:url value="https://use.fontawesome.com/a81cbcd056.js" />"></script>
</head>
<body>
<div class="l__menu-background"></div>
<header class="l-header">
    <nav class="c-navigation">
        <div class="l-menu">
            <div class="c-navigation__menu-button"></div>
            <a href="/">
                <div class="c-navigation__logo"></div>
            </a>
            <div class="c-navigation__menu">
                <div class="l-menu-items">
                    <div class="c-navigation__menu-item c-navigation__menu-item--caption">Нашли питомца?</div>
                    <a href="/foundLostPet/found/create" class="c-navigation__menu-item">зарегистрировать
                        найденного питомца</a>
                    <a href="/foundLostPet/lost" class="c-navigation__menu-item">база потерянных питомцев</a>
                    <div class="c-navigation__menu-item c-navigation__menu-item--caption">Потеряли питомца?</div>
                    <a href="/foundLostPet/lost/create" class="c-navigation__menu-item">зарегистрировать потерянного
                        питомца</a>
                    <a href="/foundLostPet/found" class="c-navigation__menu-item">база найденных питомцев</a>
                    <a href="#" class="c-navigation__menu-item">ветклиники</a>
                    <a href="#" class="c-navigation__menu-item">приюты</a>
                    <a href="#" class="c-navigation__menu-item">новости</a>
                    <a href="#" class="c-navigation__menu-item">ивенты</a>
                    <a href="#" class="c-navigation__menu-item">вопрос/ответ</a>
                    <a href="#" class="c-navigation__menu-item">контакты</a>
                    <a href="/login"
                       class="c-navigation__menu-item c-navigation__menu-item--login">вход</a>
                </div>
            </div>
        </div>
        <div class="l-menu-container">
            <a href="#" class="c-navigation__link">ПРИЮТИТЬ/ПРИСТРОИТЬ</a>
            <a href="#" class="c-navigation__link">ПОТЕРЯННЫЕ/НАЙДЕННЫЕ</a>
            <a href="/login" class="c-navigation__link">ВХОД</a>
        </div>
    </nav>
</header>

<main class="l-main">
    <div class="l-form-container">
        <form action="/register" method="POST" class="c-registration-form">
            <input name="username" type="text" placeholder="@email" class="c-registration-form__input">
            <input name="firstName" type="text" placeholder="Имя" class="c-registration-form__input">
            <input name="lastName" type="text" placeholder="Фамилия" class="c-registration-form__input">
            <input name="password" type="password" placeholder="Пароль" class="c-registration-form__input">
            <input name="second_password" type="password" placeholder="Еще раз" class="c-registration-form__input">

            <div class="c-registration-form__enter-field">
                <button class="c-registration-form__register">РЕГИСТРАЦИЯ</button>
            </div>
            <div class="l-registration-form__socials-container">
                <div class="c-registration-form__socials-links">
                    <i class="fa fa-instagram" aria-hidden="true"></i>
                    <i class="fa fa-facebook-official" aria-hidden="true"></i></div>
                <div class="c-registration-form__socials-caption">Зарегистрироваться через социальные сети</div>
            </div>
        </form>
    </div>
</main>

<script type="text/javascript">
    <%@include file="/resources/assets/script.js"%>
</script>
</body>
</html>
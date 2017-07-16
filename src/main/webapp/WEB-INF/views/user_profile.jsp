<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 14.07.17
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Kitpes - registration lose</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/registration_found/styles/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/found/styles/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/userprofile/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/userprofile/main_profile.css"/>">
</head>
<body class="c-body">
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
    <div class="l__menu-background"></div>
</header>
<div class="l-main">
    <div class="c-main-title">личный кабинет</div>
    <div class="c-profile">
        <div class="c-profile__left-column">
            <div class="c-profile__user-photo"></div>
            <div class="c-profile__user-navigation">
                <div class="c-profile__user-navigation-item">потерянные питомцы</div>
                <div class="c-profile__user-navigation-item">найденные питомцы</div>
            </div>
        </div>
        <div class="c-profile__right-column">
            <a href="/foundLostPet/found/create" class="c-form__button" style="top:4%;width:45%;left:2%">Добавить
                найденного питомца</a>
            <a href="/foundLostPet/lost/create" class="c-form__button" style="top:10%;width:45%;left:2%">Добавить
                потерянного питомца</a>
        </div>
    </div>
    <footer class="c-footer">
        <div class="c-footer__info"><span>меню</span><span class="c-footer__author">design by </span><span>benmax</span>
        </div>
        <div class="c-footer__socials">
            <i class="fa fa-instagram" aria-hidden="true"></i> <i class="fa fa-facebook-official"
                                                                  aria-hidden="true"></i>
        </div>
    </footer>

    <script type="text/javascript">
        <%@include file="/resources/assets/script.js"%>
        <%@include file="/resources/found/js/js.js"%>
    </script>

</body>

</html>

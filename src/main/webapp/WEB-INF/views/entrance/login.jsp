<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 13.07.17
  Time: 14:12
  To change this template use File | Settings | File Templates.

  <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <font color="red">
                Your login attempt was not successful due to <br/><br/>
                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
            </font>
        </c:if>
        <form name="f"
              action="<c:url value='/auth/login_check'/>"
              method="POST" class="c-registration-form">

              <input name="username" type="text" placeholder="Телефон либо @mail" class="c-registration-form__input">
            <input name="password" type="password" placeholder="Пароль" class="c-registration-form__input">
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Authorization</title>
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
        <form name="f"
              action="<c:url value='/auth/login_check'/>"
              method="POST" class="c-registration-form">

            <input name="username" type="text" placeholder="Телефон либо @mail" class="c-registration-form__input">
            <input name="password" type="password" placeholder="Пароль" class="c-registration-form__input">

            <div class="c-registration-form__restore">
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                    <font color="red">
                        Не правильный логин или пароль, попробуйте еще раз<br/><br/>
                        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                   <!-- <span class="c-registration-form__notfound" name="notefound">Не правильный логин или пароль, попробуйте еще раз</span> -->
                    </font>
                </c:if>
                <span class="c-registration-form__restore-caption">Забыли пароль?</span>
                <a href="#" class="c-registration-form__restore-link">Восстановить</a>
            </div>
            <div class="c-registration-form__enter-field">
                <button class="c-registration-form__enter">ВХОД</button>
                <a href="/register" class="c-registration-form__register">РЕГИСТРАЦИЯ</a>
            </div>
            <div class="l-registration-form__socials-container">
                <div class="c-registration-form__socials-links">
                    <i class="fa fa-instagram" aria-hidden="true"></i>
                    <i class="fa fa-facebook-official" aria-hidden="true"></i></div>
                <div class="c-registration-form__socials-caption">Войти через социальные сети</div>
            </div>
        </form>
    </div>
</main>

<script type="text/javascript">
    <%@include file="/resources/assets/script.js"%>
</script>

</body>
</html>
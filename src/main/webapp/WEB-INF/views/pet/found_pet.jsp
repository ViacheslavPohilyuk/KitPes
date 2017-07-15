<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kitpes - base of pets found</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/found/styles/main.css"/>">
</head>
<body class="c-body">
<div class="l-main">
    <header class="l-header">
        <nav class="c-navigation">
            <div class="l-menu">
                <div class="c-navigation__menu-button"></div>
                <a href="../user_profile.html">
                    <div class="c-navigation__logo"></div>
                </a>
                <div class="c-navigation__menu">
                    <div class="l-menu-items">
                        <div class="c-navigation__menu-item c-navigation__menu-item--caption">Нашли питомца?</div>
                        <a href="../registration-found/index.html" class="c-navigation__menu-item">зарегистрировать
                            найденного питомца</a>
                        <a href="../lost/index.html" class="c-navigation__menu-item">база потерянных питомцев</a>
                        <div class="c-navigation__menu-item c-navigation__menu-item--caption">Потеряли питомца?</div>
                        <a href="../registration/index.html" class="c-navigation__menu-item">зарегистрировать
                            потерянного питомца</a>
                        <a href="../found/index.html" class="c-navigation__menu-item">база найденных питомцев</a>
                        <a href="#" class="c-navigation__menu-item">ветклиники</a>
                        <a href="#" class="c-navigation__menu-item">приюты</a>
                        <a href="#" class="c-navigation__menu-item">новости</a>
                        <a href="#" class="c-navigation__menu-item">ивенты</a>
                        <a href="#" class="c-navigation__menu-item">вопрос/ответ</a>
                        <a href="#" class="c-navigation__menu-item">контакты</a>
                        <a href="../authorization/index.html"
                           class="c-navigation__menu-item c-navigation__menu-item--login">вход</a>
                    </div>
                </div>
            </div>
            <div class="l-menu-container">
                <a href="#" class="c-navigation__link">ПРИЮТИТЬ/ПРИСТРОИТЬ</a>
                <a href="#" class="c-navigation__link">ПОТЕРЯННЫЕ/НАЙДЕННЫЕ</a>
                <a href="../authorization/index.html" class="c-navigation__link">ВХОД</a>
            </div>
        </nav>
        <div class="l__menu-background"></div>
    </header>
    <h2 class="c-head">База найденных питомцев</h2>
    <div class="c-filter__background"></div>
    <div class="l-layot" align="center">
        <div class="c-filter">
            <div class="l-filter__head">
                <h3 class="c-filter__head">Фильтровать результаты</h3>
            </div>
            <div class="c-filter__item-block">
                <div class="l-grid">
                    <div class="c-filter__item-style  is-large">
                        <select class="c-filter__item" name="kind">
                            <option>вид</option>
                            <option>собака</option>
                            <option>кошка</option>
                            <option>хомяк</option>
                            <option>морская свинка</option>
                        </select>
                    </div>
                    <div class="c-filter__item-style is-large">
                        <select class="c-filter__item" name="sex">
                            <option>пол</option>
                            <option>мальчик</option>
                            <option>девочка</option>
                        </select>
                    </div>
                    <div class="c-filter__item-style is-large">
                        <select class="c-filter__item" name="age">
                            <option>возраст</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                        </select>
                    </div>
                    <div class="c-filter__item-style is-large">
                        <select class="c-filter__item" name="form">
                            <option>состояние</option>
                            <option>здоровый</option>
                            <option>болеет</option>
                        </select>
                    </div>
                    <div class="c-filter__item-style is-large">
                        <select class="c-filter__item" name="sterilization">
                            <option>стерилизован</option>
                            <option>не стерилизован</option>
                        </select>
                    </div>
                    <div class="c-filter__item-style is-large">
                        <select class="c-filter__item" name="graft">
                            <option>привит</option>
                            <option>не привит</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="l-layot">
        <div class="c-find" id="app">

        </div>
    </div>
    <div class="l-layot">
        <div class="c-find__show-all">
            <div class="l-grid">
                <h4 class="c-find__show-all-head">показать всех найденных питомцев</h4>
                <img class="c-find__down" src="/resources/found/src/images/down.svg">
            </div>
        </div>
    </div>

</div>
<footer class="c-footer">
    <div class="c-footer__info"><span>меню</span><span class="c-footer__author">design by </span><span>benmax</span>
    </div>
    <div class="c-footer__socials">
        <i class="fa fa-instagram" aria-hidden="true"></i> <i class="fa fa-facebook-official" aria-hidden="true"></i>
    </div>
</footer>

<script type="text/javascript">
    <%@include file="/resources/assets/script.js"%>
    <%@include file="/resources/found/js/js.js"%>
</script>

</body>
</html>

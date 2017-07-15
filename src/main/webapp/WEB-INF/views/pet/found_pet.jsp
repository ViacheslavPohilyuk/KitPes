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
            <!--<div class="l-row">-->
            <!--<div class="c-find__item col-1-4" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets1.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item col-1-4" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets2.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item col-1-4" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets3.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item col-1-4" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets4.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="l-row">-->
            <!--<div class="c-find__item col-1-4" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets5.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user" href="#">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item col-1-4" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets6.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item col-1-4" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets7.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item col-1-4" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets8.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Люси</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more" onclick="show('block')">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->
        </div>
        <div class="l-row">
            <!--<div class="c-find__item is-hidden" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets1.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item is-hidden" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets2.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item is-hidden" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets3.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item is-hidden" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets4.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="l-row">-->
            <!--<div class="c-find__item is-hidden" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets5.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user" href="#">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item is-hidden" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets6.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item is-hidden" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets7.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--<div class="c-find__item is-hidden" name="pets">-->
            <!--<img class="c-find__image" src="./images/pets8.jpg">-->
            <!--<div class="c-find__info">-->
            <!--<h4 class="c-find__name">Гоша</h4>-->
            <!--<hr class="c-find__line">-->
            <!--<img class="c-find__date-image" src="./images/date.svg">-->
            <!--<span class="c-find__date">15.10.2017</span>-->
            <!--<img class="c-find__user-image" src="./images/user.svg">-->
            <!--<span class="c-find__user">Максимов Вениамин</span>-->
            <!--</div>-->
            <!--<div class="c-find__learn-more">-->
            <!--<img class="c-find__plus" src="./images/plus.png">-->
            <!--<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>-->
            <!--</div>-->
            <!--</div>-->
            <!--</div>-->
        </div>
        <div class="l-layot" id="more">
            <div class="c-find__show-all">
                <div class="l-grid">
                    <h4 class="c-find__show-all-head">показать всех найденных питомцев</h4>
                    <img class="c-find__down" src="./images/down.svg">
                </div>
            </div>
        </div>
        <div onclick="show("none")" class="l-wrap"></div>
    <!--<div class="l-show-pets" onclick="show("block")">-->
    <!--<div class="c-show-pets">-->
    <!--<div class="c-show-pets__name" name="name">Люси</div>-->
    <!--<button class="c-show-pets__close" onclick="show('none')"></button>-->
    <!--<div class="c-show-pets__main">-->
    <!--<div class="c-show-pets__photo col-1-4">-->
    <!--<img class="c-show-pets__main-photo" src="./images/pets8.jpg"><br>-->
    <!--<span class="c-show-pets__search">-->
    <!--<img class="c-show-pets__view" src="./images/view.png">-->
    <!--<span class="c-show-pets__show-all-photo">просмотреть все фото</span>-->
    <!--</span><br>-->
    <!--<div class="l-flex">-->
    <!--<img class="c-show-pets__small-photo" src="./images/pets8.jpg">-->
    <!--<img class="c-show-pets__small-photo" src="./images/pets9.jpg">-->
    <!--<img class="c-show-pets__small-photo" src="./images/pets10.jpg">-->
    <!--<img class="c-show-pets__small-photo" src="./images/pets11.jpg">-->
    <!--</div>-->
    <!--</div>-->
    <!--<div class="c-show-pets__info col-3-4">-->
    <!--<span class="c-show-pets__type" name="kind">кошка</span>/-->
    <!--<span class="c-show-pets__type" name="sex">девочка</span>/-->
    <!--<span class="c-show-pets__type" name="breed">тонкинская кошка</span><br>-->
    <!--<span class="c-show-pets__type" name="age">2 года</span>/-->
    <!--<span class="c-show-pets__type" name="color">белая</span>/-->
    <!--<span class="c-show-pets__type" name="form">здорова</span><br>-->
    <!--<span class="c-show-pets__type" name="graft">привита</span>/-->
    <!--<span class="c-show-pets__type" name="sterilization">не стерилизована</span>-->
    <!--<div class="c-show-pets__date">-->
    <!--<span class="c-show-pets__find-date" name="find-date">13.13.2017</span>-->
    <!--(дата, когда был найден питомец)</div>-->
    <!--<div class="c-show-pets__description">Тонкинская кошка - гибрид сиамской и бирманской кошки американского-->
    <!--типа. Внешне тонкинская кошка - нечто среднее между её предками: очертания более округлы, чем у сиамской,-->
    <!--вес и ширина меньше чем у бирманской.-->
    <!--</div>-->
    <!--</div>-->
    <!--</div>-->
    <!--<div class="c-show-pets__contacts col-2-3">-->
    <!--<span class="c-show-pets__contacts-head">Контакты человека, нашедего питомца</span><br>-->
    <!--<img class="c-show-pets__user-image" src="./images/user.svg">-->
    <!--<span class="c-show-pets__finder" name="finder">Максим Вениаминов</span>-->
    <!--<a class="c-show-pets__socials" href="#" name="instagram">-->
    <!--<img class="c-show-pets__socials-img" src="./images/instagram.png">-->
    <!--</a>-->
    <!--<a class="c-show-pets__socials" href="#" name="facebook">-->
    <!--<img class="c-show-pets__socials-img" src="./images/facebook.png">-->
    <!--</a>-->
    <!--<a class="c-show-pets__socials" href="#" name="twitter">-->
    <!--<img class="c-show-pets__socials-img" src="./images/twitter.png">-->
    <!--</a>-->
    <!--<a class="c-show-pets__socials" href="#" name="google+">-->
    <!--<img class="c-show-pets__socials-img" src="./images/google.png">-->
    <!--</a>-->
    <!--<button class="c-show-pets__massage" name="newmassage">-->
    <!--<img class="c-show-pets__massage-img" src="./images/massage.png">отправить сообщение-->
    <!--</button>-->
    <!--<hr class="c-show-pets__line">-->
    <!--<div class="c-show-pets__contact-item">-->
    <!--<img class="c-show-pets__contact-img" src="./images/phone.png">-->
    <!--<span class="c-show-pets__contact">телефон</span><br>-->
    <!--<span class="c-show-pets__telephon" name="telephone">+38 063 99 51 611</span>-->
    <!--</div>-->
    <!--<div class="c-show-pets__contact-item">-->
    <!--<img class="c-show-pets__contact-img" src="./images/mail.png">-->
    <!--<span class="c-show-pets__contact">почта</span><br>-->
    <!--<span class="c-show-pets__email" name="email">benmax@gmai1.com</span>-->
    <!--</div>-->
    <!--<div class="c-show-pets__contact-item">-->
    <!--<img class="c-show-pets__contact-img" src="./images/marker.png">-->
    <!--<span class="c-show-pets__contact">адрес:</span><br>-->
    <!--<span class="c-show-pets__address" name="address">ул. Парус 2</span>-->
    <!--</div>-->
    <!--</div>-->
    <!--<button class="c-show-pets__button">приютить!</button>-->
    <!--</div>-->
    <!--</div>-->
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
    <%@include file="/resources/found/js/feed.js"%>
</script>

</body>
</html>

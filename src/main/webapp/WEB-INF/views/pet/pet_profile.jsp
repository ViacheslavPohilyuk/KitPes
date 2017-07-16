<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 16.07.17
  Time: 06:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Профиль питомца</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/pet/main.css"/>">
</head>
<body>
<div class="c-modal">
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
                            <div class="c-navigation__menu-item c-navigation__menu-item--caption">Потеряли питомца?
                            </div>
                            <a href="/foundLostPet/lost/create" class="c-navigation__menu-item">зарегистрировать
                                потерянного
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

        <div class="l-show-pets">
            <div class="c-show-pets">

                <div class="c-show-pets__main">

                    <div class="c-show-pets__photo col-1-4">
                        <img class="c-show-pets__main-photo" src="${pet.profileImgURL}"><br>
                        <span class="c-show-pets__search"></span>
                    </div>

                    <div class="c-show-pets__name" name="name">${pet.name}</div>
                    <button class="c-show-pets__close" @click.prevent="getDetails"></button>

                    <div class="c-show-pets__info col-3-4">
                        <span class="c-show-pets__type" name="kind">кошка</span>/
                        <span class="c-show-pets__type" name="sex">девочка</span>/
                        <span class="c-show-pets__type" name="breed">тонкинская кошка</span><br>
                        <span class="c-show-pets__type" name="age">${pet.age} года</span>/
                        <span class="c-show-pets__type" name="color">белая</span>/
                        <span class="c-show-pets__type" name="form">здорова</span><br>
                        <span class="c-show-pets__type" name="graft">привита</span>/
                        <span class="c-show-pets__type" name="sterilization">не стерилизована</span>
                        <div class="c-show-pets__date">
                            <span class="c-show-pets__find-date" name="find-date">13.13.2017</span>
                            (дата, когда был найден питомец)
                        </div>
                        <div class="c-show-pets__description">${pet.description}
                        </div>
                    </div>

                    <div class="c-show-pets__contacts col-2-3">
                        <span class="c-show-pets__contacts-head">Контакты человека, нашедего питомца</span><br>
                        <img class="c-show-pets__user-image" src="/resources/found/images/user.svg">
                        <span class="c-show-pets__finder" name="finder">Максим Вениаминов</span>
                        <a class="c-show-pets__socials" href="#" name="instagram">
                            <img class="c-show-pets__socials-img" src="/resources/found/images/instagram.png">
                        </a>
                        <a class="c-show-pets__socials" href="#" name="facebook">
                            <img class="c-show-pets__socials-img" src="/resources/found/images/facebook.png">
                        </a>
                        <a class="c-show-pets__socials" href="#" name="twitter">
                            <img class="c-show-pets__socials-img" src="/resources/found/images/twitter.png">
                        </a>
                        <a class="c-show-pets__socials" href="#" name="google+">
                            <img class="c-show-pets__socials-img" src="/resources/found/images/google.png">
                        </a>
                        <button class="c-show-pets__massage" name="newmassage">
                            <img class="c-show-pets__massage-img" src="/resources/found/images/massage.png">отправить
                            сообщение
                        </button>
                        <hr class="c-show-pets__line">
                        <div class="c-show-pets__contact-item">
                            <img class="c-show-pets__contact-img" src="/resources/found/images/phone.png">
                            <span class="c-show-pets__contact">телефон</span><br>
                            <span class="c-show-pets__telephon" name="telephone">+38 063 99 51 611</span>
                        </div>
                        <div class="c-show-pets__contact-item">
                            <img class="c-show-pets__contact-img" src="/resources/found/images/mail.png">
                            <span class="c-show-pets__contact">почта</span><br>
                            <span class="c-show-pets__email" name="email">benmax@gmai1.com</span>
                        </div>
                        <div class="c-show-pets__contact-item">
                            <img class="c-show-pets__contact-img" src="/resources/found/images/marker.png">
                            <span class="c-show-pets__contact">адрес:</span><br>
                            <span class="c-show-pets__address" name="address">ул. Парус 2</span>
                        </div>
                    </div>
                    <button class="c-show-pets__button">приютить!</button>
                </div>
            </div>
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
</div>
<script type="text/javascript">
    <%@include file="/resources/assets/script.js"%>
    <%@include file="/resources/found/js/js.js"%>
</script>
</body>
</html>

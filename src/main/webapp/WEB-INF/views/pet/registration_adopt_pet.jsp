<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 15.07.17
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Kitpes - registration found</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/registration_found/styles/main.css"/>">
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

    <h2 class="c-head">регистрация найденного питомца</h2>
    <div class="l-wrap">
        <div class="c-form">
            <div class="c-form__block">
                <div class="c-form__photo-block">
                    <label for="file1">
                        <div class="c-form__main-photo" name="main-photo">
                            <span class="c-form__photo-text">загрузить <br>фото питомца</span>
                            <img class="c-form__photo-icon" src="/resources/registration_found/images/upload.svg">
                        </div>
                    </label>
                </div>

                <form action="/pet/new" method="POST" class="c-form__item-block" enctype="multipart/form-data">
                    <!-- Загрузка изображения -->
                    <input name="profilePicture" type="file" id="file1" style="display:none"
                           accept="image/jpeg,image/png,image/gif"/>

                    <div class="l-grid">
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="species">
                                <option value="${null}">вид</option>
                                <option value="cat">собака</option>
                                <option value="dog">кошка</option>
                            </select>
                        </div>
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="sex">
                                <option value="${null}">пол</option>
                                <option value="male">мальчик</option>
                                <option value="female">девочка</option>
                            </select>
                        </div>
                    </div>
                    <div class="l-grid">
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="age">
                                <option value="${null}">возраст</option>
                                <option value="0">меньше года</option>
                                <option value="1">от 1-2 года</option>
                                <option value="2">от 2-3 года</option>
                                <option value="3">от 3-4 года</option>
                                <option value="4">от 4-5 лет</option>
                                <option value="5">больше 5 лет</option>
                            </select>
                        </div>
                        <div class="c-form__item-style is-large">
                            <select class="c-form__item" name="status">
                                <option value="${null}">состояние</option>
                                <option value="0">здоровый</option>
                                <option value="1">в тяжелом состоянии</option>
                                <option value="2">требует специального ухода</option>
                            </select>
                        </div>
                    </div>
                    <div class="l-grid">
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="vaccinated">
                                <option value="true">привит</option>
                                <option value="false">не привит</option>
                            </select>
                        </div>
                        <div class="c-form__item-style is-medium">
                            <select class="c-form__item" name="sterilization">
                                <option value="true">стерилизован</option>
                                <option value="false">не стерилизован</option>
                            </select>
                        </div>
                        <div class="l-date">
                            <div class="c-form__item-style is-smaller">
                                <select class="c-form__item" name="day">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                </select>
                            </div>
                            <div class="c-form__item-style is-smaller">
                                <select class="c-form__item" name="month">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </div>
                            <div class="c-form__item-style is-smaller">
                                <select class="c-form__item" name="year">
                                    <option value="2017">2017</option>
                                    <option value="2016">2016</option>
                                    <option value="2015">2015</option>
                                    <option value="2014">2014</option>
                                    <option value="2013">2013</option>
                                    <option value="2012">2012</option>
                                    <option value="2011">2011</option>
                                    <option value="2010">2010</option>
                                    <option value="2009">2009</option>
                                    <option value="2008">2008</option>
                                    <option value="2007">2007</option>
                                    <option value="2006">2006</option>
                                </select>
                            </div>
                            <div class="c-form__text">дата находки питомца</div>
                        </div>
                    </div>
                    <div class="l-grid">
                        <textarea class="c-form__description" type="text" placeholder="краткое описание"
                                  name="description"></textarea>
                        <br/>
                    </div>
                    <button class="c-form__button">зарегистрировать <br/> найденного питомца</button>
                </form>
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
    <%@include file="/resources/registration_found/js/js.js"%>
</script>
</body>

</html>

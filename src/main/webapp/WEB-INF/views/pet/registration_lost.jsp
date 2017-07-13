<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 12.07.17
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Kitpes - registration lose</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/registration_lost/styles/main.css"/>">
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

    <h2 class="c-head">регистрация потерянного питомца</h2>
    <div class="l-wrap">
        <div class="c-form">
            <div class="c-form__block">
                <div class="c-form__photo-block">
                    <input type="file" id="file1" style="display:none">
                    <label for="file1">
                        <div class="c-form__main-photo" name="main-photo">
                            <span class="c-form__photo-text">загрузить <br>фото питомца</span>
                            <img class="c-form__photo-icon" src="/resources/registration_lost/images/upload.svg">
                        </div>
                    </label>
                    <span class="c-form__get-photo-text">загрузить ещё 4 фото</span>
                    <div class="l-wrap">
                        <input type="file" id="file2" style="display:none">
                        <label for="file2">
                            <div class="c-form__photo-upload"><img class="c-form__uploud-icon" src="/resources/registration_lost/images/upload.svg"></div>
                        </label>
                        <input type="file" id="file3" style="display:none">
                        <label for="file3">
                            <div class="c-form__photo-upload"><img class="c-form__uploud-icon" src="/resources/registration_lost/images/upload.svg"></div>
                        </label>
                        <input type="file" id="file4" style="display:none">
                        <label for="file4">
                            <div class="c-form__photo-upload"><img class="c-form__uploud-icon" src="/resources/registration_lost/images/upload.svg"></div>
                        </label>
                        <input type="file" id="file5" style="display:none">
                        <label for="file5">
                            <div class="c-form__photo-upload"><img class="c-form__uploud-icon" src="/resources/registration_lost/images/upload.svg"></div>
                        </label>
                    </div>
                </div>
                <form class="c-form__item-block">
                    <div class="l-grid">
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="kind">
                                <option>вид</option>
                                <option>собака</option>
                                <option>кошка</option>
                                <option>хомяк</option>
                                <option>морская свинка</option>
                            </select>
                        </div>
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="sex">
                                <option>пол</option>
                                <option>мальчик</option>
                                <option>девочка</option>
                            </select>
                        </div>
                        <div class="c-form__item-style is-large">
                            <select class="c-form__item" name="breed">
                                <option>порода</option>
                                <option>овчарка</option>
                                <option>хаски</option>
                                <option>лайка</option>
                            </select>
                        </div>
                    </div>
                    <div class="l-grid">
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="age">
                                <option>возраст</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                            </select>
                        </div>
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="сolor">
                                <option>окрас</option>
                                <option>серый</option>
                                <option>белый</option>
                                <option>рыжий</option>
                                <option>черепаховый</option>
                                <option>голубой</option>
                                <option>коричневый</option>
                            </select>
                        </div>
                        <div class="c-form__item-style is-large">
                            <select class="c-form__item" name="form">
                                <option>состояние</option>
                                <option>здоровый</option>
                                <option>болеет</option>
                            </select>
                        </div>
                    </div>
                    <div class="l-grid">
                        <div class="c-form__item-style is-small">
                            <select class="c-form__item" name="graft">
                                <option>привит</option>
                                <option>не привит</option>
                            </select>
                        </div>
                        <div class="c-form__item-style is-medium">
                            <select class="c-form__item" name="sterilization">
                                <option>стерилизован</option>
                                <option>не стерилизован</option>
                            </select>
                        </div>
                        <div class="l-date">
                            <div class="c-form__item-style is-smaller">
                                <select class="c-form__item" name="day">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                    <option>11</option>
                                    <option>12</option>
                                    <option>13</option>
                                    <option>14</option>
                                    <option>15</option>
                                    <option>16</option>
                                    <option>17</option>
                                    <option>18</option>
                                    <option>19</option>
                                    <option>20</option>
                                    <option>21</option>
                                    <option>22</option>
                                    <option>23</option>
                                    <option>24</option>
                                    <option>25</option>
                                    <option>26</option>
                                    <option>27</option>
                                    <option>28</option>
                                    <option>29</option>
                                    <option>30</option>
                                    <option>31</option>
                                </select>
                            </div>
                            <div class="c-form__item-style is-smaller">
                                <select class="c-form__item" name="month">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                    <option>11</option>
                                    <option>12</option>
                                </select>
                            </div>
                            <div class="c-form__item-style is-smaller">
                                <select class="c-form__item" name="year">
                                    <option>2017</option>
                                    <option>2016</option>
                                    <option>2015</option>
                                    <option>2014</option>
                                    <option>2013</option>
                                    <option>2012</option>
                                    <option>2011</option>
                                    <option>2010</option>
                                    <option>2009</option>
                                    <option>2008</option>
                                    <option>2007</option>
                                    <option>2006</option>
                                </select>
                            </div>
                            <div class="c-form__text">дата потери питомца</div>
                        </div>
                    </div>
                    <div class="l-grid">
                        <textarea class="c-form__description" type="text" placeholder="краткое описание" name="description"></textarea>
                        <br/>
                        <input class="c-form__owner" type="checkbox" name="owner" id="checkbox">
                        <label for="checkbox"></label>
                        <span class="c-form__ovner-text">я хозяин потеряного питомца</span><br/>
                        <img class="c-form__user-img" src="/resources/registration_lost/images/user.svg">
                        <span class="c-form__user" name="user">Максимов Вениамин</span>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <button class="c-form__button">зарегистрировать <br/> найденного питомца</button>
</div>
<footer class="c-footer">
    <div class="c-footer__info"><span>меню</span><span class="c-footer__author">design by </span><span>benmax</span></div>
    <div class="c-footer__socials">
        <i class="fa fa-instagram" aria-hidden="true"></i> <i class="fa fa-facebook-official" aria-hidden="true"></i>
    </div>
</footer>

<script type="text/javascript">
    <%@include file="/resources/assets/script.js"%>
    <%@include file="/resources/registration_lost/js/js.js"%>
</script>
</body>

</html>

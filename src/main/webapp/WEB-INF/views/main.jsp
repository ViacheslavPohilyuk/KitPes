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
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/main/assets/style.css" />">
    <title>Document</title>
    <script src="<c:url value="https://use.fontawesome.com/a81cbcd056.js" />"></script>
</head>

<body>
<header class="l-header">
    <nav class="c-navigation">
        <div class="l-menu">
            <div class="c-navigation__menu-button"></div>
            <div class="c-navigation__logo"></div>
            <div class="c-navigation__menu">
                <div class="l-menu-items">
                    <div class="c-navigation__menu-item c-navigation__menu-item--caption">Нашли питомца?</div>
                    <a href="#" class="c-navigation__menu-item">зарегистрировать найденного питомца</a>
                    <a href="#" class="c-navigation__menu-item">база потерянных питомцев</a>
                    <div class="c-navigation__menu-item c-navigation__menu-item--caption">Потеряли питомца?</div>
                    <a href="#" class="c-navigation__menu-item">зарегистрировать потерянного питомца</a>
                    <a href="#" class="c-navigation__menu-item">база найденных питомцев</a>
                    <a href="#" class="c-navigation__menu-item">ветклиники</a>
                    <a href="#" class="c-navigation__menu-item">приюты</a>
                    <a href="#" class="c-navigation__menu-item">новости</a>
                    <a href="#" class="c-navigation__menu-item">ивенты</a>
                    <a href="#" class="c-navigation__menu-item">вопрос/ответ</a>
                    <a href="#" class="c-navigation__menu-item">контакты</a>
                    <a href="#" class="c-navigation__menu-item c-navigation__menu-item--login">вход</a>
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
    <div class="c-slider" id="app">
        <div class="c-slider__canvas">
            <div class="c-slider__slide">
                <div class="c-slider__quote">мы в ответе за тех, <br/> кого приручили</div>
                <div class="c-slider__quote-author">антуан де сент-экзюпери</div>
            </div>
            <div class="c-slider__slide">
                <div class="c-slider__quote">мы в ответе за тех, <br/> кого приручили</div>
                <div class="c-slider__quote-author">антуан де сент-экзюпери</div>
            </div>
            <div class="c-slider__slide">
                <div class="c-slider__quote">мы в ответе за тех, <br/> кого приручили</div>
                <div class="c-slider__quote-author">антуан де сент-экзюпери</div>
            </div>
            <div class="c-slider__slide">
                <div class="c-slider__quote">мы в ответе за тех, <br/> кого приручили</div>
                <div class="c-slider__quote-author">антуан де сент-экзюпери</div>
            </div>
            <div class="c-slider__slide">
                <div class="c-slider__quote">мы в ответе за тех, <br/> кого приручили</div>
                <div class="c-slider__quote-author">антуан де сент-экзюпери</div>
            </div>
            <div class="c-slider__slide">
                <div class="c-slider__quote">мы в ответе за тех, <br/> кого приручили</div>
                <div class="c-slider__quote-author">антуан де сент-экзюпери</div>
            </div>
        </div>
    </div>
</header>

<main class="l-main">
    <section class="c-intro">
        <h1 class="c-main-title">больше о проекте</h1>
        <p class="c-intro__p">Это онлайн-сервис для адопции (пристройства) и помощи бездомным животным. Это значит, что
            если хотите завести домашнего питомца — поищите его на сайте. Найдите на KitPes бесплатно, если не
            получиться — купить можно успеть всегда.</p>
    </section>
    <section class="c-description">
        <h1 class="c-main-title c-main-title--description">как это работает?</h1>
        <div class="c-description__infographics"></div>
        <div class="l-description__infographics-caption">
            <div class="c-description__infographics-caption">я нашел питомца</div>
            <div class="c-description__infographics-caption">я нашел питомца захожу на сайт kitpes.dp.ua</div>
            <div class="c-description__infographics-caption">я создаю карточку для найденного мной животного</div>
            <div class="c-description__infographics-caption">бездомный питомец становится домашним любимцем</div>
        </div>
        <div class="l-line">
            <div class="l-line__left-half"></div>
            <div class="l-line__right-half"></div>
        </div>
    </section>
    <section class="c-news">
        <h1 class="c-main-title">наши новости</h1>
        <div class="l-news-container">
            <a href="#" class="c-news__item">
                <div class="c-news__item--hover">
                    <i class="fa fa-eye" aria-hidden="true"></i>
                    <span class="c-news__item--hover-caption">Читать</span>
                </div>
                <div class="c-news__item-image"></div>
                <div class="c-news__item-caption">как ухаживать за питомцами</div>
                <div class="c-news__item-info">
                    <span class="c-news__item-date"><i class="fa fa-calendar" aria-hidden="true"></i> 21.07.1993</span>
                    <span class="c-news__item-views"><i class="fa fa-eye" aria-hidden="true"></i> 999</span></div>
            </a>
            <a href="#" class="c-news__item">
                <div class="c-news__item--hover">
                    <i class="fa fa-eye" aria-hidden="true"></i>
                    <span class="c-news__item--hover-caption">Читать</span>
                </div>
                <div class="c-news__item-image"></div>
                <div class="c-news__item-caption">как ухаживать за питомцами</div>
                <div class="c-news__item-info">
                    <span class="c-news__item-date"><i class="fa fa-calendar" aria-hidden="true"></i> 21.07.1993</span>
                    <span class="c-news__item-views"><i class="fa fa-eye" aria-hidden="true"></i> 999</span></div>
            </a>
            <a href="#" class="c-news__item">
                <div class="c-news__item--hover">
                    <i class="fa fa-eye" aria-hidden="true"></i>
                    <span class="c-news__item--hover-caption">Читать</span>
                </div>
                <div class="c-news__item-image"></div>
                <div class="c-news__item-caption">как ухаживать за питомцами</div>
                <div class="c-news__item-info">
                    <span class="c-news__item-date"><i class="fa fa-calendar" aria-hidden="true"></i> 21.07.1993</span>
                    <span class="c-news__item-views"><i class="fa fa-eye" aria-hidden="true"></i> 999</span></div>
            </a>
            <a href="#" class="c-news__item">
                <div class="c-news__item--hover">
                    <i class="fa fa-eye" aria-hidden="true"></i>
                    <span class="c-news__item--hover-caption">Читать</span>
                </div>
                <div class="c-news__item-image"></div>
                <div class="c-news__item-caption">найдена собака!</div>
                <div class="c-news__item-info">
                    <span class="c-news__item-date"><i class="fa fa-calendar" aria-hidden="true"></i> 21.07.1993</span>
                    <span class="c-news__item-views"><i class="fa fa-eye" aria-hidden="true"></i> 999</span></div>
            </a>
            <a href="#" class="c-news__item">
                <div class="c-news__item--hover">
                    <i class="fa fa-eye" aria-hidden="true"></i>
                    <span class="c-news__item--hover-caption">Читать</span>
                </div>
                <div class="c-news__item-image"></div>
                <div class="c-news__item-caption">найден кот!</div>
                <div class="c-news__item-info">
                    <span class="c-news__item-date"><i class="fa fa-calendar" aria-hidden="true"></i> 21.07.1993</span>
                    <span class="c-news__item-views"><i class="fa fa-eye" aria-hidden="true"></i> 999</span></div>
            </a>
            <a href="#" class="c-news__item">
                <div class="c-news__item--hover">
                    <i class="fa fa-eye" aria-hidden="true"></i>
                    <span class="c-news__item--hover-caption">Читать</span>
                </div>
                <div class="c-news__item-image"></div>
                <div class="c-news__item-caption">кот хищник</div>
                <div class="c-news__item-info">
                    <span class="c-news__item-date"><i class="fa fa-calendar" aria-hidden="true"></i> 21.07.1993</span>
                    <span class="c-news__item-views"><i class="fa fa-eye" aria-hidden="true"></i> 999</span></div>
            </a>
            <a href="#" class="c-news__item">
                <div class="c-news__item--hover">
                    <i class="fa fa-eye" aria-hidden="true"></i>
                    <span class="c-news__item--hover-caption">Читать</span>
                </div>
                <div class="c-news__item-image"></div>
                <div class="c-news__item-caption">котята,щенки</div>
                <div class="c-news__item-info">
                    <span class="c-news__item-date"><i class="fa fa-calendar" aria-hidden="true"></i> 21.07.1993</span>
                    <span class="c-news__item-views"><i class="fa fa-eye" aria-hidden="true"></i> 999</span></div>
            </a>
            <a href="#" class="c-news__item">
                <div class="c-news__item--hover">
                    <i class="fa fa-eye" aria-hidden="true"></i>
                    <span class="c-news__item--hover-caption">Читать</span>
                </div>
                <div class="c-news__item-image"></div>
                <div class="c-news__item-caption">найдена собака!</div>
                <div class="c-news__item-info">
                    <span class="c-news__item-date"><i class="fa fa-calendar" aria-hidden="true"></i> 21.07.1993</span>
                    <span class="c-news__item-views"><i class="fa fa-eye" aria-hidden="true"></i> 999</span></div>
            </a>
            <button class="c-news__more-button">больше новостей</button>
        </div>
    </section>
    <section class="c-instagram">
        <h1 class="c-main-title">наш instagram</h1>
        <div class="l-instagram-container">
            <!-- SnapWidget -->
            <iframe src="https://snapwidget.com/embed/404351" class="snapwidget-widget" allowTransparency="true"
                    frameborder="0" scrolling="no"
                    style="border:none; overflow:hidden; width:100%; height:300px"></iframe>
        </div>
    </section>
</main>

<footer class="c-footer">
    <div class="c-footer__info"><span>меню</span><span class="c-footer__author">design by </span><span>benmax</span>
    </div>
    <div class="c-footer__socials">
        <i class="fa fa-instagram" aria-hidden="true"></i> <i class="fa fa-facebook-official" aria-hidden="true"></i>
    </div>
</footer>
<script type="text/javascript">
    <%@include file="/resources/main/assets/script.js"%>
</script>

</body>
</html>
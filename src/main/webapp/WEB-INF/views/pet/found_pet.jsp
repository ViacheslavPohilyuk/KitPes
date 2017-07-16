<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kitpes - base of pets found</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/style.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/found/styles/main.css"/>">
    <script src="<c:url value="https://use.fontawesome.com/a81cbcd056.js" />"></script>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js" />"></script>
</head>
<script>
    var app = angular.module("PetsFoundList", []);

    //Controller Part
    app.controller("PetList", function ($scope, $http) {
        $scope.feedContainer = document.querySelector(".c-find");
        $scope.store;
        $scope.pets = [];
        $scope.counter = 0;
        $scope.morePets = true;
        $scope.showMore = document.querySelector("#more");
        $scope.allItems;
        $scope.closeModal;
        function requestItems() {
            //Now load the data from server

            /* Private Method */
            // HTTP GET- get all files collection
            $http({
                method: 'GET',
                url: '/api/foundlostpets/limited?type=1&bunch=' + ${page}
            }).then(function successCallback(response) {
                $scope.pets = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });

            /* if (!$scope.store) {
             $scope.store = data;
             console.log($scope.store);
             $scope.counter++;
             } else {
             $scope.counter++;
             for (var i = 0; i < $scope.data.length; i++) {
             $scope.store.push($scope.data[i]);
             }
             console.log(store);
             console.log("==================");
             console.log(data);

             if (data.length < 8) {
             $scope.morePets = false;
             $scope.showMore.style.display = "none";
             }
             }*/
        }

        requestItems();
    });
</script>
<body class="c-body" ng-app="PetsFoundList" ng-controller="PetList">
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

        <!-- Циклический вывод карточек питомцев src="{{ pet.profileImgURL }}" -->
        <div ng-repeat="pet in pets" class="c-find__item col-1-4" name="pets">
            <div style="background-image: url({{ pet.profileImgURL }});" class="c-find__image"></div>
            <div class="c-find__info">
                <h4 class="c-find__name">{{ pet.name }}</h4>
                <hr class="c-find__line">
                <img class="c-find__date-image" src="/resources/found/images/date.svg">
                <span class="c-find__date">{{ pet.dateLostFound }}</span>
                <img class="c-find__user-image" src="/resources/found/images/user.svg">
                <span class="c-find__user">Максимов Вениамин</span>
            </div>
            <div class="c-find__learn-more">
                <img class="c-find__plus" src="/resources/found/images/plus.png">
                <a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>
            </div>
        </div>


        <!--<div class="c-find" id="app">
        </div>
        <div class="l-row">

        </div>
        <div class="l-layot" id="more">
            <div class="c-find__show-all">
                <div class="l-grid">
                    <h4 class="c-find__show-all-head">показать всех найденных питомцев</h4>
                    <img class="c-find__down" src="/resources/found/images/down.svg">
                </div>
            </div>
        </div>
        <div onclick="show(" none
        ")" class="l-wrap"> -->
    </div>
</div>
<div>
    <div class="pagination">
        <c:if test="${page != 0}">
            <a class="prev_page_button" href="/foundLostPet/found/${page - 1}" style="display: inline-block;">
                <i class="fa fa-arrow-circle-left" aria-hidden="true"></i>
            </a>
        </c:if>
        <c:if test="${((page + 1) * bunch) < count}">
            <a class="prev_page_button" href="/foundLostPet/found/${page + 1}">
                <i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
            </a>
        </c:if>
    </div>
</div>
<footer class="c-footer">
    <div class="c-footer__info"><span>меню</span><span class="c-footer__author">design by </span><span>benmax</span>
    </div>
    <div class="c-footer__socials">
        <i class="fa fa-instagram" aria-hidden="true"></i> <i class="fa fa-facebook-official" aria-hidden="true"></i>
    </div>
</footer>
<!-- file="/resources/found/js/feed.js" file="/resources/found/js/js.js"-->
<script type="text/javascript">
    <%@include file="/resources/assets/script.js"%>
    <%@include file="/resources/found/js/js.js"%>
</script>

</body>
</html>
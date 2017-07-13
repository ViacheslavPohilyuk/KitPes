var body = document.querySelector("body");
var menuButton = document.querySelector(".c-navigation__menu-button");
var menuBackground = document.querySelector(".l__menu-background");
var logo = document.querySelector(".c-navigation__logo");
var menu = document.querySelector(".c-navigation__menu");
var main = document.querySelector(".main");


function toggleMenu(){
	body.classList.toggle("body-no-overflow");
    // main.classList.toggle("body-no-overflow");
menuBackground.classList.toggle("l__menu-background--open");
logo.classList.toggle("c-navigation__logo--open-menu");
menu.classList.toggle("c-navigation__menu--open");
menuButton.classList.toggle("c-navigation__menu-button--open");

}

menuButton.addEventListener("click", toggleMenu);


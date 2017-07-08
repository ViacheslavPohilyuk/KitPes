var body = document.querySelector("body");
var slider = document.querySelector(".c-slider__canvas");
var menuButton = document.querySelector(".c-navigation__menu-button");
var menuBackground = document.querySelector(".l__menu-background");
var logo = document.querySelector(".c-navigation__logo");
var menu = document.querySelector(".c-navigation__menu");
var current = 0;
var dimmension = 0;
var width = window.innerWidth;

function showNext(){
	if(current < 5){
		setTimeout(function(){
			dimmension += 100.31;
	slider.style.transform = "translateX(-" + dimmension + "%)";
	current++;
		},1000);
} else {
	current = 1;
	dimmension = 0;

}

setTimeout(showNext,5000);
}

setTimeout(showNext,5000);

function toggleMenu(){
	body.classList.toggle("body-no-overflow");
menuBackground.classList.toggle("l__menu-background--open");
logo.classList.toggle("c-navigation__logo--open-menu");
menu.classList.toggle("c-navigation__menu--open");
menuButton.classList.toggle("c-navigation__menu-button--open")

}

menuButton.addEventListener("click", toggleMenu);


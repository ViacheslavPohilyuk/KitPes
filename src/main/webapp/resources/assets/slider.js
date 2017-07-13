/**
 * Created by Роман on 12.07.2017.
 */
var body = document.querySelector("body");
var slider = document.querySelector(".c-slider__canvas");
var menuButton = document.querySelector(".c-navigation__menu-button");
var menuBackground = document.querySelector(".l__menu-background");
var logo = document.querySelector(".c-navigation__logo");
var menu = document.querySelector(".c-navigation__menu");
var current = 0;
var dimmension = 0;


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
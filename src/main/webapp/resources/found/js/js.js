/**
 * Created by roman on 08.07.2017.
 */


document.addEventListener('DOMContentLoaded', function() {
    var click = document.getElementsByClassName("c-find__show-all")[0];
    var elem = document.getElementsByClassName("is-hidden");
    var i;

    click.addEventListener('click', function(e) {
        do {
            for (i = 0; i < elem.length; i++) {
                elem[i].classList.remove('is-hidden');
            }
        } while (elem.length > 0);
    });
});

function show(state){
    document.getElementsByClassName('l-show-pets')[0].style.display = state;
    document.getElementsByClassName('l-wrap')[0].style.display = state;
}
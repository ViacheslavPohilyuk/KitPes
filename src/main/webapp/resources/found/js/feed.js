/**
 * Created by Роман on 15.07.2017.
 */
var feedContainer = document.querySelector(".c-find");
var store;
var counter = 0;
var morePets = true;
var showMore = document.querySelector("#more");
var allItems;
var closeModal;
function requestItems() {
    var xhr = new XMLHttpRequest();

    // 2. Конфигурируем его: GET-запрос на URL 'phones.json'
    xhr.open('GET', 'https://infinite-shore-71587.herokuapp.com/api/foundlostpets/limited?type=1&bunch=' + counter, false);

    // 3. Отсылаем запрос
    xhr.send();

    if (xhr.status != 200) {
        // обработать ошибку
        console.log(xhr.status + ': ' + xhr.statusText); // пример вывода: 404: Not Found
    } else {
        var json = xhr.responseText;
        var data = JSON.parse(json);

        if (!store) {
            store = data;
            console.log(store);
            counter++;
        } else {
            counter++;
            for (var i = 0; i < data.length; i++) {
                store.push(data[i]);
            }
            console.log(store);
            console.log("==================");
            console.log(data);

            if (data.length < 8) {
                morePets = false;
                showMore.style.display = "none";
            }
        }
    }
}

requestItems();

function populateTemplates() {
    feedContainer.innerHTML = '';
    store.forEach(function (i) {
        var template = `<div class="c-find__item col-1-4" name="pets">
        <img class="c-find__image" src="${i.profileImgURL}">
        <div class="c-find__info">
            <h4 class="c-find__name">${i.name}</h4>
            <hr class="c-find__line">
            <img class="c-find__date-image" src="/resources/found/images/date.svg">
            <span class="c-find__date">${i.dateLostFound}</span>
            <img class="c-find__user-image" src="/resources/found/images/user.svg">
            <span class="c-find__user">Максимов Вениамин</span>
        </div>
        <div class="c-find__learn-more">
            <img class="c-find__plus" src="/resources/found/images/plus.png">
            <a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>
        </div>
    </div>`
        feedContainer.innerHTML += template;
    })
}

populateTemplates();

function setModals() {
    allItems = Array.from(document.querySelectorAll(".c-find__item"));
    allItems.forEach(function (item, index, arr) {
        item.addEventListener("click", function () {
            console.log(store[index].id);
            var modal = `<div class="c-modal">
			<div class="l-show-pets">
<div class="c-show-pets">
	
			<div class="c-show-pets__main">
			
			
			
			 <div class="c-show-pets__photo col-1-4">
            <img class="c-show-pets__main-photo" src="${store[index].profileImgURL}"><br>
            <span class="c-show-pets__search">
               
        </div>
        
        
        
			<div class="c-show-pets__name" name="name">${store[index].name}</div>
			<button class="c-show-pets__close" @click.prevent="getDetails"></button>
				
				<div class="c-show-pets__info col-3-4">
					<span class="c-show-pets__type" name="kind">кошка</span>/
            <span class="c-show-pets__type" name="sex">девочка</span>/
            <span class="c-show-pets__type" name="breed">тонкинская кошка</span><br>
					<span class="c-show-pets__type" name="age">${store[index].age} года</span>/
            <span class="c-show-pets__type" name="color">белая</span>/
            <span class="c-show-pets__type" name="form">здорова</span><br>
					<span class="c-show-pets__type" name="graft">привита</span>/
            <span class="c-show-pets__type" name="sterilization">не стерилизована</span>
					<div class="c-show-pets__date">
						<span class="c-show-pets__find-date" name="find-date">13.13.2017</span>
						(дата, когда был найден питомец)</div>
					<div class="c-show-pets__description">${store[index].description}
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
					<img class="c-show-pets__massage-img" src="/resources/found/images/massage.png">отправить сообщение
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
		</div>`
            feedContainer.insertAdjacentHTML('beforeend', modal);
            // document.querySelector(".c-modal").style.display = "none";
            toClose();
            // closeModal = document.querySelector(".c-show-pets__close");
            // closeModal.addEventListener("click", function(){
            //     document.querySelector(".c-modal").style.display = "none";
            //
            // })

        })

    })
}

setModals();
function toClose() {
    closeModal = Array.from(document.querySelectorAll(".c-show-pets__close"));
    closeModal.forEach(function (item) {
        item.addEventListener("click", function () {
            document.querySelector(".c-modal").parentNode.removeChild(document.querySelector(".c-modal"));
        })
    })
}

function showMorePets() {
    requestItems();
    populateTemplates();
    setModals();
}

showMore.addEventListener("click", showMorePets);

function displayDetails() {
    var modal = `<div class="c-modal">
			<div class="l-show-pets">
<div class="c-show-pets">
			
			<div class="c-show-pets__main">
			<div class="c-show-pets__name" name="name">{{store.name}}</div>
			<div class="c-show-pets__close" @click.prevent="getDetails"></div>
				<div class="c-show-pets__photo col-1-4">
					<img class="c-show-pets__main-photo" :src="src"><br>
					<span class="c-show-pets__search">
                <img class="c-show-pets__view" src="/resources/found/images/view.png">
                <!--<span class="c-show-pets__show-all-photo">просмотреть все фото</span>-->
            <!--</span><br>-->
					<!--<div class="l-flex">-->
						<!--<img class="c-show-pets__small-photo" src="/resources/found/images/pets8.jpg">-->
						<!--<img class="c-show-pets__small-photo" src="/resources/found/images/pets9.jpg">-->
						<!--<img class="c-show-pets__small-photo" src="/resources/found/images/pets10.jpg">-->
						<!--<img class="c-show-pets__small-photo" src="/resources/found/images/pets11.jpg">-->
					<!--</div>-->
					</span>
				</div>
				<div class="c-show-pets__info col-3-4">
					<span class="c-show-pets__type" name="kind">кошка</span>/
            <span class="c-show-pets__type" name="sex">девочка</span>/
            <span class="c-show-pets__type" name="breed">тонкинская кошка</span><br>
					<span class="c-show-pets__type" name="age">{{store.age}} года</span>/
            <span class="c-show-pets__type" name="color">белая</span>/
            <span class="c-show-pets__type" name="form">здорова</span><br>
					<span class="c-show-pets__type" name="graft">привита</span>/
            <span class="c-show-pets__type" name="sterilization">не стерилизована</span>
					<div class="c-show-pets__date">
						<span class="c-show-pets__find-date" name="find-date">13.13.2017</span>
						(дата, когда был найден питомец)</div>
					<div class="c-show-pets__description">{{store.description}}
            </div>
				</div>
				<!--here-->
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
					<img class="c-show-pets__massage-img" src="/resources/found/images/massage.png">отправить сообщение
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
		</div>`
}
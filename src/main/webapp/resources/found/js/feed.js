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
				<img class="c-show-pets__user-image" src="images/user.svg">
				<span class="c-show-pets__finder" name="finder">Максим Вениаминов</span>
				<a class="c-show-pets__socials" href="#" name="instagram">
					<img class="c-show-pets__socials-img" src="images/instagram.png">
				</a>
				<a class="c-show-pets__socials" href="#" name="facebook">
					<img class="c-show-pets__socials-img" src="images/facebook.png">
				</a>
				<a class="c-show-pets__socials" href="#" name="twitter">
					<img class="c-show-pets__socials-img" src="images/twitter.png">
				</a>
				<a class="c-show-pets__socials" href="#" name="google+">
					<img class="c-show-pets__socials-img" src="images/google.png">
				</a>
				<button class="c-show-pets__massage" name="newmassage">
					<img class="c-show-pets__massage-img" src="images/massage.png">отправить сообщение
        </button>
				<hr class="c-show-pets__line">
				<div class="c-show-pets__contact-item">
					<img class="c-show-pets__contact-img" src="images/phone.png">
					<span class="c-show-pets__contact">телефон</span><br>
					<span class="c-show-pets__telephon" name="telephone">+38 063 99 51 611</span>
				</div>
				<div class="c-show-pets__contact-item">
					<img class="c-show-pets__contact-img" src="images/mail.png">
					<span class="c-show-pets__contact">почта</span><br>
					<span class="c-show-pets__email" name="email">benmax@gmai1.com</span>
				</div>
				<div class="c-show-pets__contact-item">
					<img class="c-show-pets__contact-img" src="images/marker.png">
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
    closeModal.forEach(function(item){
        item.addEventListener("click", function () {
        document.querySelector(".c-modal").parentNode.removeChild(document.querySelector(".c-modal"));
    })
})
}

function showMorePets() {
    setModals();
}

showMore.addEventListener("click", showMorePets);


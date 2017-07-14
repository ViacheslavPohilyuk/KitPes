<template>
	<div class="c-find__item col-1-4" name="pets">
		<img class="c-find__image" :src="src">
		<div class="c-find__info">
			<h4 class="c-find__name">{{elem.name}}</h4>
			<hr class="c-find__line">
			<img class="c-find__date-image" src="/resources/found/src/images/date.svg">
			<span class="c-find__date">15.10.2017</span>
			<img class="c-find__user-image" src="/resources/found/src/images/user.svg">
			<span class="c-find__user">Максимов Вениамин</span>
		</div>
		<div class="c-find__learn-more">
			<img class="c-find__plus" src="/resources/found/src/images/plus.png">
			<a class="c-find__link" href="#"><span class="c-find__link-text">Узнать больше</span></a>
		</div>
	</div>
</template>

<script>
export default{
	props:['elem'],
	data:function(){
		return{
			extend: false,
			src: this.elem.profileImgURL

		}
	}

}
</script>

<style  scoped>
	.col-1-4 {
		width: 23%;
	}
	.c-find {
		width: 100%;
		margin-top: 30px;
	&__item {
		 width: 23%;
		 margin: 5px;
		 display: block;
		 position: relative;
	 }
	&__item:hover > &__learn-more {
		 display: block;
		 margin: 0 auto;
	 }
	&__item:hover {
		 box-shadow: 0 0 10px rgba(0,0,0,0.5);
	 }
	&__image {
		 width: 100%;
		 height: auto;
		 display: block;
		 margin: 0 auto;
		 border: none;
	 }
	&__info {
		 position: relative;
		 z-index: 20;
		 padding-top: 4px;
		 padding-left: 4px;
		 padding-bottom: 7px;
		 background: @color-white;
		 margin-bottom: 5px;
	 }
	&__name {
		 margin-top: 5px;
		 padding-top: 3px;
		 padding-left: 7px;
		 padding-bottom: 4px;
		 font-family: BebasNeue;
		 color: @color-greymedium;
		 letter-spacing: 2px;
		 text-transform: uppercase;
	 }
	&__line {
		 border: 1pixel solid @color-greymedium;
		 margin-top: -20px;
		 margin-bottom: 4px;
		 width: 92%;
	 }
	&__date-image {
		 padding-left: 5px;
		 width: 12px;
	 }
	&__user-image {
		 width: 12px;
	 }
	&__learn-more {
		 width: 100%;
		 height: 100%;
		 background-color: rgba(1, 1, 1, 0.2);
		 position: absolute;
		 left: 0;
		 bottom: 0;
		 right: 0;
		 top: 0;
		 display: none;
		 z-index: 0;
	 }
	&__link {
		 width: 100%;
		 color: @color-white;
		 text-align: center;
		 text-transform: uppercase;
		 display: inline-block;
		 text-decoration: none;
		 position: relative;
		 top: 38%;
		 font-family: BebasNeue;
		 letter-spacing: 1px;
		 padding-bottom: 2%;
	 }
	&__link-text {
		 border-bottom: 0.15vw solid @color-yellow;
	 }
	&__plus {
		 width: 1.2em;
		 display: inline-block;
		 position: absolute;
		 top: 29%;
		 left: 45%;
		 margin: 0 auto;
	 }
	&__show-all {
		 cursor: pointer;
	 }
	&__show-all-head {
		 font-family: BebasNeue;
		 font-size: 16pt;
		 color: @color-greydark;
		 letter-spacing: 3px;
		 text-align: center;
		 text-transform: uppercase;
	 }
	&__date, &__user {
				  font-size: 10px;
				  color: @color-greymedium;
			  }
	&__down {
		 width: 176px;
		 position: relative;
		 left: 50%;
		 margin-left: -88px;
	 }
	}
</style>
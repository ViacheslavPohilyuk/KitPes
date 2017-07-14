<template>

  <div class="c-find">


      <feed-item v-for="elem in store" :elem="elem"> </feed-item>

      <div class="l-layot">
          <div class="c-find__show-all" @click="retData">
              <div class="l-grid">
                  <h4 class="c-find__show-all-head" v-if="morePets">показать всех найденных питомцев</h4>
                  <img class="c-find__down" src="../../images/down.svg" v-if="morePets">
              </div>
          </div>
      </div>
      </div>
</template>

<script>
  import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import FeedItem from './FeedItem.vue'

// import search from "../Maps/SearchMap.vue"

Vue.use(VueAxios, axios)
export default {
  data: function(){
  return{
     store:[],
    currentItem: '',
    container: document.querySelector(".container"),
    counter: 0,
    loading:false,
    hiddenLoad:false,
      morePets: true


  }
 },
 components:{
  'feed-item': FeedItem,
 },
  methods:{
   retData: function(){
      const api = "https://infinite-shore-71587.herokuapp.com/api/foundlostpets/limited?type=1&bunch="  + this.counter;
      Vue.axios.get(api).then(response=> {
        if(response.data.length == 0){
          this.loading = false;
        } else{
          if(this.store.length == 0){
          this.store = response.data;
          this.counter++;
        } else{
          this.counter++;
          for(var i =0; i<response.data.length;i++){
            this.store.push(response.data[i]);
          }
          if(response.data.length < 4) {
              this.morePets = false;
          }
        }
      }
        

      }).catch(error=>{
        console.log('error')
        this.store = []
      })
     this.loading = false;
    }
 } ,
    beforeMount(){
      this.retData();
    }
}
</script>

<style  scoped>

</style>
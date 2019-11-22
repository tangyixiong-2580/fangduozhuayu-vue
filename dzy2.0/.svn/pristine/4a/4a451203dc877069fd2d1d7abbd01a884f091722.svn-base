<template>
    <div class="Castaboutss" style="background-color:#F1F1F1; ">
        <div class="castabout-header">
            <div class="castabout-case">
                <form action="#" class="castabout-form">
                    <input type="search" class="castabout-searchInput" placeholder="输入书名" value="" v-model="names" v-on:keyup="Newitems" >
                </form>
                <button class=" Button  castabout-resetButton">
                    <div class="castabout-inner">
                        <svg viewBox="19 19 22 22" stroke-linecap="round" class="Search-removeIcon">
                            <g transform="translate(21.000000, 21.000000)">
                                <path d="M0.333333333,0.333333333 L17.4148373,17.4148373"></path>
                                <path d="M0.333333333,0.333333333 L17.4148373,17.4148373" transform="translate(9.000000, 9.000000) scale(-1, 1) translate(-9.000000, -9.000000)"></path>
                            </g>
                        </svg>
                    </div>
                </button>
            </div>
        </div>
        <div>
            <div style="height:18px; background-color:#F1F1F1;">&ensp;</div>
            <div class="castabout-root" v-for="(searr,index) in searcharr" :key="index">
                <div>
                    <div class="Search-section" style="margin-top: 0px;">
                        <div class="SearchBookItem" book="[object Object]"  @click="goBookCollection(searr.bookId,listId)"  style="min-height: 71px;">
                            <div class=" castabout-image">
                                <img alt="" :src="'https://images.weserv.nl/?url='+searr.pic" class="jsx-3824360743 img" width="60px" height="85px">
                            </div>
                            <div class="">
                                <div class="SearchBookItem-title">{{searr.title}}</div>
                                <div class="">
                                    <div class="">
                                        <div class="SearchBookItem-description">{{searr.author}} / {{searr.publisher}} / {{searr.pubdate}}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                 
            </div>
        </div>
        <div class="jsx-castabout">
            <div class="castabout-sroot">
                <div class="castabout-sroot line"> </div>
                <svg width="12" viewBox="0 0 24 24" fill="currentColor" xmlns="http://www.w3.org/2000/svg" class="castabout-sroot svgw">
                    <rect x="4" y="4" width="16" height="16" class="castabout-sroot"></rect>
                </svg>
                <div class="castabout-sroot line"> </div>
            </div>
        </div>
    </div>
</template>
<script>
import axios from "axios";
export default {
    name:'Castabout',
     data() {
        return {
        names: "",
        searcharr: [],
        count: 0,
        listId:'',
    };
  },methods:{
     async Newitems() {
          await axios.get("/book/search?title="+this.names)
        .then(res => (this.searcharr = res.data.data));
        console.info("1111111111111"+this.searcharr);
    },goBookCollection(id,listId){
            this.$router.push({path: "/Eecommend", query: {id: id, recommendID:listId}})
    },getas(){
        this.listId = this.$route.query.recommendID;
    }
  },created(){
     this.getas();
  }
}
</script>

<style lang="scss">
     @import "../../assets/scss/home/Castabout.scss";
</style>
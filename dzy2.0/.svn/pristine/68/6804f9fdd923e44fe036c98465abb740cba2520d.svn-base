<template>
  <div class="details">
    <!-- <div
      class="all_details"
      style="color: white; background-image: linear-gradient(to top, rgba(148, 138, 90, 0.6), rgb(148, 138, 90) 56%), url(&quot;https://img.duozhuayu.com/c405d53a9e0b11e9aa2602420a00041e.jpeg?x-oss-process=image/resize,w_450/quality,Q_80&quot;); background-size: cover, cover; background-position: center top, center center;"
      v-bind="collection"
    > -->
    <div class="all_details":style="{'background':'linear-gradient(to top, rgba(35, 67, 135, 0.3) 35%, rgb(35, 67, 135) 69%) center top / auto no-repeat, url('+collection.image+') center center / cover no-repeat'}">
      <div class="book_content">
        <!-- <div class="book_name">值得入手的大部头</div> -->
        <div class="book_name">{{collection.name}}</div>
        <span class="explain">{{collection.intro}}</span>
      </div>
      <footer class="recommend">
        <div class="recommend_content">
          <span class="recommend_number">
            <span class="people_number">27</span>
            人推荐了
            <span class="books_number">{{collection.bookCount}}</span>
            本书
          </span>
          <div class="portrait" style="flex-flow: row-reverse;">
            <span class="avatar">
              <span class="root">
                <img
                  alt
                  src="https://img.duozhuayu.com/ec1c2ab2acbe11e9b3ec02420ac8019d.jpeg"
                  class="Head_portrait"
                />
                <!-- <img :src="b.user.headerImg" alt /> -->
              </span>
            </span>
            <span class="avatar">
              <span class="root">
                <img
                  alt
                  src="https://img.duozhuayu.com/6b7592bcc29f11e99b7d02420ac800cc.jpeg"
                  class="Head_portrait"
                />
              </span>
            </span>
            <span class="avatar">
              <span class="root">
                <img
                  alt
                  src="https://img.duozhuayu.com/b1960992c2aa11e9ac2302420ac800f4.jpeg"
                  class="Head_portrait"
                />
              </span>
            </span>
            <span class="avatar">
              <span class="root">
                <img
                  alt
                  src="https://img.duozhuayu.com/90e3b96cc2b711e9825902420ac800e5.jpeg"
                  class="Head_portrait"
                />
              </span>
            </span>
            <span class="avatar">
              <span class="root">
                <img
                  alt
                  src="https://img.duozhuayu.com/c99b0bc8c29611e985ef02420ac800cb.jpeg"
                  class="Head_portrait"
                />
              </span>
            </span>
          </div>
        </div>
      </footer>
    </div>

    <div class="item" v-for="(b,index) in books" :key="index">
      <div class="comment" style="padding: 0px 16px;">
        <div class="comment_item">
          <div class="Flex BookItem" style="margin-left: 16px; border-bottom: none;">
            <aside>
              <div class="book_picture" @click="goBookCollection(b.book.bookId)">
                <!-- <img src="../assets/imgas/books/辩论.jpeg"  width="90px" height="128px" > -->
                <img :src="b.book.pic" width="90px" height="128px" />
              </div>
              <article>
                <div class="aa">
                  <h3 class="bb">{{b.book.title}}</h3>
                  <!-- <h3 class="bb">辩论：美国宪会议记录</h3> -->
                  <div class="BookImage-content">{{b.book.author}}</div>
                  <div class="BookItem-meta">豆瓣评分 {{b.book.score}}</div>
                </div>
              </article>
            </aside>
          </div>
        </div>
      </div>
      <div class="comment_root">
        <div class="comment_list">
          <p class="full-text">{{b.reason}}</p>

          <footer class="function">
            <div class="flex">
              <div class="character">
                <div class="small">
                  <!-- <img
                    alt
                    src="https://img.duozhuayu.com/c99b0bc8c29611e985ef02420ac800cb.jpeg"
                    width="20px"
                    height="20px"
                  /> -->
                  <img :src="b.user.headerImg" alt />
                
                </div>
                <div class="Text" style="margin-left: 4px; overflow: hidden;">{{b.user.name}}的推荐</div>
              </div>
              <div class="alignCenter">
                <a href style="line-height: 0; margin-right: 30px;">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="18"
                    height="18"
                    viewBox="0 0 18 17"
                    style="color: rgb(170, 170, 170);"
                  >
                    <g class="icon-s">
                      <path
                        d="M13 1L8 6M14 6L14 .87668517C14 .392545599 13.6070711 0 13.1237445 0L8 0M3.83953916 0C1.71931875 0 0 1.74525424 0 3.89745763L0 10.1025424C0 12.2547458 1.71931875 14 3.83953916 14L10.1604608 14C12.2806812 14 14 12.2547458 14 10.1025424L14 9.96491525"
                      />
                    </g>
                  </svg>
                </a>
              </div>
              <div class="alignCenter1">
                <a href style="line-height: 0; margin-right: 30px;">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="18"
                    height="18"
                    viewBox="0 0 18 17"
                  >
                    <g class="icon-s">
                      <path
                        d="M12.169348,0 L3.83065199,0 C1.71493085,0 0,1.79029667 0,3.9989971 L0,9.14005968 C0,11.3369741 1.69686706,13.1154847 3.79678239,13.135521 L4.46740051,14.4319833 C4.79706463,15.0684285 5.62009596,15.1945389 6.11120519,14.6853828 L7.60259667,13.1390568 L12.169348,13.1390568 C14.2850692,13.1390568 16,11.3487601 16,9.14005968 L16,3.9989971 C16,1.79029667 14.2850692,0 12.169348,0 Z"
                      />
                      <path
                        d="M4.47615044 4.65C9.4446895 4.65 11.928959 4.65 11.928959 4.65M5.59750752 8.65L9.51801392 8.65"
                      />
                    </g>
                  </svg>
                </a>
              </div>
              <div class="alignCenter1">
                <a href style="line-height: 0; margin-right: 30px;">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="18"
                    height="18"
                    viewBox="0 0 19 18"
                  >
                    <g class="icon-i">
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        d="M2.74290235,5.6549 L1.32674307,5.9209 C0.564288721,6.0539 2.27373675e-13,6.8189 2.27373675e-13,7.7199 L2.27373675e-13,11.9069 C2.27373675e-13,13.4389 0.575163664,14.7399 2.35502937,14.7399 L3.1924,14.7529"
                      />
                      <path
                        stroke-linecap="square"
                        d="M3.5568,12.0065 L3.5568,5.5265 C3.5568,5.0625 3.66704045,4.6065 3.87715685,4.1995 L5.02667263,1.4615 C5.30368708,0.8025 6.22518415,0.2695 6.762253,0.7125 C7.33983756,1.1885 7.68751897,1.9135 7.71107462,2.6895 L7.71672798,2.9035 C7.74876366,3.9715 8.57321145,4.8195 9.58045109,4.8195 L15.0557266,4.8195 C16.6047462,4.8195 17.320838,6.4245 16.8638584,7.9955 L15.6361379,12.4075 C14.9680996,14.2355 13.3097818,15.4405 11.4630187,15.4405 L6.79240423,15.4405 C5.00500143,15.4405 3.5568,13.9025 3.5568,12.0065 Z"
                      />
                    </g>
                  </svg>
                  <span class="label">{{b.count}}</span>
                </a>
              </div>
            </div>
          </footer>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      books: [],
      collection:[],
      thumbs:[]
    };
  },
  created() {
    this.booklist();
    this.one();
    this.give();
 
    console.info("11111111111111111111",this.$route.query.collectionId);

  },
  methods: {
      goBookCollection(id){
            this.$router.push({path: "/comment", query: {collectionId: id}})
           
        },
    
    async booklist() {
      this.books = await axios
        .get("/collection/detailed?collectionId="+this.$route.query.collectionId)
        .then(res => res.data.data);
    },
    async one() {
      this.collection = await axios
        .get("/book/collection/"+this.$route.query.collectionId)
        .then(res => res.data.data);
    },
    async give() {
      this.thumbs = await axios
        .post("/thumbsUp/"+this.$route.query.collectionId)
        .then(res => res.data.data);
    },

    
    // async headbook(){
    //     this.books = await axios
    //     .get("book/collection/"+this.$route.query.id)
    //     .then(res => res.data.data);
    //     console.info(this.books)
    
    // },
    

  }
  
};
</script>

<style>
/* .align{
    margin-right: 30px;
} */

.icon-s {
  fill: none;
  fill-rule: evenodd;
  stroke: currentcolor;
  stroke-linecap: round;
  stroke-width: 1.2;
  transform: translate(2, 1);
}
.icon-i {
  fill: antiquewhite;
}

.details {
  background: white;
}
.label {
  margin-left: 6px;
  color: rgb(170, 170, 170);
}
.alignCenter {
  display: flex;
  margin-left: 110px;
}
.small {
  display: inline-block;
  vertical-align: top;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: 21px;
  height: 21px;
  background: rgb(242, 242, 242);
  border-width: 1px;
  border-style: solid;
  border-color: rgb(242, 242, 242);
  -o-border-image: initial;
  border-image: initial;
  border-radius: 99px;
  overflow: hidden;
}
.character {
  display: flex;
  align-items: center;
  white-space: nowrap;
  /* overflow: hidden; */
}
.flex {
  display: flex;
  align-items: center;
  flex: 1 1 0%;
  min-width: 0px;
  margin-right: 4px;
  color: rgb(170, 170, 170);
  /* border: 1px solid black; */
  /* padding-left: 25px; */
}
.function {
  display: flex;
  flex-direction: row;
  -webkit-box-align: center;
  align-items: center;
  /* margin-top: 1em; */
  font-size: 14px;
  color: rgb(170, 170, 170);
  white-space: nowrap;
  width: 100%;
  margin-top: 13px;
  /* border: 1px solid black; */
}
.full-text {
  font-size: 15px;
  line-height: 1.6;
  overflow-wrap: break-word;
  word-break: break-word;
  user-select: initial;
}
.comment_list {
  padding: 16px 28px 16px;
  border-bottom: 0.5px solid rgb(230, 230, 230);
  /* border: 1px solid black; */
}
.comment_root {
  margin-top: 47px;
  /* / border-bottom: 0.5px solid rgb(230, 230, 230); */
  /* border: 1px solid black */
}
.BookItem-meta {
  color: rgb(214, 186, 140);
  font-size: 14px;
  margin-top: -6px;
}
.BookImage-content {
  width: 200px;
  font-size: 14px;
  color: rgb(170, 170, 170);
}
.bb {
  font-size: 18px;
  font-weight: 400;
}
.aa {
  /* border: 1px solid black; */
  /* width: 60%; */
  /* margin-top: 20px; */
  margin-left: 102px;
  margin-top: -130px;
  line-height: 29px;
}
.book_picture {
  width: 90px;
  height: 128px;
}
.comment_information {
  sdisplay: block;
  /* border: 1px solid black; */
  width: 50%;
  margin-left: 150px;
}
.comment_item {
  margin-top: 30px;
  /* border: 1px solid black; */
}
.avatar {
  display: block;
  margin-right: -5.5px;
}
.Head_portrait {
  display: block;
  width: 100%;
}
.portrait {
  display: flex;
  /* border: 1px solid black; */
  margin-left: 218px;
  width: 40%;
  margin-top: -32px;
}
.root {
  display: inline-block;
  vertical-align: top;
  box-sizing: border-box;
  width: 30px;
  height: 30px;
  background: rgb(242, 242, 242);
  border-width: 1px;
  border-style: solid;
  border-color: rgb(242, 242, 242);
  border-image: initial;
  border-radius: 99px;
  overflow: hidden;
}
.recommend_number {
  font-size: 15px;
  margin-left: 20px;
  padding-top: 20px;
  /* border: 1px solid black; */
}
.recommend {
  margin-bottom: 20px;
  /* border: 1px solid black; */
  padding-top: 20px;
  margin-bottom: 20px;
  /* border:1px solid black; */
}
.all_details {
  /* display: flex; */
  white: 100%;
  border: 1px solid black;
}
.book_content {
  margin-top: 32px;
  margin-left: 16px;
  margin-bottom: 80px;
  /* border:1px solid black; */
}
.book_name {
  margin-bottom: 12px;
  font-size: 30px;
  font-weight: 500;
  /* border:1px solid black; */
}
.explain {
  line-height: 1.6;
  font-size: 15px;
  /* border:1px solid black; */
}
</style>
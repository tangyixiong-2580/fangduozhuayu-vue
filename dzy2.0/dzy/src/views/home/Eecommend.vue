<template>
  <div class="Eecommend">
    <div class="recommend" :style="present===true ? 'filter: blur(6px);' : ''">
      <div>
        <div>
          <div class="recommend-book">想推荐的书</div>
        </div>
        <div>
          <router-link  :to="{path:'/castabout',query:{recommendID:listId}}" v-if="arrbook===undefined">
            <div
              style="    position: relative;    width: 100%;   height: 48px; margin-bottom: 15px;"
            >
              <input class="Input" placeholder="输入书名" style="background: transparent;" />
              <svg
                width="16"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                xmlns="http://www.w3.org/2000/svg"
                class="Icon"
              >
                <circle cx="10.5" cy="10.5" r="7.5" />
                <line x1="21" y1="21" x2="15.8" y2="15.8" />
              </svg>
            </div>
          </router-link>
          <div v-if="arrbook!=undefined">
            <router-link
              class="SearchBookItem"
              href="/books/70549745298310207"
              style="min-height: 71px; margin-bottom: 32px; padding: 0px; background: none;"
              :to="{path:'/detaile',query:{bookId:request.bookId}}"
            >
              <div class="recommend-SearchBookItem">
                <img
                  alt
                  :src="'https://images.weserv.nl/?url='+request.pic"
                  class="jsx-3824360743 img"
                  width="90px"
                  height="128px;"
                  style="box-shadow: rgba(0, 0, 0, 0.2) 2px 2px 16px 0px;"
                />
              </div>
              <div class="Srecommend-evenBetween">
                <div>
                  <h2 class="SearchBookItem-title" style="font-size: 15px;">{{request.title}}</h2>
                </div>
                <div class="recommend-grow">
                  <div class="recommend-grow">
                    <div class="recommend-description" style="font-size: 13px; line-height: 1.5;">
                      <p>{{request.author}} / {{request.publisher}} / {{request.pubdate}}</p>
                      <span
                        class="recommend-rating"
                        style="display: block; margin-top: 4px;"
                      >豆瓣评分 {{request.score}}</span>
                    </div>
                    <div class="SearchBookItem-description" style="font-size: 13px;"></div>
                  </div>
                </div>
                <router-link class="modification" style=""   :to="{path:'/castabout',query:{recommendID:listId}}">
                   修改
                </router-link>
              </div>
            </router-link>
            
          </div>
        </div>
      </div>
      <div style=" margin-bottom: 25px;">
        <div class="recommend-book">为什么推荐这本书？</div>
        <div>
          <textarea
            maxlength="200"
            class="Input"
            name="reason"
            placeholder="说说你和这本书的故事，鱼编会选择有趣的推荐展示在书单里"
            style="height: 8em; background: transparent;"
            v-model="review"
          ></textarea>
        </div>
        <div>{{calculate}}/200</div>
      </div>
      <div>
        <div class="recommend-book">推荐到这个书单:</div>
        <div>
          <div
            class="recommend-Flex"
            style="align-items: center;border-top: 0.5px solid rgb(230, 230, 230);border-bottom: 0.5px solid rgb(230, 230, 230);padding: 22px 0px;"
          >
            <router-link class="recommend-alignCenter" to="/open-collections/208227522469431802">
              <div
               style="min-width: 50px; width: 50px; height: 50px; border-radius: 6px; margin-right: 10px;"
              >
              <img :src="'https://images.weserv.nl/?url='+information.image" width="50px" height="50px">
              </div>
              <div class="recommend-column">
                <p style="font-size: 15px; font-weight: 400; ">{{information.name}}</p>
                <p
                  style="font-size: 13px; color: rgb(170, 170, 170); -webkit-line-clamp: 2; overflow: hidden;"
                >{{information.name}}</p>
              </div>
            </router-link>
            <div
              class="recommend-Flex"
              style="flex-grow: 1; flex-direction: column; align-items: flex-end;"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="24"
                height="24"
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                style="color: rgb(24, 195, 170); padding-left: 23px;"
              >
                <polyline points="20 6 9 17 4 12" />
              </svg>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div>
      <div
        :style="present===true ? 'filter: blur(6px);' : ''"
        class="recommend-Fixed"
        style="height: calc(92px + 130px + env(safe-area-inset-bottom)); background-color: rgb(255, 255, 255); box-shadow: rgba(0, 0, 0, 0.08) 0px -1px 8px 0px; margin-top: 0px; margin-right: 0px; margin-bottom: calc(-130px - env(safe-area-inset-bottom)); margin-left: 0px;"
      >
        <div class="recommend-button">
          <button
            @click="determinecancel()"
            class="recommend-primary"
            type="submit"
            style="width: calc(100% - 106px); font-size: 15px; margin-top: 17px; margin-right: auto; margin-bottom: calc(130px + 17px + env(safe-area-inset-bottom)); margin-left: auto;"
          >推荐</button>
        </div>
        <div class="recommend-iphone-x"></div>
      </div>
    </div>
    <div v-if="present===true">
      <div class="recommend-backdrop">
        <div class="recommend--headless">
          <div class="recommend-mainWrapper">
            <div class="recommend-main">
              <div class="recommend-body">提交之后内容不可修改</div>
              <div class="recommend-footer">
                <div style="    width: 100%;">
                  <div class="recommend-contasiner">
                    <button class="Button recommend-button" @click="determinecancel()">再检查一下</button>
                    <button
                      class="Button recommend-button recommend--primary"
                      @click="recommendSubmit()"
                    >确认提交</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="recommend-buttonWrapper">
            <button class="Button recommend-close">
              <div class="recommend-inner" @click="determinecancel()">
                <svg viewBox="19 19 22 22" stroke-linecap="round" class="recommend-removeIcon">
                  <g transform="translate(21.000000, 21.000000)">
                    <path d="M0.333333333,0.333333333 L17.4148373,17.4148373" />
                    <path
                      d="M0.333333333,0.333333333 L17.4148373,17.4148373"
                      transform="translate(9.000000, 9.000000) scale(-1, 1) translate(-9.000000, -9.000000)"
                    />
                  </g>
                </svg>
              </div>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "Eecommend",
  data() {
    return {
      present: false,
      listId:'',
      arrbook: "",
      request: {
        title: "",
        pic: "",
        author: "",
        publisher: "",
        score: "",
        bookId: ""
      },
      information:{
        name:'',
        image:'',
        intro:'',
      },
      review: "",
      condition:'',
      count: 0
    };
  },
  methods: {
    determinecancel() {
      this.present = !this.present;
    },
    getCollection() {
      this.arrbook = this.$route.query.id;
      this.listId = this.$route.query.recommendID;
      this.bookinformation();
      console.info("带过来了" + this.listId);
    },
    async acquiresingle() {
      await axios
        .get("/book/" + this.arrbook)
        .then(res => (this.request = res.data.data));
    },
    async recommendSubmit() {
      axios
        .post(
          "/collection/detailed?bookId=" +
            this.request.bookId +
            "&reason=" +
            this.review +
            "&bookCollectionId="+this.listId
        )
        .then(res => {
            this.condition=res.data.msg;
            this.giveamark();
        });
        console.info("带过来了" + this.condition);
    }, async giveamark(){
          console.info("我进来了密码" + this.condition);
        if(this.condition==="成功"){
          this.$message("成功");
          this.$router.push({path: "/listdetails", query: {booklistid: this.listId}})
        }else if(this.condition==="该书籍在书单已经存在"){
          this.$message("该书籍在书单已经存在");
           this.present = !this.present;
        }else if(this.condition==="推荐语不得超过200字"){
          this.$message("推荐语不得超过200字");
           this.present = !this.present;
        }else if(this.condition==="该书豆瓣评分少于7.5，不符合推荐要求"){
             console.info("我进来了密水水水水水码" + this.condition);
          this.$message("该书豆瓣评分少于7.5分，不符合推荐要求");
           this.present = false;
        }
    },async bookinformation(){
        await axios
        .get("/book/collection/" + this.listId)
        .then(res => (this.information = res.data.data));
        console.info("不知道" + this.information.name);
    }

  },
  created() {
    this.getCollection();
    this.acquiresingle();
  },
  computed: {
    calculate() {
      this.count = this.review.length;
      if (this.review.length >= 200) {
        this.$message("推荐字数超过200个字符了");
      }
      return this.count;
    }
  }
};
</script>
<style lang="scss">
@import "../../assets/scss/home/Eecommend.scss";
</style>
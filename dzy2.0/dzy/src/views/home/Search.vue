<template>
  <div class="hunt">
    <div class="Search">
      <div class="searchbox">
        <div class="searchboxox">
          <form action="#" class="Search-form">
            <input
              @keyup="commitSearch()"
              type="search"
              class="Input SearchInput"
              v-model="bookName"
              placeholder="书名 / 作者 / 分类"
              value="自我救赎"
              id="temp"
            />
            <div class="Button Search-resetButton Button--icon" @click="bookName = ''">
              <div class="Button-inner" v-if="bookName != ''">
                <svg viewBox="19 19 22 22" stroke-linecap="round" class="Search-removeIcon">
                  <g transform="translate(21.000000, 21.000000)">
                    <path d="M0.333333333,0.333333333 L17.4148373,17.4148373" />
                    <path
                      d="M0.333333333,0.333333333 L17.4148373,17.4148373"
                      transform="translate(9.000000, 9.000000) scale(-1, 1) translate(-9.000000, -9.000000)"
                    />
                  </g>
                </svg>
              </div>
            </div>
          </form>
        </div>
      </div>

      <div id="type" v-if="bookName === ''">
        <div style="height:16px; background-color:#F1F1F1;">&ensp;</div>
        <h2 class="attempt">你可以试试搜</h2>
        <div id="labels">
          <a class="label_desc" href>现代</a>
          <a class="label_desc" href>小说</a>
          <a class="label_desc" href>日本</a>
          <a class="label_desc" href>外国文学</a>
          <a class="label_desc" href>文学</a>
          <a class="label_desc" href>绘本</a>
          <a class="label_desc" href>中国</a>
          <a class="label_desc" href>长篇小说</a>
          <a class="label_desc" href>日本文学</a>
          <a class="label_desc" href>言论自由</a>
          <a class="label_desc" href>中国文学</a>
          <a class="label_desc" href>经典</a>
        </div>
        <br />
      </div>
      <div class="substance" v-if="bookName !== ''">
        <div style="height:16px; background-color:#F1F1F1;">&ensp;</div>
        <div class="classification">
          <div class="Search-tagImage">
            <svg width="15" viewBox="0 0 31 30" xmlns="http://www.w3.org/2000/svg">
              <g fill="currentColor" transform="translate(-64.000000, -343.000000)">
                <path
                  d="M92.5058744,350.599669 L87.7616885,350.599669 L88.6287981,345.117941 C88.7506758,344.606673 88.6319951,344.067741 88.3066285,343.654963 C87.981262,343.242184 87.4849565,343.00091 86.959363,343.000001 C85.7758266,343.065123 84.7981712,343.947297 84.612187,345.117941 L83.7450774,350.599669 L76.8480677,350.599669 L77.7201607,345.117941 C77.8422406,344.605823 77.7229531,344.066 77.3964465,343.653008 C77.0699399,343.240016 76.5722101,342.999385 76.0457421,343.000001 C74.8602134,343.058003 73.8801735,343.944209 73.7035495,345.117941 L72.8314565,350.599669 L68.0872707,350.599669 C66.9392747,350.634136 65.9704624,351.463954 65.7600282,352.593024 C65.6610696,353.092061 65.7950691,353.608988 66.1239994,353.997106 C66.4529297,354.385225 66.9408877,354.602171 67.4493969,354.586379 L72.1935828,354.586379 L71.1022207,361.513289 L66.3580349,361.513289 C65.2100389,361.547757 64.2412265,362.377574 64.0307924,363.506645 C63.9338255,364.005387 64.068559,364.521181 64.3970543,364.908786 C64.7255495,365.296391 65.2122692,365.513876 65.7201611,365.5 L70.4743138,365.5 L69.6221543,370.88206 C69.5002766,371.393328 69.6189574,371.93226 69.9443239,372.345038 C70.2696904,372.757817 70.7659959,372.999091 71.2915895,373 C72.4743551,372.933029 73.4510207,372.051749 73.6387655,370.88206 L74.4610246,365.529901 L81.3779678,365.529901 L80.5307918,370.88206 C80.4107415,371.393954 80.5308135,371.93265 80.8568948,372.345105 C81.1829761,372.757559 81.6794293,372.998693 82.2052103,373 C83.386836,372.932611 84.3618306,372.050967 84.5474029,370.88206 L85.394579,365.529901 L90.1387648,365.529901 C91.2860397,365.493572 92.2538443,364.664617 92.4660073,363.536545 C92.5649659,363.037508 92.4309664,362.520581 92.1020361,362.132463 C91.7731058,361.744345 91.2851478,361.527398 90.7766386,361.54319 L86.0324527,361.54319 L87.1238148,354.64618 L91.8680006,354.64618 C93.0159966,354.611713 93.984809,353.781895 94.1952431,352.652825 C94.3155942,352.145003 94.1915397,351.610119 93.8599434,351.207117 C93.528347,350.804115 93.0273672,350.579371 92.5058744,350.599669 Z M82.0158416,361.513289 L75.1188319,361.513289 L76.2101939,354.61628 L83.1072036,354.61628 L82.0158416,361.513289 Z"
                />
              </g>
            </svg>
          </div>
          <div class="Search-tagName">
            <div style="display: flex;">
              <span class="jsx-424758906 Text Text--pe" style="padding-right: .20em;">{{bookName}}</span>分类
            </div>
          </div>
          <div class="Search-tagMeta">
            <span class="jsx-424758906 Text Text--pe" style="padding-right: .25em;">{{count}}</span>本在售
            <svg
              width="6.5px"
              viewBox="0 0 13 24"
              xmlns="http://www.w3.org/2000/svg"
              class="Search-tagIcon"
            >
              <g fill="currentColor" transform="translate(-707.000000, -346.000000)">
                <path
                  d="M720.039467,358 C720.054396,357.701471 719.947859,357.398 719.719857,357.169998 L719.719857,357.169998 L708.870845,346.320986 L708.870845,346.320986 C708.442863,345.893005 707.748968,345.893005 707.320986,346.320986 C706.893005,346.748968 706.893005,347.442863 707.320986,347.870845 L717.450141,358 L707.320986,368.129155 C706.893005,368.557137 706.893005,369.251032 707.320986,369.679014 C707.748968,370.106995 708.442863,370.106995 708.870845,369.679014 L719.719857,358.830002 L719.719857,358.830002 C719.947859,358.602 720.054396,358.298529 720.039467,358 Z"
                />
              </g>
            </svg>
          </div>
        </div>
        <div style="height:16px; background-color:#F1F1F1;">&ensp;</div>
        <div
          class="SearchBookItem"
          v-for="(item,index) in searchResult"
          :key="index"
          @click="checkBook(item)"
        >
          <div style="margin-right: 12px;">
            <img :src="'https://images.weserv.nl/?url='+item.pic" width="50px" height="70px;" />
          </div>
          <div class="evenBetween">
            <div style="width: 100%">
              <div class="fiction">{{item.title}}</div>
              <div style="display: flex;">
                <div
                  class="SearchBookItem-description"
                >{{item.author}} / {{item.publisher}} / 豆瓣评分 {{item.score}}</div>
              </div>
              <div class="SearchBookItem-meta">
                <span class="Pricesaf">
                  ￥{{parseInt(item.price).toFixed(2)}}
                  {{getBookAppearances(item).length > 1 ? '起' : ''}}
                </span>
                <span class="appearances" v-if="getBookAppearances(item).length > 1">多版本可选</span>
                <div
                  class="intoCart"
                  v-if="getBookAppearances(item).length == 1 && !checkCart(item)"
                  @click.stop="intoCart(item)"
                >加入购物车</div>
                <span
                  class="cart-existence"
                  v-if="getBookAppearances(item).length == 1 && checkCart(item)"
                  @click.stop
                >已加入购物车</span>
                <span
                  class="book-appearances"
                  @click.stop="chooseAppearance(item)"
                  v-if="getBookAppearances(item).length > 1 && !checkCart(item)"
                >多个品相可选</span>
                <van-popup v-model="showAppearances" position="bottom" class="appearances-choose">
                  <div class="title">
                    <span class="title-name">{{bookDetaile.title}}</span>
                    <div class="appearances-rule">
                      <span>多个品相的书可以购买</span>
                      <span class="appearances-showRules">
                        不同品相有何区别？
                        <svg
                          viewBox="0 0 24 24"
                          fill="none"
                          stroke="rgb(170, 170, 170)"
                          stroke-width="2"
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          xmlns="http://www.w3.org/2000/svg"
                          width="18px"
                        >
                          <polyline points="9 18 15 12 9 6" />
                        </svg>
                      </span>
                    </div>
                  </div>
                  <div class="appearances-list">
                    <div
                      class="appearances-content"
                      :class="bookDetaile.chooseAppearance == el ? 'select':''"
                      v-for="(el,index) in bookDetaile.appearances"
                      :key="index"
                      @click.stop="bookDetaile.chooseAppearance = el"
                    >
                      <span class="price">￥{{parseInt(bookDetaile.price[index]).toFixed(2)}}</span>
                      <span
                        class="appearances-text"
                        :class="el == appearance_new ? 'new':''"
                      >{{el == appearance_new ? "全新品" : el == appearance_good ? "品相良好" : "品相中等"}}</span>
                    </div>
                  </div>
                  <div class="choose" @click.stop="intoCart(item)">确定</div>
                </van-popup>
                <span
                  class="cart-existence-appearances"
                  v-if="getBookAppearances(item).length > 1 && checkCart(item)"
                  @click.stop="chooseAppearance(item)"
                >已选:{{bookDetaile.chooseAppearance == appearance_new ? "全新品" : bookDetaile.chooseAppearance == appearance_good ? "品相良好" : "品相中等"}}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Axios from "axios";

export default {
  name: "hunt",
  data() {
    return {
      bookName: "",
      searchResult: [],
      searchAppearance: [],
      count: 0,
      cartBook: "",
      cart: [],
      showAppearances: false,
      bookDetaile: {
        bookId: 0,
        chooseAppearance: 0,
        price: [],
        appearance: []
      },

      appearance_new: 0,
      appearance_good: 1
    };
  },
  methods: {
    checkBook(book) {
      this.$router.push({
        path: "/detaile",
        query: {
          bookId: book.bookId
        }
      });
    },
    commitSearch(timeout, val) {
      this.books = [];
      if (timeout !== null) clearTimeout(timeout);
      if (val == this.bookName) {
        Axios.get("/book/search?title=" + val).then(
          res => (this.searchResult = res.data.data)
        );
        Axios.get("/book/search/appearance?title=" + val).then(
          res => (this.searchAppearance = res.data.data)
        );
        this.getCart();
      }
    },
    getBookAppearances(book) {
      return this.searchAppearance
        .filter(temp => temp.bookId == book.bookId)
        .map(temp => temp.appearance);
    },
    async intoCart(book) {
      let requestData = this.$qs.stringify({
        bookId: book.bookId,
        appearance: this.bookDetaile.chooseAppearance,
        selection: 1
      });
      await Axios({
        method: this.cartBook ? "patch" : "post",
        url: "/cart",
        data: requestData
      }).then(res => this.getCartBook(book));
      this.showAppearances = false;
    },
    async getCartBook(book) {
      await Axios.get("/cart/" + book.bookId).then(res => {
        console.info(res.data);
        if (res.data.data) {
          this.cartBook = res.data.data;
          this.bookDetaile.appearance = res.data.data.appearance;
        }
      });
    },
    async getCart() {
      await Axios.get("/cart/selling").then(res => {
        if (res.data.data) {
          this.cart = res.data.data;
        }
      });
    },
    checkCart(book) {
      return this.cart.find(temp => temp.bookId == book.bookId);
    },
    chooseAppearance(book) {
      (this.showAppearances = true),
        Axios.get("/warehouse/books/" + book.bookId).then(res => {
          this.bookDetaile = {
            title: res.data.data[0].title,
            bookId: book.bookId,
            chooseAppearance: this.cartBook.appearance,
            price: [],
            appearances: []
          };
          res.data.data.forEach(content => {
            this.bookDetaile.price.push(content.price);
            this.bookDetaile.appearances.push(content.appearance);
          });
        });
      this.getCartBook(book.bookId);
    }
  },
  watch: {
    bookName: function(val) {
      let timeout = null;
      timeout = setTimeout(() => {
        this.commitSearch(timeout, val);
      }, 1000);
    }
  }
};
</script>
<style lang="scss">
@import "../../assets/scss/home/seaings.scss";
@import "../../assets/scss/home/search.scss";
</style>


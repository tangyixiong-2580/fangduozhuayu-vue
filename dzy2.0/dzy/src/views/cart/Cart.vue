<template>
  <div class="cart-wrapper">
    <div class="tabs">
      <div class="tab" :class="{active:currentTab=='all'}" @click="currentTab='all'">
        <div>全部</div>
      </div>
      <div class="tab" :class="{active:currentTab=='warn'}" @click="currentTab = 'warn'">
        <div>到货提醒</div>
      </div>
    </div>
    <div class="books-warn" v-show="currentTab=='warn'">
      <div class="book" v-for="(book,index) in shortageCart" :key="index">
        <div class="content">
          <img :src="'https://images.weserv.nl/?url='+book.images" alt />
          <div class="info">
            <span class="title">
              {{book.title}}
              <div class="close" @click="delCartBook(book)">
                <svg
                  viewBox="19 19 22 22"
                  stroke-linecap="round"
                  width="10"
                  height="10"
                  stroke="rgb(170, 170, 170)"
                >
                  <g transform="translate(21.000000, 21.000000)">
                    <path d="M0.333333333,0.333333333 L17.4148373,17.4148373" />
                    <path
                      d="M0.333333333,0.333333333 L17.4148373,17.4148373"
                      transform="translate(9.000000, 9.000000) scale(-1, 1) translate(-9.000000, -9.000000)"
                    />
                  </g>
                </svg>
              </div>
            </span>
            <div class="condition">
              <div class="reserve">预定</div>
              <div class="lock" @click="delCartBook(book)">取消到货提醒</div>
            </div>
          </div>
        </div>
      </div>
      <div class="books-warn-text">
        <span>遇到想买的书无货可以标记到货提醒</span>
        <span>有货了会通知你</span>
      </div>
    </div>
    <div class="books" v-show="currentTab=='all'">
      <div class="book" v-for="(book,index) in sellingCart" :key="index">
        <div class="checkbox" :class="{checked:book.selection == 1}" @click="select(book)">
          <svg
            width="14.5"
            height="11"
            viewBox="11 14 29 22"
            stroke="#FFFFFF"
            stroke-width="4"
            fill="none"
          >
            <polyline points="13.2427972 23.7361617 21.8111153 32.3044798 38 16.1155951" />
          </svg>
        </div>
        <div class="content">
          <router-link :to="{path:'/detaile',query:{bookId:book.bookId}}">
            <img v-lazy="'https://images.weserv.nl/?url='+book.images" alt />
          </router-link>
          <div class="info">
            <h2 class="title">
              {{book.title}}
              <div class="close" @click="delCartBook(book)">
                <svg
                  viewBox="19 19 22 22"
                  stroke-linecap="round"
                  width="10"
                  height="10"
                  stroke="rgb(170, 170, 170)"
                >
                  <g transform="translate(21.000000, 21.000000)">
                    <path d="M0.333333333,0.333333333 L17.4148373,17.4148373" />
                    <path
                      d="M0.333333333,0.333333333 L17.4148373,17.4148373"
                      transform="translate(9.000000, 9.000000) scale(-1, 1) translate(-9.000000, -9.000000)"
                    />
                  </g>
                </svg>
              </div>
            </h2>
            <div class="desc" @click="changeAppearance(book)">
              <span
                class="text"
                :class="{appearances:getBookAppearances(book).length > 1,new:book.appearance == appearance_new}"
              >
                {{book.appearance == appearance_new ? "全新品" : book.appearance == appearance_good ? "品相良好" : "品相中等"}}
                <svg
                  class="icon"
                  style="width: 1em; height: 1em;vertical-align: middle;fill: rgb(#333333);overflow: hidden;"
                  viewBox="0 0 1024 1024"
                  version="1.1"
                  xmlns="http://www.w3.org/2000/svg"
                  p-id="1817"
                  v-if="getBookAppearances(book).length > 1"
                >
                  <path d="M320 384h384l-192 256z" p-id="1818" />
                </svg>
              </span>
            </div>
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
                  :class="bookDetaile.chooseAppearance == el ? 'select' : ''"
                  v-for="(el,index) in bookDetaile.appearances"
                  :key="index"
                  @click="bookDetaile.chooseAppearance = el"
                >
                  <span class="price">￥{{parseInt(bookDetaile.price[index]).toFixed(2)}}</span>
                  <span class="appearances-text" :class="el == '全新品' ? 'new':''">{{el}}</span>
                </div>
              </div>
              <div class="choose" @click="commitChange(bookDetaile)">确定</div>
            </van-popup>
            <div class="condition">
              <div class="price">￥{{parseInt(book.price).toFixed(2)}}</div>
              <div class="lock">锁定</div>
            </div>
          </div>
        </div>
      </div>
      <div
        class="cart-empty"
        style="position: absolute;display: flex;justify-content: center;align-items: center;height: 100%;width: 100%;"
        v-if="sellingCart.length == 0"
      >
        <div
          class="cart-empty-content"
          style="display: flex;flex-direction: column;justify-content: center;align-items: center;"
        >
          <svg width="83.5" height="95.5" viewBox="0 0 167 191" style="margin-bottom: 12px;">
            <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
              <g transform="translate(-288.000000, -420.000000)">
                <g transform="translate(292.000000, 424.000000)">
                  <g transform="translate(14.037736, 7.259259)">
                    <path
                      d="M1.36936505,50.4965818 C-0.900049458,34.0826294 10.6973928,20.7764918 27.2604547,20.7764918 L122.496965,20.7764918 C139.065633,20.7764918 150.657378,34.0832866 148.388055,50.4965818 L141.082635,103.334356 C138.81322,119.748309 123.535476,133.054446 106.970056,133.054446 L42.7873638,133.054446 C26.2169211,133.054446 10.9441084,119.747651 8.67478476,103.334356 L1.36936505,50.4965818 Z"
                      fill="#DFDFDF"
                    />
                    <ellipse
                      fill="#DFDFDF"
                      cx="24.3041402"
                      cy="163.89492"
                      rx="15.5236966"
                      ry="15.5941603"
                    />
                    <ellipse
                      fill="#DFDFDF"
                      cx="131.662758"
                      cy="163.89492"
                      rx="15.5236966"
                      ry="15.5941603"
                    />
                    <path
                      d="M5.56703272,49.1760478 C5.56703272,49.1760478 5.89052681,49.3987668 1.18642225,22.8018908 C-1.5044529,10.3752944 1.18642225,3.19744231e-14 16.0051854,3.19744231e-14 L63.9836433,3.19744231e-14"
                      stroke="#DFDFDF"
                      stroke-width="8"
                      stroke-linecap="round"
                    />
                  </g>
                  <g transform="translate(0.000000, 0.118908)" stroke="#4A4A4A" stroke-width="8">
                    <path
                      d="M5.33167223,49.948748 C3.39491923,35.9408304 13.1223503,24.7764918 27.2604547,24.7764918 L122.496965,24.7764918 C136.638354,24.7764918 146.362727,35.9391879 144.425747,49.948748 L137.120328,102.786522 C135.124732,117.220028 121.539862,129.054446 106.970056,129.054446 L42.7873638,129.054446 C28.2145966,129.054446 14.6328787,117.221412 12.6370919,102.786522 L5.33167223,49.948748 L5.33167223,49.948748 Z"
                    />
                    <ellipse cx="24.3041402" cy="163.89492" rx="15.5236966" ry="15.5941603" />
                    <ellipse cx="131.662758" cy="163.89492" rx="15.5236966" ry="15.5941603" />
                    <path
                      d="M5.04589844,48.0383182 C5.04589844,48.0383182 3.51757812,38.386951 1.18642225,22.8018908 C-0.997070313,9.76976349 1.18642225,-3.19744231e-14 16.0051854,-3.19744231e-14 L63.9836433,-3.19744231e-14"
                      stroke-linecap="round"
                    />
                  </g>
                  <path
                    d="M43.9748428,102.52109 C43.9748428,90.8745717 54.8848885,76.8421053 73.7318384,76.8421053 C91.1921924,76.8421053 104.804952,89.0477488 104.804952,102.52109"
                    stroke="#4A4A4A"
                    stroke-width="8"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                  <ellipse
                    fill="#4A4A4A"
                    cx="57.8742138"
                    cy="55.5087719"
                    rx="7.48427673"
                    ry="7.49122807"
                  />
                  <ellipse
                    fill="#4A4A4A"
                    cx="89.9496855"
                    cy="55.5087719"
                    rx="7.48427673"
                    ry="7.49122807"
                  />
                </g>
              </g>
            </g>
          </svg>
          <div class="cart-empty-ps">购物车是空的，</div>
          <div class="cart-empty-go">去首页添加喜欢的书籍吧</div>
        </div>
      </div>
    </div>
    <div class="navs" v-if="currentTab == 'all'">
      <div class="settle" v-if="currentTab == 'all'">
        <div class="selected">
          <div class="checkbox" :class="{checked:seletedCount == sellingCart.length}">
            <svg
              width="14.5"
              height="11"
              viewBox="11 14 29 22"
              stroke="#FFFFFF"
              stroke-width="4"
              fill="none"
              @click="selectAll()"
            >
              <polyline points="13.2427972 23.7361617 21.8111153 32.3044798 38 16.1155951" />
            </svg>
          </div>
          <span class="cart-count">{{seletedCount == 0 ? '全选' : '已选 '+seletedCount}}</span>
        </div>
        <div class="text">
          <div class="price">￥{{price.toFixed(2)}}</div>
          <div class="desc" v-if="price - 99 <= 0">运费 ￥9 再买 ￥{{99 - price}} 包邮</div>
        </div>
        <router-link to="/cart/checkout" class="submit" v-if="sellingCart.length > 0">结算</router-link>
        <div class="submit" style="opacity: .3" v-if="sellingCart.length == 0">结算</div>
      </div>
    </div>
    <router-link class="back" to="/">
      <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 22 22">
        <path
          fill="none"
          stroke="#fff"
          stroke-width="1.5"
          d="M19.022 10.252v7.64a3 3 0 0 1-3 3H5.66a3 3 0 0 1-3-3v-7.676C.582 9.8.393 8.267 2.424 6.429l4.212-3.814c2.378-2.153 6.226-2.16 8.612 0L19.46 6.43c2.088 1.89 1.825 3.466-.438 3.823zM7.76 20.865h6.364v-4.327c0-1.11-.711-2.005-1.59-2.005H9.35c-.878 0-1.59.898-1.59 2.005v4.327z"
        />
      </svg>
    </router-link>
  </div>
</template>

<script>
import moment from "moment";
import Axios from "axios";
import { request } from "http";
export default {
  data() {
    return {
      currentTab: "all",
      sellingCart: [],
      shortageCart: [],
      appearances: [],
      showAppearances: false,
      bookDetaile: {},

      appearance_new: 0,
      appearance_good: 1
    };
  },
  methods: {
    async getCartSellingBook() {
      await Axios.get("/cart/selling").then(res => {
        this.sellingCart = [];
        if (res.data.data) {
          this.sellingCart = res.data.data;
          this.getAppearances();
        }
      });
    },
    async getCartShortageBook() {
      await Axios.get("/cart/shortage").then(res => {
        this.shortageCart = [];
        if (res.data.data) {
          this.shortageCart = res.data.data;
          this.getAppearances();
        }
      });
    },
    async delCartBook(book) {
      await Axios.delete("/cart/" + book.bookId).then(res => {
        this.getCartSellingBook();
        this.getCartShortageBook();
      });
    },
    async select(book) {
      book.selection = !Boolean(book.selection);
      let requestData = this.$qs.stringify({
        bookId: book.bookId,
        appearance: book.appearance,
        selection: Number(book.selection)
      });
      await Axios({
        method: "patch",
        url: "/cart",
        data: requestData
      }).then(res => this.getCartSellingBook());
    },
    async selectAll() {
      await Axios.patch("/cart/selectAll").then(res =>
        this.getCartSellingBook()
      );
    },
    async getAppearances() {
      let arr = ["全新品", "品相良好", "品相中等"];
      await Axios.get("/cart/appearance").then(res => {
        this.appearances = [];
        this.sellingCart.forEach(book => {
          res.data.data.forEach(temp => {
            if (temp.bookId == book.bookId && temp.stock > 0) {
              temp.appearance = arr[temp.appearance];
              this.appearances.push(temp);
            }
          });
        });
      });
    },
    getBookAppearances(book) {
      return this.appearances
        .filter(temp => temp.bookId == book.bookId)
        .map(temp => temp.appearance);
    },
    getBookPrices(book) {
      return this.appearances
        .filter(temp => temp.bookId == book.bookId)
        .map(temp => temp.price);
    },
    changeAppearance(book) {
      let arr = ["全新品", "品相良好", "品相中等"];
      if (this.getBookAppearances(book).length > 1) {
        this.bookDetaile = {
          bookId: book.bookId,
          title: book.title,
          price: this.getBookPrices(book),
          appearances: this.getBookAppearances(book),
          chooseAppearance: arr[book.appearance]
        };
        this.showAppearances = true;
      }
    },
    commitChange(book) {
      let arr = ["全新品", "品相良好", "品相中等"];
      let requestData = this.$qs.stringify({
        bookId: this.bookDetaile.bookId,
        appearance: arr.findIndex(
          temp => temp == this.bookDetaile.chooseAppearance
        ),
        selection: 2
      });
      Axios({
        method: "patch",
        url: "/cart",
        data: requestData
      }).then(res => {
        this.getCartSellingBook();
        this.getAppearances();
      });
      this.showAppearances = false;
    }
  },
  created() {
    this.getCartShortageBook();
    this.getCartSellingBook();
    this.getAppearances();
  },
  computed: {
    selectCount() {
      return this.sellingCart.filter(book => book.selection == 1).length;
    },
    price() {
      let num = 0;
      this.sellingCart.forEach(book => {
        if (book.selection == 1) {
          num += parseInt(book.price);
        }
      });
      return num;
    },
    seletedCount() {
      return this.sellingCart.filter(book => book.selection == 1).length;
    }
  }
};
</script>

<style lang="scss">
@import "../../assets/scss/cart/cart.scss";
</style>
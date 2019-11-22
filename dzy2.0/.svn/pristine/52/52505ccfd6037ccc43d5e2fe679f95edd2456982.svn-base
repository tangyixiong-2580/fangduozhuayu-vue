<template>
  <div class="sellingbooks" style="margin:0px; background-color:#ffffff;">
    <el-dialog :visible.sync="ManualInput" title="手动输入条码号" center class="input-wrapper">
      <div class="modal-desc">
        <div class="desc-context">
          <div class="context-center">
            <span>13 或 10 位 ISBN 条码，不含 - 符号</span>
            <span>或多抓鱼的 dzy 开头的条码</span>
          </div>
          <div style="text-align:center">
            <svg width="152px" height="83px" viewBox="0 0 279 150" version="1.1">
              <g id="Page-2" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                <g id="Group-2">
                  <rect id="Rectangle-20" fill="#FDEDAE" x="0" y="133" width="279" height="17" />
                  <text
                    id="9-781449-063665"
                    font-family="HelveticaNeue-Light, Helvetica Neue"
                    font-size="22"
                    font-weight="300"
                    letter-spacing="5.86000013"
                    fill="#333333"
                  >
                    <tspan x="1" y="149">9 781449 06366</tspan>
                    <tspan x="242.056002" y="149">5</tspan>
                  </text>
                  <g
                    id="Group-13"
                    transform="translate(19.000000, 0.000000)"
                    fill-rule="nonzero"
                    fill="#000000"
                  >
                    <rect
                      id="Rectangle-path"
                      x="4.67484663"
                      y="0"
                      width="1.9751714"
                      height="136.009995"
                    />
                    <rect id="Rectangle-path" x="0" y="0" width="1.9751714" height="136.009995" />
                    <rect
                      id="Rectangle-path"
                      x="121.546012"
                      y="0"
                      width="1.9751714"
                      height="136.009995"
                    />
                    <rect id="Rectangle-path" x="126" y="0" width="1.9751714" height="136.009995" />
                    <rect
                      id="Rectangle-path-Copy"
                      x="240"
                      y="0"
                      width="1.9751714"
                      height="136.009995"
                    />
                    <rect
                      id="Rectangle-path-Copy"
                      x="244"
                      y="0"
                      width="1.9751714"
                      height="136.009995"
                    />
                    <rect
                      id="Rectangle-path"
                      x="12.4662577"
                      y="0"
                      width="10.5006794"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="59.2147239"
                      y="0"
                      width="12.4346538"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="109.079755"
                      y="0"
                      width="6.21847124"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="29.607362"
                      y="0"
                      width="2.5519306"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="49.8650307"
                      y="0"
                      width="2.5519306"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="85.7055215"
                      y="0"
                      width="2.5519306"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="77.9141104"
                      y="0"
                      width="2.55650805"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="38.9570552"
                      y="0"
                      width="4.78801687"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="98.1717791"
                      y="0"
                      width="4.78801687"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="134.01227"
                      y="0"
                      width="10.5006794"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="180.760736"
                      y="0"
                      width="12.4346538"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="230.625767"
                      y="0"
                      width="6.21847124"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="151.153374"
                      y="0"
                      width="2.5519306"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="171.411043"
                      y="0"
                      width="2.5519306"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="207.251534"
                      y="0"
                      width="2.5519306"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="199.460123"
                      y="0"
                      width="2.55650805"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="160.503067"
                      y="0"
                      width="4.78801687"
                      height="124.362559"
                    />
                    <rect
                      id="Rectangle-path"
                      x="219.717791"
                      y="0"
                      width="4.78801687"
                      height="124.362559"
                    />
                  </g>
                </g>
              </g>
            </svg>
          </div>
          <div class="input-wrapper">
            <input class="input-isbn" placeholder="在这输入..." v-model="isbn" />
          </div>
          <div
            class="inputfales"
            style="display:none"
          >格式错误，ISBN 最后一位可以是字母 X。多抓鱼条码以 dzy 开头 13 位，请重新输入</div>
        </div>
      </div>
      <span slot="footer" style="padding:0px">
        <button type="primary" @click="commitIsbn" class="commitIsbn">确认</button>
      </span>
    </el-dialog>

    <el-dialog
      style="-webkit-tap-highlight-color: transparent;"
      custom-class="border-radius"
      title="提交前请确认"
      :visible.sync="showRules"
      width="85%"
      center
      modal
      :show-close="false"
    >
      <span>以下几种情况会被拒收，请不要寄出：</span>
      <ul>
        <li>
          <div class="content">
            <div class="point"></div>
            <span>有馆藏类印章或标签的书</span>
          </div>
        </li>
        <li>
          <div class="content">
            <div class="point"></div>
            <span>被写过的习题册</span>
          </div>
        </li>
        <li>
          <div class="content">
            <div class="point"></div>
            <span>主要附件缺失的书</span>
          </div>
        </li>
        <li>
          <div class="content">
            <div class="point"></div>
            <span>音像制品</span>
          </div>
        </li>
        <li>
          <div class="content">
            <div class="point"></div>
            <span>品相差到影响阅读的书</span>
          </div>
        </li>
      </ul>
      <router-link class="rule" to="/support/condition" style="text-decoration: none;">
        查看更多审核规则
        <svg
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          stroke-width="2"
          stroke-linecap="round"
          stroke-linejoin="round"
          xmlns="http://www.w3.org/2000/svg"
          class="Icon"
        >
          <polyline points="9 18 15 12 9 6" />
        </svg>
      </router-link>
      <span slot="footer" style="padding:0px">
        <div class="choice">
          <div class="return">
            <span @click="showRules = false" class="return-text">返回</span>
          </div>
          <div>
            <router-link to="/sell/order" class="check">确认下单</router-link>
          </div>
        </div>
      </span>
    </el-dialog>

    <el-dialog
      title="拒书规则更新"
      :visible.sync="showUnreceiveRules"
      width="85%"
      center
      :show-close="false"
    >
      <span>新增了书籍拒收的类型：</span>
      <ul>
        <li>
          <div class="content">
            <div class="point"></div>
            <span>馆藏类印章或标签会拒收</span>
          </div>
        </li>
        <li>
          <div class="content">
            <div class="point"></div>
            <span>被写过的习题册会拒收</span>
          </div>
        </li>
      </ul>
      <router-link class="rule" to="/support/condition" style="text-decoration: none;">
        查看更多审核规则
        <svg
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          stroke-width="2"
          stroke-linecap="round"
          stroke-linejoin="round"
          xmlns="http://www.w3.org/2000/svg"
          class="Icon"
        >
          <polyline points="9 18 15 12 9 6" />
        </svg>
      </router-link>
      <span slot="footer" style="padding:0px">
        <div class="check" @click="showUnreceiveRules = false">好的</div>
      </span>
    </el-dialog>

    <div :style="showUnreceiveRules || showRules || ManualInput ? 'filter: blur(5px)':''">
      <div class="notice" @click="showUnreceiveRules = true">
        <div class="regulation">规则更新：有馆藏类印章或标签的书拒收</div>
        <div style="flex:1"></div>
        <svg
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          stroke-width="2"
          stroke-linecap="round"
          stroke-linejoin="round"
          xmlns="http://www.w3.org/2000/svg"
          class="Icon"
        >
          <polyline points="9 18 15 12 9 6" />
        </svg>
      </div>
    </div>
    <div
      style="background-color:#ffffff;"
      :style="showUnreceiveRules || showRules || ManualInput ? 'filter: blur(5px)':''"
    >
      <div class="tosellbooks" v-for="(g,index) of unsoldBooksReceive" :key="index">
        <div>
          <img :src="'https://images.weserv.nl/?url='+g.pic" width="50px" height="70px" />
        </div>
        <div class="particular">
          <div class="book-content" style="margin-bottom: 14px">
            <div class="book-name">
              <div class="title">{{g.title}}</div>
              <svg
                @click="remove(g.isbn13)"
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
            <div style="display: flex;">
              <div class="writer">{{g.author}}</div>
            </div>
          </div>
          <div style="margin-bottom:0px">
            <div class="condition">
              <div style="line-height: 22px;">
                <svg
                  viewBox="0 0 24 24"
                  fill="none"
                  stroke="rgb(170, 170, 170)"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  xmlns="http://www.w3.org/2000/svg"
                  class="Icon"
                  width="13"
                  height="13"
                >
                  <polyline points="6 9 12 15 18 9" />
                </svg>
              </div>
              <div class="conditionsas">品相好可卖</div>
              <div
                style="font-size: 16px;margin: 0px 2px 0px 4px;font-weight: 100"
              >￥{{g.highestPrice.toFixed(2)}}</div>
              <div class="discounta">{{g.discount}} 折</div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div
      style="height:20px; background-color:#F1F1F1;"
      v-if="unsoldBooksUnReceive.length > 0"
    >&ensp;</div>
    <div class="nocharge" v-if="unsoldBooksUnReceive.length > 0">
      <div>以下书暂时不收</div>
      <div class="inform">收购时会通知你</div>
    </div>
    <div
      style="background-color:#ffffff; height:100%"
      :style="showUnreceiveRules || showRules || ManualInput ? 'filter: blur(5px)':''"
      v-for="(g,index) of unsoldBooksUnReceive"
      class="boocover"
      :key="index"
    >
      <div>
        <img :src="'https://images.weserv.nl/?url='+g.pic" width="50px" height="70px" />
      </div>
      <div class="matter">
        <div style="display: flex; justify-content:space-between; align-items:center;">
          <div class="title">{{g.title}}</div>
          <svg
            @click="remove(g.isbn13)"
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
        <div style="display: flex;">
          <div class="writer">{{g.author}}</div>
        </div>
        <div style="display: flex;justify-content:flex-end;margin-top:10px">
          <div class="feedback" @click="feedback = !feedback">{{feedback ? "已反馈" : "一键反馈"}}</div>
        </div>
      </div>
    </div>
    <router-link
      to="/support/problems"
      class="regulations"
      style="margin-bottom:120px"
      :style="showUnreceiveRules || showRules || ManualInput ? 'filter: blur(5px)':''"
    >
      <div>了解更多卖书规则</div>
      <div>
        <svg
          viewBox="0 0 24 24"
          fill="none"
          stroke="currentColor"
          stroke-width="2"
          stroke-linecap="round"
          stroke-linejoin="round"
          xmlns="http://www.w3.org/2000/svg"
          class="Icon"
        >
          <polyline points="9 18 15 12 9 6" />
        </svg>
      </div>
    </router-link>

    <div
      class="Fixed"
      :style="showUnreceiveRules || showRules || ManualInput ? 'filter: blur(5px)':''"
    >
      <div class="scanaQRcode">
        <div class="scancode">
          <div class="sasdaf">
            <div style="margin-right:10px">
              <svg
                viewBox="26 26 55 56"
                fill="none"
                stroke="#fff"
                stroke-width="3"
                stroke-linecap="round"
                class="SellPage-scanIcon"
              >
                <g transform="translate(28.000000, 28.000000)">
                  <path d="M25.5,15.3363636 L25.5,36.3363636" />
                  <path d="M36.0863392,25.5 L15.0863392,25.5" />
                  <path
                    d="M0,15.9363158 L0,7.51316586 C0,3.36375893 3.37157192,0 7.51176174,0 L15.0235235,0"
                  />
                  <path
                    d="M0,51.9363158 L0,43.5131659 C0,39.3637589 3.37157192,36 7.51176174,36 L15.0235235,36"
                    transform="translate(7.511762, 43.968158) scale(1, -1) translate(-7.511762, -43.968158)"
                  />
                  <path
                    d="M36,15.9363158 L36,7.51316586 C36,3.36375893 39.3715719,0 43.5117617,0 L51.0235235,0"
                    transform="translate(43.511762, 7.968158) scale(-1, 1) translate(-43.511762, -7.968158)"
                  />
                  <path
                    d="M36,51.9363158 L36,43.5131659 C36,39.3637589 39.3715719,36 43.5117617,36 L51.0235235,36"
                    transform="translate(43.511762, 43.968158) scale(-1, -1) translate(-43.511762, -43.968158)"
                  />
                </g>
              </svg>
              <g transform="translate(28.000000, 28.000000)">
                <path d="M25.5,15.3363636 L25.5,36.3363636"></path>
                <path d="M36.0863392,25.5 L15.0863392,25.5"></path>
                <path
                  d="M0,15.9363158 L0,7.51316586 C0,3.36375893 3.37157192,0 7.51176174,0 L15.0235235,0"
                ></path>
                <path
                  d="M0,51.9363158 L0,43.5131659 C0,39.3637589 3.37157192,36 7.51176174,36 L15.0235235,36"
                  transform="translate(7.511762, 43.968158) scale(1, -1) translate(-7.511762, -43.968158)"
                ></path>
                <path
                  d="M36,15.9363158 L36,7.51316586 C36,3.36375893 39.3715719,0 43.5117617,0 L51.0235235,0"
                  transform="translate(43.511762, 7.968158) scale(-1, 1) translate(-43.511762, -7.968158)"
                ></path>
                <path
                  d="M36,51.9363158 L36,43.5131659 C36,39.3637589 39.3715719,36 43.5117617,36 L51.0235235,36"
                  transform="translate(43.511762, 43.968158) scale(-1, -1) translate(-43.511762, -43.968158)"
                ></path>
              </g>
            </div>
            <div class="qwss">扫码卖书</div>
          </div>
        </div>
        <div class="scancoq">
          <div class="sasdaf">
            <div>
              <svg width="16" viewBox="0 0 39 48" class="SellPage-typeIcon">
                <g
                  stroke="#9B9B9B"
                  stroke-width="3"
                  fill="none"
                  fill-rule="evenodd"
                  transform="translate(20, -2) rotate(-330.000000)"
                >
                  <path
                    d="M21.5,39.203037 L14.6414479,46.2497686 C12.9140854,48.0245251 10.1304164,48.0300921 8.40417551,46.2641419 L1.5,39.2011472 L1.5,6.00343961 C1.5,3.51519721 3.51289404,1.5 5.99793199,1.5 L17.002068,1.5 C19.4852269,1.5 21.5,3.51702964 21.5,6.00343961 L21.5,39.203037 Z"
                  />
                  <path d="M1.64285714,38.59375 L21.6982,38.59375" />
                </g>
              </svg>
            </div>
            <div class="qwsa" @click="ManualInput = true">手动输入</div>
          </div>
        </div>
      </div>
      <div class="payment">
        <div class="paymentsa">
          <div style="display: flex;align-items: center;margin-left: 4px;font-size: 14px;">
            <div class="one">{{unsoldBooksReceive.length}}</div>
            <div class="one2">本 最高可卖</div>
            <div
              style="font-size: 20px; color: rgb(242, 129, 129);margin-left: -4px;"
            >￥{{totalPrice.toFixed(2)}}</div>
          </div>
          <div style="display: flex;" class="asws">
            <div class="section">
              预估价格区间￥{{minimumPrice.toFixed(2)}}~￥{{totalPrice.toFixed(2)}}
              <router-link
                class="asa"
                style="margin-left: 3px; line-height: 0;"
                to="/support/condition"
              >
                <span>
                  <svg
                    viewBox="0 0 24 24"
                    fill="none"
                    stroke="currentColor"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    xmlns="http://www.w3.org/2000/svg"
                    class="Icon"
                    height="12"
                  >
                    <circle cx="12" cy="12" r="10" />
                    <line x1="12" y1="16" x2="12" y2="12" />
                    <line x1="12" y1="8" x2="12" y2="8" />
                  </svg>
                </span>
              </router-link>
            </div>
          </div>
        </div>

        <div class="nextstep" @click="checkOrder">下一步</div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "sellingbooks",
  data() {
    return {
      showUnreceiveRules: false,
      showRules: false,
      count: 0,
      unsoldBooksReceive: [],
      unsoldBooksUnReceive: [],
      isbn: "",
      ManualInput: false,
      feedback: false,
      totalPrice: 0,
      minimumPrice: 0,
      userId: 0
    };
  },
  created() {
    this.loadUnsoldBooks();
  },
  methods: {
    async remove(isbn13) {
      await axios.delete("/book/unsold/cancel/isbn/" + isbn13);
      this.loadUnsoldBooks();
    },
    async loadUnsoldBooks() {
      await axios.get("/book/unsold").then(res => {
        if (res.data.data) {
          console.info(res.data.data);
          this.unsoldBooksReceive = res.data.data;
          this.totalPrice = 0;
          this.minimumPrice = 0;
          res.data.data.map(book => {
            this.totalPrice += book.highestPrice;
            this.minimumPrice += book.lowestPrice;
          });
        }
      });
      await axios.get("/book/unsold/refused").then(res => {
        if (res.data.data) {
          this.unsoldBooksUnReceive = res.data.data;
        }
      });

      if (
        this.unsoldBooksReceive.length == 0 &&
        this.unsoldBooksUnReceive.length == 0
      ) {
        this.$router.replace({ path: "/sellSynopsis" });
      }
    },
    async commitIsbn() {
      if (this.isbn.length != 10 && this.isbn.length != 13) {
        document.getElementsByClassName("inputfales")[0].style.display =
          "block";
        return;
      }

      await axios
        .post("/book/unsold/isbn?isbn=" + this.isbn)
        .then(res => (this.isbn = ""));
      this.ManualInput = false;
      this.loadUnsoldBooks();
    },
    checkOrder() {
      if (this.totalPrice < 20) {
        this.$notify.error({
          title: "tips",
          message: "继续添加书籍,总价20元即可下单"
        });
        return;
      }
      this.showRules = true;
    }
  }
};
</script>

<style lang="scss">
@import "../../assets/scss/sellBook/sell.scss";
</style>



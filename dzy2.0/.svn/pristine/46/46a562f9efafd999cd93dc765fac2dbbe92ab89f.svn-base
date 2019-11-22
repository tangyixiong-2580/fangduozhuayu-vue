<template>
  <div class="look">
    <router-link tag="div" class="clickHome" :to="{ path: '/' }">
      <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 22 22">
        <path
          fill="none"
          stroke="#fff"
          stroke-width="1.5"
          d="M19.022 10.252v7.64a3 3 0 0 1-3 3H5.66a3 3 0 0 1-3-3v-7.676C.582 9.8.393 8.267 2.424 6.429l4.212-3.814c2.378-2.153 6.226-2.16 8.612 0L19.46 6.43c2.088 1.89 1.825 3.466-.438 3.823zM7.76 20.865h6.364v-4.327c0-1.11-.711-2.005-1.59-2.005H9.35c-.878 0-1.59.898-1.59 2.005v4.327z"
        />
      </svg>
    </router-link>

    <!-- <div class="F"> -->
    <div class="examine" v-if="!state">
      <div class="examine-left">
        <div
          class="examine-message"
          v-show="state === false"
          v-for="(status,index) of orderStatus"
          :key="index"
        >
          <div class="content-wrapper" v-if="index != orderStatus.length-1">
            <div class="line">
              <div class="point"></div>
              <span class="xian"></span>
            </div>
            <div class="content">
              <div class="header">{{status}}</div>
              <div class="date">
                <span>2019-8-6 14:39</span>
              </div>
            </div>
          </div>
          <div
            class="content-wrapper-last"
            v-if="index == orderStatus.length-1"
            style="margin-top: -5px"
          >
            <div class="line">
              <div class="point"></div>
            </div>
            <div class="content">
              <div class="header">{{status}}</div>
            </div>
          </div>
        </div>
      </div>
      <div class="examine-right" v-if="!state">
        <div class="examine-button">
          <svg
            viewBox="0 0 24 24"
            fill="none"
            stroke="rgb(170, 170, 170)"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            xmlns="http://www.w3.org/2000/svg"
            class="Icon"
            v-if="state === false"
            @click.prevent.stop="state = !state"
          >
            <polyline points="18 15 12 9 6 15" />
          </svg>

          <span
            v-show="state == true"
            class="examine-detail"
            @click.prevent.stop="state = !state"
          >查看详情</span>
        </div>
      </div>
    </div>

    <div class="examine-last" v-if="state">
      <div class="examine-last-left">
        <div class="line">
          <span class="xian"></span>
          <div class="point"></div>
        </div>
        <div class="content">
          <div class="header">{{orderStatus[orderStatus.length - 1]}}</div>
        </div>
      </div>
      <div class="examine-last-right">
        <div class="examine-button">
          <svg
            viewBox="0 0 24 24"
            fill="none"
            stroke="rgb(170, 170, 170)"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            xmlns="http://www.w3.org/2000/svg"
            class="Icon"
            v-if="state === false"
            @click.prevent.stop="state = !state"
          >
            <polyline points="18 15 12 9 6 15" />
          </svg>

          <span
            v-show="state == true"
            class="examine-detail"
            @click.prevent.stop="state = !state"
          >查看详情</span>
        </div>
      </div>
    </div>

    <!-- 优惠卷 -->
    <div class="imgMVP">
      <div class="imgmvp">
        <img
          src="https://asset.duozhuayu.com/invitation/stage2/coupon_order_20.png"
          height="78px"
          width="100%;"
        />
      </div>
    </div>

    <div class="information-m">
      <div class="heads">
        <!-- <div class="text">共{{orderData.books.length}}本</div> -->
      </div>
      <div class="information-book" v-for="(book,index) in orderData.books" :key="index">
        <img :src="'https://images.weserv.nl/?url='+book.pic" width="50px" height="70px" />
        <div class="right">
          <div class="title">{{book.title}}</div>
          <div class="scen">
            <div class="text">{{book.author}}</div>
            <span class="money">￥{{(book.price * 0.3).toFixed(2)}}</span>
          </div>
        </div>
      </div>
      <div class="books-s">
        <div class="book-z">
          <div class="book-i">
            <div class="text">最高可卖</div>
            <span class="money">￥{{heightMoney}}</span>
          </div>
          <div class="money-in">
            <div class="text">运费</div>
            <span class="money">￥0.00</span>
          </div>
        </div>
      </div>
      <div class="books-ms">
        <div class="books-top">
          <div class="text">最高可卖</div>
          <span class="money">￥{{heightMoney}}</span>
        </div>
        <div class="books-bom">
          <div class="text">预估价格区间</div>
          <span class="money">￥{{lowMoney}}</span>
          <span class="XIAN">~</span>
          <span class="money">￥{{heightMoney}}</span>
          <router-link class="imgsvg" to="/support/condition">
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
          </router-link>
        </div>
      </div>
    </div>

    <div class="consigner-centre">
      <div class="serial">
        <div class="name">订单编号</div>
        <div class="text">{{orderData.orderId}}</div>
        <button class="copy">复制</button>
      </div>
      <div class="person">
        <div class="name">发货人</div>
        <div class="text">{{orderData.mailingName}}</div>&ensp;
        <div class="text">{{orderData.mailingPhone}}</div>
      </div>
      <div class="parcel">
        <div class="name">取件地址</div>
        <div class="text">{{orderData.mailingAddress}}</div>&ensp;
        <div class="text">{{orderData.detailedAddress}}</div>
      </div>
    </div>
    <div class="relation">
      <div class="relation-owd">
        <button class="relation-owd-os">
          <div class="service">联系客服</div>
        </button>
        <button class="relation-owd-os" v-if="orderStatus.length <= 2">
          <div class="service" @click="cancelOrder()">取消订单</div>
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import Axios from "axios";
export default {
  data() {
    return {
      state: true,
      orderId: "",
      orderData: [],
      orderStatus: [],
      lowMoney: 0,
      heightMoney: 0
    };
  },
  methods: {
    // 发送请求
    async commitOrder() {
      await Axios.get("/order/orderInfo?orderId=" + this.orderId).then(res => {
        this.orderData = res.data.data;
        let stauts = [
          "已下单",
          "待安排快递",
          "快递取书",
          "待收货",
          "待审核",
          "已审核打款",
          "已完成",
          "已取消"
        ];

        for (let i = 0; i <= res.data.data.orderStatus - 1; i++) {
          this.orderStatus.push(stauts[i]);
          if (res.data.data.orderStatus == 1) {
            this.orderStatus.push(stauts[++i]);
          }
          if (res.data.data.orderStatus == 2 && i == 1) {
            this.orderStatus.push(stauts[stauts.length - 1]);
          }
        }

        res.data.data.books.forEach(book => {
          this.lowMoney += book.lowestPrice;
          this.heightMoney += book.highestPrice;
        });
        this.lowMoney = this.lowMoney.toFixed(2);
        this.heightMoney = this.heightMoney.toFixed(2);
      });
    },
    async cancelOrder() {
      if (this.orderStatus > 2) {
        this.$message.error("快递已上门取书,无法取消");
        return;
      } else if (this.orderStatus == 3) {
        this.$message.error("该订单已是取消状态");
        return;
      }
      await Axios.patch("/order/cancel?orderId=" + this.orderId).then(res => {
        this.$router.push({ path: "/orders" });
      });
    }
  },
  // 接受订单列表发过来的参数
  created() {
    this.orderId = this.$route.query.orderId;
    this.commitOrder();
  }
};
</script>

<style lang="scss">
@import "../../assets/scss/mine/orderParticulars.scss";
</style>



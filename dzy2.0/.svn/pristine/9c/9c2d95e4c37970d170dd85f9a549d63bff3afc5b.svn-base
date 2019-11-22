<template>
  <div class="app">
    <div class="books-order" v-for="(order,index) of orders" :key="index">
      <div class="books-order-coding" @click="checkOrder(order)">
        <div class="title">卖书订单：{{order.orderId}}</div>
        <div class="cancel">
          <span>{{getOrderStatus(order)}}</span>
        </div>
      </div>
      <div class="meta">
        <div class="meta-text-wrap">
          <span>{{order.pic ? order.pic.length : "0"}} 个商品</span>
          <span class="meta-circle"></span>
          <span>{{order.transactionTime}}</span>
        </div>
        <div class="meta-line"></div>
      </div>
      <div class="photograph">
        <div v-for="(p,index) of order.pic" :key="index">
          <img :src="'https://images.weserv.nl/?url='+p" style="width:47.56px;height:67.55px;" />
        </div>
      </div>
      <div class="blank"></div>
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
import Axios from "axios";

export default {
  data() {
    return {
      orders: [],
      userId: 0
    };
  },
  created() {
    this.loadOrders();
  },
  methods: {
    async loadOrders() {
      await Axios.get("/order").then(res => {
        if (JSON.stringify(res.data.data) == "{}") {
          this.$router.push({ path: "/orders-none" });
        } else {
          this.orders = res.data.data;
        }
      });
    },
    checkOrder(order) {
      this.$router.push({
        path: "/orderParticulars",
        query: {
          orderId: order.orderId
        }
      });
    },
    getOrderStatus(order) {
      let status = [
        "已下单",
        "待安排快递",
        "已取消",
        "快递取书",
        "待收货",
        "待审核",
        "已审核打款",
        "已完成"
      ];
      let state = "";
      status.forEach((value, index) => {
        if (order.orderStatus == index) {
          state = value;
        }
      });
      return state;
    }
  }
};
</script>

<style lang="scss">
@import "../../assets/scss/mine/orders.scss";
</style>



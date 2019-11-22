<template>
  <div class="checkout-wrapper">
    <div class="fillout">
      <div class="title">
        <span>填写收货人信息</span>
      </div>
      <div class="rules">
        <span>使用中通 / EMS 等快递发货，了解具体发货规则？</span>
      </div>
      <div class="info">
        <div class="info-text">
          <span>姓名：</span>
          <input type="text" v-model="orderData.name" />
        </div>
        <div class="info-text">
          <span>电话：</span>
          <input type="text" v-model="orderData.phone" />
        </div>
        <div class="info-text">
          <span>地址：</span>
          <van-button @click="showAddr = true">{{orderData.addrInfo}}</van-button>
          <van-popup v-model="showAddr" position="bottom">
            <van-area
              :area-list="areaList"
              :columns-num="3"
              title="选择城市"
              :value="addrCode"
              @confirm="closeAddr"
              @cancel="showAddr = false"
            />
          </van-popup>
        </div>
        <div class="info-text">
          <span></span>
          <textarea class="Input" placeholder="详细地址，街道、小区、单元、门牌号" v-model="orderData.addrDetailed"></textarea>
        </div>
      </div>
    </div>

    <div class="demarcation"></div>

    <div class="anonymous">
      <div class="text">
        <span class="anonymous-buy">匿名买书</span>
        <span class="tips">开启后其他人不会知道你买了这些</span>
      </div>
      <div
        class="checkbox"
        :class="{checked:orderData.isAnonymous}"
        @click="orderData.isAnonymous = !orderData.isAnonymous"
      >
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
    </div>

    <div class="demarcation"></div>

    <div class="receipt">
      <div class="section-wrapper">
        <div class="section-content" v-for="(book,index) in cart" :key="index">
          <span class="section-left">{{book.title}}</span>
          <span class="section-right">￥{{parseInt(book.price).toFixed(2)}}</span>
        </div>
      </div>
      <div class="section-wrapper">
        <div class="section-content">
          <span class="section-left">总价</span>
          <span class="section-right">￥{{cartPrice.toFixed(2)}}</span>
        </div>
        <div class="section-content">
          <span class="section-left">运费（不参与优惠）</span>
          <span class="section-right">￥5.00</span>
        </div>
      </div>
      <div class="section-wrapper">
        <van-coupon-cell
          :coupons="coupons"
          :chosen-coupon="chosenCoupon"
          @click="showCoupon = true"
        />
        <van-popup v-model="showCoupon" position="bottom">
          <van-coupon-list
            :coupons="coupons"
            :chosen-coupon="chosenCoupon"
            :disabled-coupons="disabledCoupons"
            :show-exchange-bar="false"
            @change="changeCoupon"
          />
        </van-popup>
      </div>
      <div class="section-wrapper">
        <div class="section-content">
          <span class="section-left"></span>
          <div class="section-right">
            <span class="price-left">下单支付：</span>
            <span class="price-right">￥30.90</span>
          </div>
        </div>
      </div>
    </div>

    <div class="fixed">
      <div class="checkout-bar">
        <div @click="commitData">去支付</div>
      </div>
    </div>
  </div>
</template>

<script>
import Axios from "axios";
export default {
  data() {
    return {
      cart: [],
      cartPrice: 0,
      areaList: {
        province_list: {},
        city_list: {},
        county_list: {}
      },

      orderData: {
        cartId: "",
        name: "",
        phone: "",
        addrInfo: "广东省深圳市龙华区",
        addrDetailed: "",
        isAnonymous: false,
        couponId: 0,
        freightId: 0,
        totalPrice: 100
      },

      showAddr: false,
      addrCode: "440309",
      showCoupon: false,
      coupons: [
        {
          id: 100,
          available: 1,
          condition: "无使用门槛\n最多优惠12元",
          reason: "",
          value: 150,
          name: "优惠券名称",
          startAt: 1489104000,
          endAt: 1514592000,
          valueDesc: "1.5",
          unitDesc: "元"
        },
        {
          id: 200,
          available: 1,
          condition: "无使用门槛\n最多优惠12元",
          reason: "",
          value: 150,
          name: "优惠券名称",
          startAt: 1489104000,
          endAt: 1514592000,
          valueDesc: "1.5",
          unitDesc: "元"
        }
      ],
      disabledCoupons: [],
      chosenCoupon: -1
    };
  },
  methods: {
    async getCart() {
      await Axios.get("/cart/selling").then(res => {
        if (res.data.data) {
          this.cart = res.data.data;
          this.orderData.cartId = res.data.data[0].cartId;
          this.cart.forEach(temp => (this.cartPrice += parseInt(temp.price)));
        } else {
          this.$router.replace({ path: "/cart" });
        }
      });
    },
    async getArea() {
      await Axios.get("/order/area").then(res => {
        this.areaList.province_list = res.data.data.province_list[0];
        this.areaList.city_list = res.data.data.city_list[0];
        this.areaList.county_list = res.data.data.county_list[0];
      });
    },
    async commitData() {
      let requestData = this.$qs.stringify(this.orderData);
      console.info(this.orderData);
      // Axios({
      //   method: "post",
      //   url: "/order/buy",
      //   data: requestData
      // }).then(res => console.info(res.data));
    },
    async getFreight() {
      let requestData = this.$qs.stringify({
        addrCode: this.addrCode,
        price: this.cartPrice,
        freightId: this.orderData.freightId
      });
      await Axios({
        method: "get",
        url: "/addr/rule",
        data: requestData
      }).then(res => console.info(res.data));
    },
    closeAddr(value) {
      this.orderData.addrInfo = "";
      this.addrCode = value[value.length - 1].code;
      value.map(temp => (this.orderData.addrInfo += temp.name));
      this.showAddr = false;
      this.getFreight();
    },
    changeCoupon(index) {
      this.showCoupon = false;
      this.orderData.freightId = this.coupons[index].id;
      this.chosenCoupon = index;
    }
  },
  created() {
    this.getCart();
    this.getArea();
  }
};
</script>

<style lang="scss">
@import "@/assets/scss/cart/checkout.scss";
</style>

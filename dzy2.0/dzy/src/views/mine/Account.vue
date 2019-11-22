<template>
  <div id="rootk">
    <div class="sds" :style="rules ? 'filter: blur(5px)':''">
      <div class="about">
        <span class="balance">
          <div class="line"></div>
          <div style="padding:0 15px 0 15px">账户余额(元)</div>
          <div class="line"></div>
        </span>
        <div class="desc">{{sellFee}}</div>
        <div class="extract">
          <div class="extract-about">余额提现</div>
        </div>
        <div class="rule">
          <div class="rule-about">提现规则</div>
          <router-link class="rule-i" @click="ruleOpen()" style="margin-left: 3px">
            <span class="jsx-1838174039">
              <svg
                viewBox="0 0 24 24"
                fill="none"
                stroke="currentColor"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
                xmlns="http://www.w3.org/2000/svg"
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

    <router-link class="back" :style="rules ? 'filter: blur(5px)':''" to="/">
      <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 22 22">
        <path
          fill="none"
          stroke="#fff"
          stroke-width="1.5"
          d="M19.022 10.252v7.64a3 3 0 0 1-3 3H5.66a3 3 0 0 1-3-3v-7.676C.582 9.8.393 8.267 2.424 6.429l4.212-3.814c2.378-2.153 6.226-2.16 8.612 0L19.46 6.43c2.088 1.89 1.825 3.466-.438 3.823zM7.76 20.865h6.364v-4.327c0-1.11-.711-2.005-1.59-2.005H9.35c-.878 0-1.59.898-1.59 2.005v4.327z"
        />
      </svg>
    </router-link>

    <div class="rule-page" v-if="rules===true">
      <div class="rule-border" style="margin: 0px 2em;">
        <div class="context">
          <div class="context-desc">
            <p style="margin:0">· 微信提现最小额度为 1 元</p>
            <p style="margin:0">· 暂不支持部分提现</p>
          </div>
          <div class="oky" @click="ruleOpen()">好的</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Axios from "axios";
export default {
  data() {
    return {
      rules: false,
      sellFee: 0
    };
  },
  created() {
    this.loadAccount();
  },
  methods: {
    ruleOpen: function() {
      this.rules = !this.rules;
    },
    loadAccount() {
      Axios.get("/user").then(res => {
        this.sellFee = res.data.data.sellFee;
      });
    },
    formatIntSalary(num) {
      num = parseInt(num)
        .toString()
        .split(".");
      num[0] = num[0].replace(new RegExp("(\\d)(?=(\\d{3})+$)", "ig"), "$1,");
      return num.join(".");
    }
  }
};
</script>

<style lang="scss">
@import "../../assets/scss/mine/Moneys.scss";
</style>

<template>
  <div id="invitation">
    <div class="top">
      <div class="title">邀请新用户，得买书券</div>
      <img
        alt
        src="https://asset.duozhuayu.com/invitation/stage2/coupon_price_20.png"
        class="jsx-1457978917 coupon-price"
      />
    </div>
    <div class="content-wrapper">
      <div class="content">
        <div class="dot"></div>
        <div class="word">好友通过你的邀请链接或二维码领取买书券并成功下首单，订单完成后你将获得20元买书抵扣券</div>
      </div>
      <div class="content">
        <div class="dot"></div>
        <div>受邀好友也将获得 15 元新人买书抵扣券</div>
      </div>
      <div class="coupon">
        <img src="https://asset.duozhuayu.com/invitation/stage2/coupon_main_20.png" alt />
      </div>
      <div class="line">
        <div v-for="i in 20" :key="i">
          <div></div>
        </div>
      </div>
      <div class="send">
        <span>发邀请，得买书抵扣券</span>
      </div>
    </div>
    <div class="rule">
      <div class="title">
        <div class="dot left"></div>
        <div class="name">活动规则</div>
        <div class="dot right"></div>
      </div>
      <div class="specific">
        <div class="inner">
          <div class="dot"></div>
          <div>成功邀请到一位新注册用户下首单（卖书或买书）可获得一张 20 元的买书抵扣券，一位用户最多可通过邀请获得 10 张抵扣券。首次领券时需要绑定手机号，一个手机号对应一个账号。</div>
        </div>
        <div class="inner">
          <div class="dot"></div>
          <div>受邀的新注册用户绑定手机号后，即可获得一张 15 元新人买书抵扣券。未绑定手机号的新注册用户不计入邀请人数中。</div>
        </div>
        <div class="inner">
          <div class="dot"></div>
          <div>20 元买书抵扣券的发放时间为邀请的新注册用户的买书订单状态变更为「快递发货」，卖书订单状态变更为「已审核打款」。</div>
        </div>
        <div class="inner">
          <div class="dot"></div>
          <div>买书抵扣券均为满减券，20 元券为满 40 减 20，有效期 90 天。15 元券为满 30 减 15，有效期 2 天。（运费不参与满减）</div>
        </div>
        <div class="inner">
          <div class="dot"></div>
          <div>对于在邀请得券活动中出现使用多账号套取优惠券等作弊行为的账号，我们有权进行功能限制，包括但不限于禁用邀请得券功能、收回未使用的买书抵扣券等。</div>
        </div>
        <div class="inner">
          <div class="dot"></div>
          <div>参与邀请得券活动，即表示你同意我们的活动规则。多抓鱼对本活动有最终解释权。</div>
        </div>
      </div>
    </div>
    <router-link to="/cart">
      <span>傻逼</span>
    </router-link>
  </div>
</template>

<script>
export default {
  data() {
    return {
      code: 0,
      state: 0
    };
  },
  created() {
    isPc();
    if (!localStorage.getItem("token")) {
      this.$router.push({
        path:
          "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc3758a49f9d0e965&redirect_uri=http://192.168.6.226:8080/invitation&response_type=code&scope=snsapi_userinfo#wechat_redirect"
      });
    } else {
      this.code = this.$route.query.code;
      this.state = localStorage.getItem("token");
      this.login();
    }
  },
  methods: {
    async login() {
      await this.axios
        .get("/user/auth?code=" + this.code + "&state=" + this.state)
        .then(res => {
          this.$localStorage.set("token", res.data.data);
          this.$message.success("登录成功");
          this.$router.push({ path: "/invitation" });
        });
    },
    //判断是PC端还是移动端
    isPC(){
      var userAgentInfo = navigator.userAgent;
      console.info("userAgentInfo",userAgentInfo);
      var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");  
      var flag = true; 
      for (var v = 0; v < Agents.length; v++) {  
         if (userAgentInfo.indexOf(Agents[v]) > 0) { flag = false; break; }  
      }  
      console.info(flag);
      return flag;  
    }
  }
};
</script>

<style lang="scss">
@import "@/assets/scss/mine/invitation.scss";
</style>
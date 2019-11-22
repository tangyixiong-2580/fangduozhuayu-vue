<template>
  <div class="login">
    <div class="center">
      <div class="center-login">
        <div class="login-desc">
          <div class="login-header">注册登录</div>
          <div class="login-content" style="margin: 27px 0px 12px 0px">
            <div style="margin: 10px 20px ">
              <input
                style="width:100%"
                class="Input"
                placeholder="请输入手机号"
                v-model="authPhoneNumber"
              />
            </div>
            <div style="margin: 10px 20px ">
              <input class="Input" placeholder="请输入验证码" value v-model="authCode" />
              <button
                class="bluebt"
                style="display: inline-block;margin-left:12px"
                type="primary"
                @click="getCode()"
                :disabled="timer && timer > 0"
              >获取验证码&ensp; {{count > 0 ? count : ""}}</button>
            </div>
          </div>

          <div class="button-modal">
            <button class="button-ye" @click="login()">手机号码登录或注册</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

const TIME_COUNT = 60;
export default {
  data() {
    return {
      authPhoneNumber: "",
      authCode: "",
      phoneNumber: "",
      code: "",

      disabledBtn: false,
      timer: null,
      count: ""
    };
  },
  methods: {
    login() {
      if (
        !this.authPhoneNumber ||
        !/^1[3456789]\d{9}$/.test(this.authPhoneNumber)
      ) {
        this.$message.error("请填写正确的手机号");
        return;
      }
      axios
        .post(
          "/user/login/oldUser?phoneNum=" +
            this.authPhoneNumber +
            "&verification=" +
            this.authCode
        )
        .then(res => {
          let failCode = 250;
          let unLogin = 207;
          if (res.data.code == failCode || res.data.code == unLogin) {
            this.$message.error("验证码无效, 请确认后重新输入");
            return;
          }
          console.info(res);
          console.info("token:" + res.data.data);
          this.$localStorage.set("token", res.data.data);
          this.$router.replace({ path: "/users" });
        });
    },
    getCode() {
      if (
        !this.authPhoneNumber ||
        !/^1[3456789]\d{9}$/.test(this.authPhoneNumber)
      ) {
        this.$message.error("请填写正确的手机号");
        return;
      }
      axios.get("/user/sendMsg?phone=" + this.authPhoneNumber).then(res => {
        console.info(res.data);
        let userOut = 209;
        if (res.data.code == userOut) {
          this.$message.error("账号已被冻结, 请联系管理员");
          return;
        }

        this.code = res.data.data;

        this.count = TIME_COUNT;
        this.timer = setInterval(() => {
          this.disabledBtn = true;
          if (this.count > 0 && this.count <= TIME_COUNT) {
            this.count--;
          } else {
            this.disabledBtn = false;
            clearInterval(this.timer);
            this.timer = null;
          }
        }, 1000);
      });
    }
  },
  created() {
    if (localStorage.getItem("token")) {
      this.$router.replace({ path: "/" });
    }
  }
};
</script>

<style>
.login {
  position: fixed;
  left: 0;
  top: 0;
  right: 0;
  bottom: 0;
  overflow: hidden;
  background-color: rgba(0, 0, 0, 0.3);
}
.center {
  display: flex;
  height: 100%;
  margin: 0 1em;
}
.center-login {
  flex-grow: 1;
  display: flex;
  align-items: center;
  justify-content: center;
}
.login-desc {
  position: relative;
  box-sizing: border-box;
  width: 100%;
  max-width: 340px;
  background: #fff;
  border-radius: 10px;
}
.login-header {
  margin: 0 22px;
  padding: 15px 0;
  font-size: 20px;
  text-align: center;
  border-bottom: 0.5px solid rgb(242, 242, 242);
}
.Input {
  display: inline-block;
  box-sizing: border-box;
  width: 56%;
  margin: 0;
  padding: 9px;
  color: inherit;
  font: inherit;
  font-size: 14px;
  line-height: 20px;
  background: rgb(247, 247, 247);
  border: 1px solid rgb(247, 247, 247);
  border-radius: 999px;
  appearance: none;
  outline: none;
}

.button-modal {
  display: flex;
  justify-content: space-around;
  padding: 0px 22px;
  margin: 12px 0 27px 0;
}
.button-ye {
  width: 180px;
  padding: 6px 0;
  font-size: 15px;
  line-height: 27px;
  color: #fff;
  background: rgb(24, 195, 170);
  border-color: rgb(24, 195, 170);
  text-align: center;
  text-decoration: none;
  white-space: nowrap;
  border: 0.5px solid rgb(242, 242, 242);
  border-radius: 999px;
}
.login-hint {
  padding: 0 20px;
  color: red;
}
.bluebt{
  border-radius: 10px;
  background-color: rgb(64,158,255);
  background: rgb(64,158,255);
  color:#fff;
  border: 1px solid rgb(64,158,255);
  line-height: 38px;
  width: 39%;
}
</style>


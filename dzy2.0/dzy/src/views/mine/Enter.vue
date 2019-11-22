<template>
    <div class="id">
        <div class="modal">
            <div class="modal-user">
                <div class="modal-selete">
                    <div class="selete-header">
                        用户选择
                    </div>
                    <div class="selete-content">
                        <div class="users" @click="newLogin()" style="  margin-bottom: 20px;">新用户</div>
                        <div class="users color" @click="oldLogin()">老用户</div>
                    </div>
                </div>  
            </div>
        </div>
        <div v-if="oldLogins === true">
            <div class="login">
                <div class="center">
                <div class="center-login">
                    <div class="login-desc">
                    <div class="login-header">手机绑定<div class="vback" @click="oldLogin()"><svg t="1566910576767" class="icon" viewBox="0 0 1024 1024" version="1" xmlns="http://www.w3.org/2000/svg" p-id="2247" width="22" height="22"><path d="M557.311759 513.248864l265.280473-263.904314c12.54369-12.480043 12.607338-32.704421 0.127295-45.248112-12.512727-12.576374-32.704421-12.607338-45.248112-0.127295L512.127295 467.904421 249.088241 204.063755c-12.447359-12.480043-32.704421-12.54369-45.248112-0.063647-12.512727 12.480043-12.54369 32.735385-0.063647 45.280796l262.975407 263.775299-265.151458 263.744335c-12.54369 12.480043-12.607338 32.704421-0.127295 45.248112 6.239161 6.271845 14.463432 9.440452 22.687703 9.440452 8.160624 0 16.319527-3.103239 22.560409-9.311437l265.216826-263.807983 265.440452 266.240344c6.239161 6.271845 14.432469 9.407768 22.65674 9.407768 8.191587 0 16.352211-3.135923 22.591372-9.34412 12.512727-12.480043 12.54369-32.704421 0.063647-45.248112L557.311759 513.248864z" p-id="2248"></path></svg></div></div>
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
                        <button class="button-ye" @click="login()">确定</button>
                    </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
    
</template>

<script>
export default {
    data(){
        return{
            oldLogins:false,
            authPhoneNumber: "",
            authCode: "",
            phoneNumber: "",
            code: "",
            disabledBtn: false,
            timer: null,
            count: "",
            // wxcode:null,
        }
    },
    methods:{
        //新用户登入
         newLogin(){
            this.axios.post("/user/login/newUser")
              .then(res => {
                if(res.data.code === 0){
                  this.$localStorage.set("token", res.data.data);
                  this.$message({message: '登录成功',type: 'success'})
                  this.$router.push({ path: "/users" });
                } else if (res.data.code === 240) {
                  this.$message.error("请先授权");
                  this.$router.push({ path: "/Authorize" });
                }
              });
        },  
        //老用户登入
       async oldLogin(){
          this.oldLogins = !this.oldLogins
        },
        login() {
          if (
            !this.authPhoneNumber ||
            !/^1[3456789]\d{9}$/.test(this.authPhoneNumber)
          ) {
            this.$message.error("请填写正确的手机号");
            return;
          }
          this.axios.post(
              "/user/login/oldUser?phoneNum=" +this.authPhoneNumber +"&verification=" +this.authCode
            )
            .then(res => {
              console.info(res.data.code)
              if(res.data.code == 0){
                this.$localStorage.set("token", res.data.data);
                this.$message({message: '登录成功',type: 'success'})
                this.$router.push({ path: "/users" }); 
              }else if(res.data.code == 206){
                this.$message.error("该手机号还没有注册过，请选择新用户登录");
              }else if(res.data.code == 250){
                this.$message.error("验证码错误");
              }else if(res.data.code == 220){
                this.$message.error("该手机已绑定账号，请输入正确的手机号");
              }
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
      this.axios.get("/user/sendMsg?phone=" + this.authPhoneNumber)
        .then(res => {
          this.code = res.data.data;
          console.info(this.code);

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
    },
  },
  created() {
    if (localStorage.getItem("token")) {
      this.$router.push({ path: "/" });
    }
  }
}
</script>

<style>
.id{
    position: fixed;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    overflow: hidden;
    background-color: rgba(0, 0, 0, .3);
}
.modal{
    display: flex;
    height: 100%;
    margin: 0 1em;
    flex-direction: column;
    
}
.modal-user{
    flex-grow: 1;
    display: flex;
    align-items: center;
    justify-content: center;
}
.modal-selete{
    position: relative;
    box-sizing: border-box;
    width: 100%;
    max-width: 340px;
    background: #fff;
    border-radius: 10px;
    overflow-x: hidden;
    pointer-events: auto;
    height:285px;
}
.selete-header{
    margin: 0 22px;
    padding: 15px 0;
    font-size: 20px;
    text-align: center;
    border-bottom: .5px solid rgb(242, 242, 242);
}
.selete-content{
    padding: 30px 60px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.users{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 70px;
    font-size:18px;
    color: #fff;
    background: rgb(24, 195, 170);
    border-color: rgb(24, 195, 170);
    border-radius: 10px;
  
}
.color{
    background: rgb(214, 186, 140);
     border-color: rgb(214, 186, 140);
    /* border-color: rgb(226, 105, 105); */
}   

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
  height: 285px;
}
.login-header {
  margin: 0 22px;
  padding: 15px 0;
  font-size: 20px;
  text-align: center;
  border-bottom: 0.5px solid rgb(242, 242, 242);
}
.vback{
    position: absolute;
    right: 18px;
    top:15px;

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
.bluebt{
  border-radius: 10px;
  background-color: rgb(64,158,255);
  background: rgb(64,158,255);
  color:#fff;
  border: 1px solid rgb(64,158,255);
  line-height: 38px;
  width: 39%;
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
  margin-top: 20px;
}
.login-hint {
  padding: 0 20px;
  color: red;
}
</style>
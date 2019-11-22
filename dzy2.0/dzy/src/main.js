import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Vuex from 'vuex';
import axios from 'axios';
import Mint from 'mint-ui';
import 'mint-ui/lib/style.css';
import moment from 'moment';
import Vant from 'vant';
import 'vant/lib/index.css';
import {
  Skeleton
} from 'vant';
import {
  Area,
  Popup
} from 'vant';
import VueCookies from 'vue-cookies'
import VueLocalStorage from 'vue-localstorage'
import qs from 'qs';
import VueLazyload from 'vue-lazyload'

Vue.use(VueLazyload)
Vue.use(VueLocalStorage)
Vue.use(VueCookies)
Vue.use(Popup);
Vue.use(Area);
Vue.use(Vant);
Vue.use(Mint);
Vue.use(Vuex);
Vue.use(ElementUI);
Vue.use(VueLazyload);
Vue.use(Skeleton);

// axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.baseURL = '/dzy';
Vue.prototype.axios = axios;
Vue.prototype.$qs = qs;

Vue.filter('moment', (value, patten = "YYYY-MM-DD HH:mm:ss") => {
  return moment(value).format(patten);
})

axios.interceptors.request.use(config => {
  console.info(config.url);
  let urls = ['/user', '/book/unsold', '/book/unsold/isbn', '/book/unsold/cancel', '/order', '/address', '/cart/selling', '/cart', '/cart/selectAll', "/book/search?title", "/collection/detailed", "/details", "/order/buy", "/user/coupon"];
  let token = localStorage.getItem("token");
  urls.forEach(url => {
    if (config.url.includes(url)) {
      config.headers.token = token;
      return config;
    }
  });
  return config;
}, error => {
  return Promise.reject(error);
});

// axios.interceptors.response.use(response => {
//   console.info(response);
//   let unLogin = 207;
//   let timeOut = 208;
//   let userOut = 209;
//   if (response.data == unLogin) {
//     console.info("用户未登录");
//     localStorage.removeItem("token");
//     router.replace({
//       path: '/login'
//     })
//   }
//   if (response.data == timeOut) {
//     console.info("登录超时, 请重新登录");
//     localStorage.removeItem("token");
//     router.replace({
//       path: '/login'
//     })
//   }
//   if (response.data == userOut) {
//     console.info("账号被冻结, 请联系管理员");
//     localStorage.removeItem("token");
//     router.replace({
//       path: '/login'
//     })
//   }
//   return response
// }, error => {
//   return Promise.resolve(error.response)
// });

router.beforeEach((to, from, next) => {
  let urls = ["/sell/order", "/order", "/account", "/order-one", "/orderParticulars", "/users", "/cart", "/sell"];
  let token = localStorage.getItem("token");
  if (urls.includes(to.path)) {
    if (!token) {
      return next('/Authorize')
    }
  }
  next()
})

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
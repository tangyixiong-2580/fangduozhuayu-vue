import Vue from 'vue'
import Router from 'vue-router'

import Sell from '../views/sellBook/Sell.vue'
import Order from '../views/sellBook/Order.vue'
import SellSynopsis from '../views/sellBook/SellSynopsis.vue'

import problems from '../views/support/Problems.vue'
import Condition from '../views/support/Condition.vue'
import BookService from '../views/support/BookService.vue'

import Orders from '../views/mine/Orders.vue'
import Account from '../views/mine/Account.vue'
import Users from '../views/mine/Users.vue'
import Login from '../views/mine/Login.vue'
import Enter from '../views/mine/Enter.vue'
import Authorize from '../views/mine/Authorize.vue'
import OrdersNone from '../views/mine/OrdersNone.vue'
import OrderParticulars from '../views/mine/OrderParticulars.vue'


import Coupon from '../views/mine/Coupon.vue'


import Search from '../views/home/Search.vue'
import Home from '../views/home/Home.vue'
import Remark from '../views/home/Remark.vue'
import Detaile from '../views/home/Detaile.vue'
import FullListofBooks from '../views/home/FullListofBooks.vue'
import Castabout from '../views/home/Castabout.vue'
import Eecommend from '../views/home/Eecommend.vue'
import ListDetails from '../views/home/ListDetails.vue'

import Cart from '../views/cart/Cart.vue'

import Checkout from '../views/cart/Checkout.vue'


Vue.use(Router)

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  linkExactActiveClass: "active",
  routes: [{
      path: '*',
      // component: NotFoundComponent
    }, {
      path: '/sell',
      name: 'Sell',
      component: Sell
    }, {
      path: '/listdetails',
      name: 'listdetails',
      component: ListDetails
    }, {
      path: '/detaile',
      name: 'Detaile',
      component: Detaile
    },
    {
      path: '/castabout',
      name: 'Castabout',
      component: Castabout
    }, {
      path: '/Eecommend',
      name: 'Eecommend',
      component: Eecommend
    }, {
      path: '/fulllistofbooks',
      name: 'FullListofBooks',
      component: FullListofBooks
    }, {
      path: '/sell/order',
      name: 'Order',
      component: Order
    }, {
      path: '/support/problems',
      name: 'problems',
      component: problems
    }, {
      path: '/search',
      name: 'Search',
      component: Search
    }, {
      path: '/account',
      name: 'account',
      component: Account
    }, {
      path: '/users',
      name: 'users',
      component: Users
    }, {
      path: '/orders',
      name: 'Orders',
      component: Orders
    }, {
      path: '/sellSynopsis',
      name: 'SellSynopsis',
      component: SellSynopsis
    }, {
      path: '/support/condition',
      name: 'Condition',
      component: Condition
    }, {
      path: '/',
      name: 'Home',
      component: Home
    }, {
      path: '/orderParticulars',
      name: 'OrderParticulars',
      component: OrderParticulars
    }, {
      path: '/remark',
      name: 'remark',
      component: Remark
    },
    {
      path: '/support/book-service',
      name: 'BookService',
      component: BookService
    }, {
      path: '/login',
      name: 'Login',
      component: Login
    }, {
      path: '/Enter',
      name: 'Enter',
      component: Enter
    }, {
      path: '/Authorize',
      name: 'Authorize',
      component: Authorize
    }, {
      path: '/orders-none',
      name: 'OrdersNone',
      component: OrdersNone
    }, {
      path: '/cart',
      name: 'Cart',
      component: Cart
    }, {
      path: '/invitation',
      name: 'Invitation',
      component: Invitation
    }, {
      path: '/poster',
      name: 'Poster',
      component: Poster
    },
     path: '/cart',
     name: 'Cart',
     component: Cart
  },
      path: '/sell',
      name: 'Sell',
      component: Sell
    }, {
      path: '/listdetails',
      name: 'listdetails',
      component: ListDetails
    }, {
      path: '/detaile',
      name: 'Detaile',
      component: Detaile
    },
    {
      path: '/castabout',
      name: 'Castabout',
      component: Castabout
    }, {
      path: '/Eecommend',
      name: 'Eecommend',
      component: Eecommend
    }, {
      path: '/fulllistofbooks',
      name: 'FullListofBooks',
      component: FullListofBooks
    }, {
      path: '/sell/order',
      name: 'Order',
      component: Order
    }, {
      path: '/support/problems',
      name: 'problems',
      component: problems
    }, {
      path: '/search',
      name: 'Search',
      component: Search
    }, {
      path: '/account',
      name: 'account',
      component: Account
    }, {
      path: '/users',
      name: 'users',
      component: Users
    }, {
      path: '/orders',
      name: 'Orders',
      component: Orders
    }, {
      path: '/sellSynopsis',
      name: 'SellSynopsis',
      component: SellSynopsis
    }, {
      path: '/support/condition',
      name: 'Condition',
      component: Condition
    }, {
      path: '/',
      name: 'Home',
      component: Home
    }, {
      path: '/orderParticulars',
      name: 'OrderParticulars',
      component: OrderParticulars
    }, {
      path: '/remark',
      name: 'remark',
      component: Remark
    },
    {
      path: '/support/book-service',
      name: 'BookService',
      component: BookService
    }, {
      path: '/login',
      name: 'Login',
      component: Login
    }, {
      path: '/Enter',
      name: 'Enter',
      component: Enter
    }, {
      path: '/Authorize',
      name: 'Authorize',
      component: Authorize
    }, {
      path: '/orders-none',
      name: 'OrdersNone',
      component: OrdersNone
    }, {
      path: '/cart',
      name: 'Cart',
      component: Cart
    }, {
      path: '/cart/checkout',
      name: 'Checkout',
      component: Checkout
    }, {
      path: '/coupon',
      name: 'Coupon',
      component: Coupon
    }
  ]
})
import Vue from 'vue'
import App from './App'
import router from './router'
// 设置反向代理
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8001/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

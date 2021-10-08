import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
// 设置反向代理
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8001/api'
// 全局注册
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)

// 访问每一个路由前调用
router.beforeEach((to, from, next) => {
  // 路由是否需要拦截
  if (to.meta.requireAuth) {
    if (store.state.user.userName) {
      next()
    } else {
      // 用户名为空，重定向至登录和注册页面
      next({
        path: 'user',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>',
  render: h => h(App)
})

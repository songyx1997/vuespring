import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import LuckyWheel from '@lucky-canvas/vue'
import './styles/base.css'
import './styles/reset.css'
import 'github-markdown-css'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

// 设置反向代理
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8001/api'
// 全局注册
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(LuckyWheel)
var echarts = require('echarts')
Vue.prototype.$echarts = echarts
// 配置进度条
NProgress.configure({ showSpinner: false })

// 访问每一个路由前调用
router.beforeEach((to, from, next) => {
  NProgress.start()
  // 路由是否需要拦截
  if (to.meta.requireAuth) {
    if (store.getters.userInfo) {
      next()
    } else {
      // 重定向至登录和注册页面
      next({
        path: 'user',
        query: { redirect: to.fullPath }
      })
    }
  } else {
    next()
  }
})

router.afterEach(() => {
  NProgress.done()
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

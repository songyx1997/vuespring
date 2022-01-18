import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
// 载入Element样式
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 载入基本样式
import './styles/base.css'
import './styles/reset.css'
// 载入markdown样式
import 'github-markdown-css'
// 进度条
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
// 幸运转盘
import LuckyWheel from '@lucky-canvas/vue'
// 载入echarts
var echarts = require('echarts')
Vue.prototype.$echarts = echarts
// 设置axios反向代理
var axios = require('axios')
Vue.prototype.$axios = axios
axios.defaults.baseURL = 'http://localhost:8001/api'
// 关闭相同路由跳转报错
Vue.config.productionTip = false
// 全局配置
Vue.use(ElementUI)
Vue.use(LuckyWheel)
NProgress.configure({ showSpinner: false })

// 访问每一个路由前调用
router.beforeEach((to, from, next) => {
  NProgress.start()
  // 路由是否需要拦截
  if (to.meta.requireAuth) {
    if (store.getters.userInfo) {
      next()
      // 添加页面标题
      if (to.meta.name) {
        document.title = 'SCRUM ' + '| ' + to.meta.name
      }
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

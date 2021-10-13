import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import Index from '@/views/Index'
import User from '@/views/User'

Vue.use(Router)

export default new Router({
  // 默认的hash模式切换为histroy模式
  mode: 'history',
  routes: [
    {
      path: '/index',
      name: 'Index',
      component: Index,
      meta: {
        // true：需要拦截的页面
        requireAuth: true
      }
    },
    {
      path: '/user',
      name: 'User',
      component: User
    }
  ]
})

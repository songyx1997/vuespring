import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import AppIndex from '@/components/home/AppIndex'
import User from '@/components/User'

Vue.use(Router)

export default new Router({
  // 默认的hash模式切换为histroy模式
  mode: 'history',
  routes: [
    {
      path: '/user',
      name: 'User',
      component: User
    },
    {
      path: '/index',
      name: 'AppIndex',
      component: AppIndex,
      meta: {
        // true：需要拦截的页面
        requireAuth: true
      }
    }
  ]
})

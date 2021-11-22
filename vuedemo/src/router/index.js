import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import Index from '@/views/Index'
import User from '@/views/User'
import Home from '@/views/Home'
import StandUp from '@/views/StandUp'
import Story from '@/views/Story'

// 避免重复触发路由时报错
const originalPush = Router.prototype.push

Router.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(Router)

export default new Router({
  // 默认的hash模式切换为histroy模式
  mode: 'history',
  routes: [
    {
      path: '/index',
      component: Index,
      meta: {
        // true：需要拦截的页面
        requireAuth: true
      },
      children: [
        {
          path: '/home',
          component: Home,
          meta: {
            name: '个人中心',
            requireAuth: true
          }
        },
        {
          path: '/standup',
          component: StandUp,
          meta: {
            name: '每日站会',
            icon: 'el-icon-position',
            requireAuth: true
          }
        },
        {
          path: '/story',
          component: Story,
          meta: {
            name: '故事评估',
            icon: 'el-icon-data-analysis',
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/user',
      component: User
    }
  ]
})

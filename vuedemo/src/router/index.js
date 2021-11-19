import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import Index from '@/views/Index'
import User from '@/views/User'
import Home from '@/views/Home'
import StandUp from '@/views/StandUp'
import Story from '@/views/Story'

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
          component: Home
        },
        {
          path: '/standup',
          name: '每日站会',
          icon: 'el-icon-position',
          component: StandUp
        },
        {
          path: '/story',
          name: '故事评估',
          icon: 'el-icon-data-analysis',
          component: Story
        }
      ]
    },
    {
      path: '/user',
      component: User
    }
  ]
})

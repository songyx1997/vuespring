<template>
  <div>
    <div class="nav-menu">
      <div :style="navZoom" @click="zoomClick">
        <i :class="zoomIcon"></i>
      </div>
      <div class="nav-breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item>
            <a @click="homeClick">首页</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item>
            <a>{{ initBreadCrumbName() }}</a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="nav-avatar-container">
        <el-dropdown size="medium" @command="handleCommand">
          <el-avatar :size="40" shape="square"
            ><span class="nav-avatar-img">{{ avatar }}</span></el-avatar
          >
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="signOut">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
    <el-drawer
      direction="ltr"
      size="210px"
      :visible.sync="drawer"
      :show-close="false"
      :with-header="false"
    >
      <scroll-menu></scroll-menu>
    </el-drawer>
  </div>
</template>
<style scoped>
.nav-menu {
  display: flex;
  align-items: center;
  height: inherit;
  background: white;
  box-shadow: 0 1px 4px var(--grey);
}
.nav-breadcrumb {
  flex: 1;
}
.nav-avatar-container {
  padding: 3px 20px 0 0;
  cursor: pointer;
}
.nav-avatar-img {
  color: var(--blue);
  font-size: 30px;
}
</style>
<script>
import { successInfo } from '@/utils/message'
import ScrollMenu from './ScrollMenu.vue'
export default {
  data () {
    return {
      drawer: false,
      zoomIcon: 'el-icon-s-grid',
      navZoom: { padding: '2px 8px 0 16px' }
    }
  },
  components: {
    ScrollMenu
  },
  computed: {
    avatar () {
      return this.$store.getters.userInfo.userName.charAt(0).toUpperCase()
    }
  },
  watch: {
    '$store.getters.openFlag': function () {
      let openFlag = this.$store.getters.openFlag
      if (openFlag) {
        this.zoomIcon = 'el-icon-s-grid'
        this.navZoom = { padding: '2px 8px 0 16px' }
      } else {
        this.zoomIcon = 'el-icon-s-unfold'
        this.navZoom = { padding: '2px 8px 0 10px', cursor: 'pointer' }
      }
    }
  },

  methods: {
    zoomClick () {
      let device = this.$store.getters.device
      if (device === 'mobile') {
        // 手机端侧边栏显示为抽屉
        this.drawer = true
      }
    },
    initBreadCrumbName () {
      return this.$route.meta.name
    },
    homeClick () {
      this.$router.push({
        path: this.$router.options.routes[1].children[0].path,
        replace: true
      })
    },
    handleCommand (command) {
      if (command === 'signOut') {
        // 清除用户信息
        this.$store.dispatch('user/removeUserInfo')
        // 跳转至登陆界面
        this.$router.replace({ path: '/user' })
        successInfo('退出成功！')
      }
    }
  }
}
</script>

<template>
  <div class="nav-menu">
    <div class="nav-zoom" @click="zoomClick">
      <i class="el-icon-s-fold" style="cursor: pointer;"></i>
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
        <img class="nav-avatar-img" :src="avatarUrl" />
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="signOut">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
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
.nav-zoom {
  padding-left: 15px;
  padding-right: 15px;
}
.nav-breadcrumb {
  flex: 1;
}
.nav-avatar-container {
  padding-right: 20px;
  cursor: pointer;
}
.nav-avatar-img {
  height: 40px;
  padding-top: 4px;
  border-radius: 10px;
}
</style>
<script>
import avatar from '@/assets/avatar.gif'
import { successInfo } from '@/utils/message'
export default {
  data () {
    return {
      avatarUrl: avatar
    }
  },
  methods: {
    zoomClick () {
      this.$store.dispatch('sidebar/reverseSideBar')
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

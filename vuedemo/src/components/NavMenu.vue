<template>
  <div class="nav-menu">
    <div class="nav-zoom" @click="zoomClick">
      <i class="el-icon-s-fold"></i>
    </div>
    <div class="nav-breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/">每日站会</a></el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="nav-avatar-container">
      <el-dropdown size="medium">
        <img class="nav-avatar-img" :src="avatarUrl" />
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item disabled>退出登录</el-dropdown-item>
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
}
.nav-avatar-img {
  height: 40px;
  padding-top: 4px;
  border-radius: 10px;
}
</style>
<script>
import avatar from '@/assets/avatar.gif'
export default {
  name: 'NavMenu',
  data () {
    return {
      avatarUrl: avatar
    }
  },
  methods: {
    zoomClick () {
      // 调用父类方法
      this.$emit('navClick')
    }
  }
}
</script>

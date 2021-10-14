<template>
  <div class="nav-menu">
    <div class="nav-Zoom">
      <i class="el-icon-s-unfold"></i>
    </div>
    <div class="nav-breadcrumb">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/">参数管理</a></el-breadcrumb-item>
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
<style>
.nav-menu {
  display: flex;
  align-items: center;
  height: inherit;
  background: white;
  box-shadow: 0 1px 4px var(--grey);
}
.nav-Zoom {
  padding-left: 15px;
  padding-right: 15px;
}
.nav-Zoom:hover {
  background: var(--btnshadow);
}
.nav-breadcrumb {
  flex: 1;
}
.nav-avatar-container {
  padding-top: 2px;
  padding-right: 15px;
}
.nav-avatar-img {
  height: 45px;
  border-radius: 10px;
}
</style>
<script>
import '@/styles/base.css'
import logo from '@/assets/logo.png'
import avatar from '@/assets/avatar.gif'
export default {
  name: 'NavMenu',
  data () {
    return {
      logoUrl: logo,
      avatarUrl: avatar
    }
  }
}
</script>

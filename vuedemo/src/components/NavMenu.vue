<template>
  <el-menu class="nav-menu">
    <el-menu-item>
      <el-image class="nav-img" :src="logoUrl"></el-image>
      <span class="nav-title">&nbsp;SCRUM</span>
    </el-menu-item>
  </el-menu>
</template>
<style>
.el-menu-item {
  padding: 0px;
}
.nav-menu {
  display: flex;
}
.nav-img {
  height: 100%;
}
.nav-title {
  font-size: 30px;
  font-weight: 900;
  color: var(--darkblue);
}
</style>
<script>
import '@/styles/base.css'
import logo from '@/assets/logo2.png'
export default {
  name: 'NavMenu',
  data () {
    return {
      logoUrl: logo
    }
  }
}
</script>

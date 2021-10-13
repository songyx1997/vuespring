<template>
  <el-menu
    class="nav-overall"
    :default-active="'/index'"
    router
    mode="horizontal"
  >
    <el-menu-item index="1">
      <el-image :src="logoUrl" style="width:180px;margin-left:-20px"></el-image>
    </el-menu-item>
  </el-menu>
</template>
<style>
.nav-overall {
  background-color: #e4e7ed;
}
.nav-title {
  /* position: absolute;
  padding-top: 20px;
  right: 43%;
  font-size: 20px;
  font-weight: bold; */
}
</style>
<script>
// import logo from '@/assets/index/logo1.png'
export default {
  name: 'NavMenu',
  data () {
    return {
      // logoUrl: logo,
      navList: [{ name: '/index', navItem: '首页' }]
    }
  }
}
</script>

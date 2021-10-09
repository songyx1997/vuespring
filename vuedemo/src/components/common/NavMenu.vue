<template>
  <el-menu
    class="nav-overall"
    :default-active="'/index'"
    router
    mode="horizontal"
    @select="handleSelect"
  >
  </el-menu>
</template>
<style>
.nav-overall {
  background-color: #e4e7ed;
  border-radius: 5px;
}
.nav-title {
  position: absolute;
  padding-top: 20px;
  right: 43%;
  font-size: 20px;
  font-weight: bold;
}
</style>
<script>
export default {
  name: 'NavMenu',
  data () {
    return {
      navList: [{ name: '/index', navItem: '首页' }]
    }
  }
}
</script>

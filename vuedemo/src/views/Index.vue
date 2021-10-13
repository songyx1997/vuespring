<template>
  <body>
    <el-container>
      <el-header><nav-menu></nav-menu></el-header>
      <el-container>
        <el-aside></el-aside>
        <el-main></el-main>
      </el-container>
    </el-container>
  </body>
</template>
<style>
body {
  /* 覆盖掉浏览器样式 */
  margin: 0px;
  padding: 0px;
  background-color: var(--lightgrey);
}
</style>
<script>
import '@/styles/base.css'
import NavMenu from '../components/NavMenu.vue'
export default {
  name: 'Home',
  components: {
    NavMenu
  }
}
</script>

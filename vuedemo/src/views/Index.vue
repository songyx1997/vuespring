<template>
  <el-container>
    <el-header>header</el-header>
    <el-container>
      <el-aside>Aside</el-aside>
      <el-main>Main</el-main>
    </el-container>
  </el-container>
</template>
<style></style>
<script>
import NavMenu from '../components/NavMenu.vue'
export default {
  name: 'Home',
  components: {
    NavMenu
  }
}
</script>

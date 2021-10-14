<template>
  <body>
    <el-container>
      <el-aside style="width:210px"><scroll-menu></scroll-menu></el-aside>
      <el-container
        ><el-header style="height:50px;padding:0px"
          ><nav-menu @navClick="navClick"></nav-menu
        ></el-header>
        <el-main></el-main>
      </el-container>
    </el-container>
  </body>
</template>
<style></style>
<script>
import NavMenu from '../components/NavMenu.vue'
import ScrollMenu from '../components/ScrollMenu.vue'
export default {
  name: 'Home',
  components: {
    NavMenu,
    ScrollMenu
  },
  methods: {
    navClick () {
      console.log('父类方法调用测试')
    }
  }
}
</script>

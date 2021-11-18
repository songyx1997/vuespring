<template>
  <div class="scroll-overall">
    <div class="scroll-home">
      <el-image class="scroll-img" :src="logoUrl"></el-image>
      <span class="scroll-text">SCRUM</span>
    </div>
    <el-scrollbar class="scroll-bar" wrap-class="el-scrollbar-wrapper">
      <el-menu
        class="scroll-menu"
        mode="vertical"
        background-color="#e4e7ed"
        text-color="#000000"
        active-text-color="#409eff"
        :collapse="isCollapse"
        :collapse-transition="false"
      >
        <el-menu-item
          v-for="route in routes"
          :key="route.path"
          :index="route.path"
        >
          <i :class="route.icon"></i>
          <span slot="title"> {{ route.name }}</span>
        </el-menu-item>
      </el-menu>
    </el-scrollbar>
  </div>
</template>
<style scoped>
.scroll-overall {
  background-color: var(--grey);
  width: inherit;
  height: 100%;
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  text-align: left;
}
.scroll-menu {
  font-weight: 900;
}
.scroll-bar {
  height: 100%;
}
.scroll-home {
  display: flex;
  align-items: center;
  box-sizing: border-box;
  height: 60px;
  padding: 0px 15px;
  font-weight: 900;
  cursor: pointer;
}
.scroll-text {
  padding-left: 10px;
  font-size: 25px;
  color: var(--blue);
}
.scroll-img {
  padding: 10px 0px;
  height: 40px;
}
</style>
<script>
import logo from '@/assets/logo.png'
import $ from 'jquery'
export default {
  name: 'ScrollMenu',
  data () {
    return {
      logoUrl: logo
    }
  },
  computed: {
    routes () {
      var array = new Array(0)
      for (let index = 0; index < this.$router.options.routes.length; index++) {
        if (!this.$router.options.routes[index].hidden) {
          array.push(this.$router.options.routes[index])
        }
      }
      return array
    },
    isCollapse () {
      var openFlag = this.$store.state.sidebar.openFlag
      $(function () {
        if (openFlag) {
          $('div.index-left').css('width', '210px')
          $('span.scroll-text').css('display', 'inline')
        } else {
          $('div.index-left').css('width', '65px')
          $('span.scroll-text').css('display', 'none')
        }
      })
      return !this.$store.state.sidebar.openFlag
    }
  }
}
</script>

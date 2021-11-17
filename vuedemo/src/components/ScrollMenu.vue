<template>
  <div class="scroll-overall">
    <el-scrollbar class="scroll-bar" wrap-class="el-scrollbar-wrapper">
      <el-menu
        class="scroll-menu"
        mode="vertical"
        background-color="#e4e7ed"
        text-color="#000000"
        active-text-color="#409eff"
        :collapse="isCollapse"
      >
        <el-menu-item index="index">
          <el-image class="scroll-img" :src="logoUrl"></el-image>
          <span slot="title">&nbsp;SCRUM</span>
        </el-menu-item>
        <el-menu-item index="meeting">
          <i class="el-icon-position"></i>
          <span slot="title">每日站会</span>
        </el-menu-item>
        <el-menu-item index="evaluate">
          <i class="el-icon-data-analysis"></i>
          <span slot="title">故事评估</span>
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
.scroll-img {
  height: 45px;
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
    isCollapse () {
      var openFlag = this.$store.state.sidebar.openFlag
      $(function () {
        if (openFlag) {
          $('div.index-left').css('width', '210px')
        } else {
          $('div.index-left').css('width', '65px')
        }
      })
      return !this.$store.state.sidebar.openFlag
    }
  }
}
</script>

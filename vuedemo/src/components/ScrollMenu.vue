<template>
  <div class="scroll-overall">
    <div class="scroll-home" @click="imgClick">
      <el-image class="scroll-img" :src="logoUrl"></el-image>
      <span class="scroll-text">SCRUM</span>
    </div>
    <el-scrollbar class="scroll-bar" wrap-class="el-scrollbar-wrapper">
      <el-menu
        router
        class="scroll-menu"
        mode="vertical"
        background-color="#e4e7ed"
        text-color="#000000"
        active-text-color="#409eff"
        :default-active="activeMenu"
        @select="handleSelect"
      >
        <el-menu-item
          v-for="route in routes"
          :key="route.path"
          :index="route.path"
        >
          <i :class="route.meta.icon"></i>
          <span slot="title"> {{ route.meta.name }}</span>
        </el-menu-item>
      </el-menu>
    </el-scrollbar>
  </div>
</template>
<style scoped>
.scroll-overall {
  background-color: var(--grey);
  width: 210px;
  height: 100%;
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  text-align: left;
  border: 2.5px solid gainsboro;
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
export default {
  data () {
    return {
      logoUrl: logo,
      activeMenu: ''
    }
  },
  computed: {
    routes () {
      // 去除第一个元素
      return this.$router.options.routes[1].children.slice(
        1,
        this.$router.options.routes[1].children.length
      )
    }
  },
  methods: {
    imgClick () {
      this.activeMenu = ''
      this.$router.push({
        path: this.$router.options.routes[1].children[0].path,
        replace: true
      })
    },
    handleSelect (keyPath) {
      this.activeMenu = keyPath
    }
  }
}
</script>

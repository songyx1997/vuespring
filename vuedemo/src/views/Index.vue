<template>
  <div class="index-panel">
    <div class="index-left" :style="defaultSidebar">
      <scroll-menu></scroll-menu>
    </div>
    <div class="index-right">
      <div class="index-header"><nav-menu></nav-menu></div>
      <div class="index-main">
        <transition name="fade" mode="out-in">
          <router-view :key="key" />
        </transition>
      </div>
      <el-backtop>UP</el-backtop>
    </div>
  </div>
</template>
<style>
.index-panel {
  display: flex;
}
.index-left {
  flex-shrink: 0;
  width: 210px;
  height: inherit;
}
.index-right {
  display: flex;
  flex: 1;
  min-width: 0;
  flex-direction: column;
}
.index-header {
  height: 50px;
}
.index-main {
  padding: 15px 20px 0 20px;
}
/* 切换动画 */
.fade-leave-active,
.fade-enter-active {
  transition: all 0.5s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>
<script>
import NavMenu from '../components/NavMenu.vue'
import ScrollMenu from '../components/ScrollMenu.vue'
import ResizeHandler from '../utils/resizeHandle'
export default {
  data () {
    return {
      defaultSidebar: { display: 'block' }
    }
  },
  components: {
    NavMenu,
    ScrollMenu,
    ResizeHandler
  },
  // 混入
  mixins: [ResizeHandler],
  computed: {
    key () {
      return this.$route.path
    }
  },
  watch: {
    '$store.getters.openFlag': function () {
      let openFlag = this.$store.getters.openFlag
      if (openFlag) {
        this.defaultSidebar = { display: 'block' }
      } else {
        this.defaultSidebar = { display: 'none' }
      }
    }
  }
}
</script>

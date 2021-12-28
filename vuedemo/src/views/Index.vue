<template>
  <div class="index-panel">
    <div class="index-left"><scroll-menu></scroll-menu></div>
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
  padding: 20px;
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
  }
}
</script>

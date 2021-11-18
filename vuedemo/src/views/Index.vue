<template>
  <div class="index-panel">
    <div class="index-left"><scroll-menu></scroll-menu></div>
    <div class="index-right">
      <div class="index-header"><nav-menu @navClick="navClick"></nav-menu></div>
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
@media screen and (max-width: 992px) {
  .index-left {
    flex-shrink: 0;
    width: 65px;
    height: inherit;
  }
}
</style>
<script>
import NavMenu from '../components/NavMenu.vue'
import ScrollMenu from '../components/ScrollMenu.vue'
import ResizeHandler from '../utils/resizeHandle'
export default {
  name: 'Home',
  components: {
    NavMenu,
    ScrollMenu,
    ResizeHandler
  },
  // 混入
  mixins: [ResizeHandler],
  methods: {
    navClick () {
      this.$store.dispatch('reverseSideBar')
    }
  }
}
</script>

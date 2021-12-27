import store from '@/store'

const { body } = document
const WIDTH = 992

export default {
  beforeMount () {
    window.addEventListener('resize', this.$_resizeHandler)
  },
  beforeDestroy () {
    window.removeEventListener('resize', this.$_resizeHandler)
  },
  mounted () {
    const isMobile = this.$_isMobile()
    if (isMobile) {
      // 如果是手机端，关闭侧边栏
      store.dispatch('sidebar/closeSideBar')
      store.dispatch('sidebar/setDevice', 'mobile')
    }
  },
  methods: {
    $_isMobile () {
      const rect = body.getBoundingClientRect()
      return rect.width - 1 < WIDTH
    },
    $_resizeHandler () {
      if (!document.hidden) {
        const isMobile = this.$_isMobile()
        if (isMobile) {
          store.dispatch('sidebar/closeSideBar')
          store.dispatch('sidebar/setDevice', 'mobile')
        } else {
          store.dispatch('sidebar/openSideBar')
          store.dispatch('sidebar/setDevice', 'desktop')
        }
      }
    }
  }
}

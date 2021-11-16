import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    // 监听用户
    user: {
      userName:
        window.localStorage.getItem('user' || '[]') == null
          ? ''
          : JSON.parse(window.localStorage.getItem('user' || '[]')).userName
    },
    // 监听设备
    sidebar: {
      openFlag: true
    }
  },
  mutations: {
    user (state, user) {
      // 将用户信息放入全局存储
      state.user = user
      window.localStorage.setItem('user', JSON.stringify(user))
    },
    REVERSE_SIDEBAR (state) {
      state.sidebar.openFlag = !state.sidebar.openFlag
    },
    OPEN_SIDEBAR (state) {
      state.sidebar.openFlag = true
    },
    CLOSE_SIDEBAR (state) {
      state.sidebar.openFlag = false
    }
  },
  actions: {
    reverseSideBar ({ commit }) {
      commit('REVERSE_SIDEBAR')
    },
    openSideBar ({ commit }) {
      commit('OPEN_SIDEBAR')
    },
    closeSideBar ({ commit }) {
      commit('CLOSE_SIDEBAR')
    }
  }
})

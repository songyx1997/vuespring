import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      userName:
        window.localStorage.getItem('user' || '[]') == null
          ? ''
          : JSON.parse(window.localStorage.getItem('user' || '[]')).userName
    }
  },
  mutations: {
    user (state, user) {
      // 将用户信息放入全局存储
      state.user = user
      window.localStorage.setItem('user', JSON.stringify(user))
    }
  }
})

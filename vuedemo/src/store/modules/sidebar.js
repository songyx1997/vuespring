const state = {
  // 监听设备
  openFlag: true
}

const mutations = {
  REVERSE_SIDEBAR (state) {
    state.openFlag = !state.openFlag
  },
  OPEN_SIDEBAR (state) {
    state.openFlag = true
  },
  CLOSE_SIDEBAR (state) {
    state.openFlag = false
  }
}

const actions = {
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

export default {
  // 使成为带命名空间的模块
  namespaced: true,
  state,
  mutations,
  actions
}

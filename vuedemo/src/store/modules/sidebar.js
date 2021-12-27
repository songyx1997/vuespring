const state = {
  // 默认为电脑端且打开侧边栏
  openFlag: true,
  device: 'desktop'
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
  },
  SET_DEVICE (state, device) {
    state.device = device
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
  },
  setDevice ({ commit }, device) {
    commit('SET_DEVICE', device)
  }
}

export default {
  // 使成为带命名空间的模块
  namespaced: true,
  state,
  mutations,
  actions
}

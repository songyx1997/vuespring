const state = {
  // 用于同步页面上的数据
  monitorFlag: false
}

const mutations = {
  START_MONITOR (state) {
    state.monitorFlag = true
  },
  END_MONITOR (state) {
    state.monitorFlag = false
  }
}

const actions = {
  startMonitor ({ commit }) {
    commit('START_MONITOR')
  },
  endMonitor ({ commit }) {
    commit('END_MONITOR')
  }
}

export default {
  // 使成为带命名空间的模块
  namespaced: true,
  state,
  mutations,
  actions
}

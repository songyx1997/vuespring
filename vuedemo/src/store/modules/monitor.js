const state = {
  // 确定时同步数据
  monitorFlag: false,
  // 删除时同步数据
  deleteFlag: false
}

const mutations = {
  START_MONITOR (state) {
    state.monitorFlag = true
  },
  END_MONITOR (state) {
    state.monitorFlag = false
  },
  START_DELETE (state) {
    state.deleteFlag = true
  },
  END_DELETE (state) {
    state.deleteFlag = false
  }
}

const actions = {
  startMonitor ({ commit }) {
    commit('START_MONITOR')
  },
  endMonitor ({ commit }) {
    commit('END_MONITOR')
  },
  startDelete ({ commit }) {
    commit('START_DELETE')
  },
  endDelete ({ commit }) {
    commit('END_DELETE')
  }
}

export default {
  // 使成为带命名空间的模块
  namespaced: true,
  state,
  mutations,
  actions
}

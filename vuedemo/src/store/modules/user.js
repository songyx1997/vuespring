import Cookies from 'js-cookie'

const state = {
  userInfo: Cookies.get('user') == null ? null : JSON.parse(Cookies.get('user'))
}

const mutations = {
  SET_USERINFO: (state, userInfo) => {
    state.userInfo = userInfo
    Cookies.set('user', JSON.stringify(userInfo))
  },
  REMOVE_USERINFO: state => {
    state.userInfo = null
    Cookies.set('user', null)
  }
}

const actions = {
  getUserInfo ({ commit }, userInfo) {
    commit('SET_USERINFO', userInfo)
  },
  removeUserInfo ({ commit }) {
    commit('REMOVE_USERINFO')
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

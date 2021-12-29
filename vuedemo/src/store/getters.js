const getters = {
  openFlag: state => state.sidebar.openFlag,
  device: state => state.sidebar.device,
  userInfo: state => state.user.userInfo,
  monitorFlag: state => state.monitor.monitorFlag
}
export default getters

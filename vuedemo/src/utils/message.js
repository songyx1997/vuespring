import Vue from 'vue'

// 封装成功的返回信息
export function successInfo (returnMessage) {
  Vue.prototype.$message({
    showClose: true,
    message: returnMessage,
    type: 'success'
  })
}

// 封装失败的返回信息
export function errorInfo (returnMessage) {
  Vue.prototype.$message({
    showClose: true,
    message: returnMessage,
    type: 'error'
  })
}

// 封装取消的返回信息
export function cancelInfo (returnMessage) {
  Vue.prototype.$message({
    showClose: true,
    message: returnMessage,
    type: 'info'
  })
}

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

// 弹窗确认
export function confirmInfo (message, type, method) {
  Vue.prototype
    .$confirm(message, '提示', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: type
    })
    .then(() => method())
    .catch(() => successInfo('已取消'))
}

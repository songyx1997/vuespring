// 校验用户名
export function checkUserName (rules, value, callback) {
  var emailPatt = new RegExp(
    '^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$'
  )
  if (value === '') {
    callback(new Error('请输入邮箱或用户名'))
  } else if (
    !emailPatt.test(value) &&
    (value.length < 3 || value.length > 10)
  ) {
    callback(new Error('用户名长度为3~10个字符'))
  } else {
    callback()
  }
}

// 校验密码重复性
export function checkPasswordRepeat (rules, value, callback, userPassword) {
  if (value === '') {
    callback(new Error('请再次输入密码'))
  } else if (value !== userPassword) {
    callback(new Error('两次输入密码不一致!'))
  } else {
    callback()
  }
}

// 校验密码重复性（new）
export function newCheckPasswordRepeat (rules, value, callback, oldPassword) {
  if (value === '') {
    callback(new Error('请输入新密码'))
  } else if (value === oldPassword) {
    callback(new Error('新密码不应与旧密码相同！'))
  } else {
    callback()
  }
}

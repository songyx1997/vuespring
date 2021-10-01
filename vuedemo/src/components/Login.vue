<template>
  <body class="login-background">
    <div class="login-panal">
      <div class="login-form">
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="免密登陆" name="first">免密登陆</el-tab-pane>
          <el-tab-pane label="密码登录" name="second">密码登录</el-tab-pane>
        </el-tabs>
        <el-form ref="loginForm" :model="form" label-width="0px">
          <el-form-item>
            <el-input
              v-model="loginForm.userName"
              placeholder="手机号/邮箱/用户名"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-input
              type="password"
              v-model="loginForm.userPassword"
              placeholder="密码"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button class="login-button" type="primary" @click="login"
              >登录</el-button
            >
          </el-form-item>
        </el-form>
      </div>
    </div>
  </body>
</template>
<style>
body {
  /* 覆盖掉浏览器样式 */
  margin: 0px;
}
.login-background {
  background: url('../assets/login/background.jpg') no-repeat;
  background-position: center;
  height: 100vh;
  width: 100vw;
  position: fixed;
}
.login-panal {
  position: relative;
  top: 30vh;
}
.login-form {
  margin: 0px auto;
  width: 20em;
  /* 四角变圆 */
  border-radius: 25px;
  padding: 2.5em 2.5em 0.5em 2.5em;
  background: white;
  border: 1px solid gainsboro;
  box-shadow: 0 0 25px gray;
}
.login-button {
  margin-left: 70%;
  width: 30%;
}
</style>
<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        userName: '',
        userPassword: ''
      }
    }
  },
  methods: {
    login () {
      this.$axios
        .post('/user/login', {
          userName: this.loginForm.userName,
          userPassword: this.loginForm.userPassword
        })
        .then(successResponse => {
          if (successResponse.data.returnCode === '200') {
            this.$router.replace({ path: '/index' })
          } else {
            this.$notify.error({
              title: '错误',
              message: '账号不存在或密码错误',
              position: 'bottom-right',
              showClose: false
            })
          }
        })
        .catch(failResponse => {})
    }
  }
}
</script>

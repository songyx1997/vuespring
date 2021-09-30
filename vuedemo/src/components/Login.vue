<template>
  <body>
<el-container>
  <el-header>Header</el-header>
  <el-main>Main</el-main>
  <el-footer>Footer</el-footer>
</el-container>

    <!-- <div class="login-form">
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
    </div> -->
  </body>
</template>
<style>
body {
  /* 覆盖掉浏览器样式 */
  margin: 0px;
}
.login-background{
  background: url('../assets/login/background.jpg');
  /* height: 100%;
  width: 100%;
  background-size: cover;
  position: relative; */
}
.login-form {
  /* 响应式布局 */
  position: relative;
  top: 25vh;
  left: 60vw;
  width: 25vw;
  /* 四角变圆 */
  border-radius: 25px;
  padding: 2.5em 2.5em 0.5em 2.5em;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login-button {
  width: 100%;
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
      },
      responseResult: []
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
          }
        })
        .catch(failResponse => {})
    }
  }
}
</script>

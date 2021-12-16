<template>
  <div class="user-background">
    <div class="user-form">
      <el-tabs v-model="activeName" @tab-click="resetForm">
        <el-tab-pane label="登录" name="login">
          <el-form
            ref="loginForm"
            :model="loginForm"
            :rules="rules"
            label-width="0px"
          >
            <el-form-item prop="userName">
              <el-input
                prefix-icon="el-icon-user"
                v-model="loginForm.userName"
                placeholder="邮箱/用户名"
              ></el-input>
            </el-form-item>
            <el-form-item prop="userPassword">
              <el-input
                prefix-icon="el-icon-lock"
                v-model="loginForm.userPassword"
                type="password"
                placeholder="密码"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button
                class="user-button"
                type="primary"
                @click="login"
                v-loading.fullscreen.lock="fullscreenLoading"
                >登录</el-button
              >
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="注册" name="register">
          <el-form
            ref="registerForm"
            :model="registerForm"
            :rules="rules"
            label-width="0px"
          >
            <el-form-item prop="userEmail">
              <el-input
                prefix-icon="el-icon-message"
                v-model="registerForm.userEmail"
                type="email"
                placeholder="邮箱"
              ></el-input>
            </el-form-item>
            <el-form-item prop="userPassword">
              <el-input
                prefix-icon="el-icon-lock"
                v-model="registerForm.userPassword"
                type="password"
                placeholder="密码"
              ></el-input>
            </el-form-item>
            <el-form-item prop="checkPassword">
              <el-input
                prefix-icon="el-icon-lock"
                v-model="registerForm.checkPassword"
                type="password"
                placeholder="确认密码"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button
                class="user-button"
                type="primary"
                @click="register"
                v-loading.fullscreen.lock="fullscreenLoading"
                >注册</el-button
              >
            </el-form-item>
          </el-form>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>
<style scoped>
.user-background {
  background: url('../assets/login.svg') no-repeat;
  background-position: center;
  background-size: cover;
  height: 100%;
}
.user-form {
  position: relative;
  top: 25%;
  margin: 0 auto;
  width: 320px;
  border-radius: 25px;
  padding: 1.5em 2em 0.5em 2em;
  background: var(--grey);
  box-shadow: 0 0 10px gray;
}
.user-button {
  font-weight: 900;
  width: 100%;
}
@media screen and (max-width: 600px) {
  .user-form {
    top: 0;
    width: 100%;
    border-radius: 0px;
    box-sizing: border-box;
  }
}
</style>
<script>
export default {
  data () {
    // 登录用户名校验
    var validateUserName = (rules, value, callback) => {
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
    // 确认密码格式校验
    var validateCheckPassword = (rules, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.registerForm.userPassword) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      // 初始化表单为登录
      activeName: 'login',
      // 按钮点击倒计时
      btnTime: 60,
      // 初始化全屏加载
      fullscreenLoading: false,
      loginForm: { userName: '', userPassword: '' },
      registerForm: {
        userEmail: '',
        userPassword: '',
        checkPassword: ''
      },
      rules: {
        userName: [{ validator: validateUserName, trigger: 'blur' }],
        userPassword: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 24, message: '密码长度为6~24个字符', trigger: 'blur' }
        ],
        checkPassword: [{ validator: validateCheckPassword, trigger: 'blur' }],
        userEmail: [
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { type: 'email', message: '邮箱格式不正确', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    // 登录入口
    login () {
      var _this = this
      this.$refs['loginForm'].validate(valid => {
        if (valid) {
          this.fullscreenLoading = true
          this.$axios
            .post('/user/login', {
              userName: this.loginForm.userName,
              userPassword: this.loginForm.userPassword
            })
            .then(result => {
              this.fullscreenLoading = false
              if (result.data.returnCode === 'SUCCESS') {
                this.$message({
                  showClose: true,
                  message: result.data.returnMessage,
                  type: 'success'
                })
                _this.$store.commit('user', _this.loginForm)
                var path = this.$route.query.redirect
                this.$router.replace({
                  path: path === '/' || path === undefined ? '/home' : path
                })
              } else {
                this.$message({
                  showClose: true,
                  message: result.data.returnMessage,
                  type: 'error'
                })
              }
            })
            .catch(failResponse => {
              this.fullscreenLoading = false
              this.$message({
                showClose: true,
                message: failResponse,
                type: 'error'
              })
            })
        }
      })
    },
    // 注册入口
    register () {
      var _this = this
      this.$refs['registerForm'].validate(valid => {
        if (valid) {
          this.fullscreenLoading = true
          this.$axios
            .post('/user/register', {
              userEmail: this.registerForm.userEmail,
              userPassword: this.registerForm.userPassword
            })
            .then(result => {
              this.fullscreenLoading = false
              if (result.data.returnCode === 'SUCCESS') {
                this.$message({
                  showClose: true,
                  message: result.data.returnMessage,
                  type: 'success'
                })
                _this.$store.commit('user', {
                  userName: result.data.paraMap.user.userEmail,
                  userPassword: result.data.paraMap.user.userPassword
                })
                var path = this.$route.query.redirect
                this.$router.replace({
                  path: path === '/' || path === undefined ? '/home' : path
                })
              } else {
                this.$message({
                  showClose: true,
                  message: result.data.returnMessage,
                  type: 'error'
                })
              }
            })
            .catch(failResponse => {
              this.fullscreenLoading = false
              this.$message({
                showClose: true,
                message: failResponse,
                type: 'error'
              })
            })
        }
      })
    },
    // 重置表单
    resetForm () {
      this.$refs['loginForm'].resetFields()
      this.$refs['registerForm'].resetFields()
    }
  }
}
</script>

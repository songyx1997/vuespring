<template>
  <body class="user-background">
    <div class="user-panal">
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
                <el-button class="user-button" type="primary" @click="login"
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
              <el-form-item prop="mailCode">
                <el-input
                  prefix-icon="el-icon-edit-outline"
                  v-model="registerForm.mailCode"
                  placeholder="6位数字验证码"
                >
                  <el-button type="text" slot="suffix" @click="sendMailCode"
                    >获取验证码&nbsp;</el-button
                  >
                </el-input>
              </el-form-item>
              <el-form-item>
                <el-button class="user-button" type="primary" @click="register"
                  >注册</el-button
                >
              </el-form-item>
            </el-form>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </body>
</template>
<style>
body {
  /* 覆盖掉浏览器样式 */
  margin: 0px;
}
.user-background {
  background: url('../assets/user/background.jpg') no-repeat;
  background-position: bottom;
  height: 100vh;
  width: 100vw;
  position: fixed;
}
.user-panal {
  position: relative;
  top: 30vh;
}
#tab-login {
  font-weight: 900;
}
#tab-register {
  font-weight: 900;
}
.user-form {
  margin: 0px auto;
  width: 20em;
  /* 四角变圆 */
  border-radius: 25px;
  padding: 1.5em 2em 0.5em 2em;
  background: #e4e7ed;
  box-shadow: 0 0 25px gray;
}
.user-button {
  font-weight: 900;
  width: 100%;
}
</style>
<script>
export default {
  name: 'User',
  data () {
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
    var validateMailCode = (rules, value, callback) => {
      var checkCodePatt = new RegExp('^\\d{6}$')
      if (value === '') {
        callback(new Error('请输入验证码'))
      } else if (!checkCodePatt.test(value)) {
        callback(new Error('验证码格式不正确'))
      } else {
        callback()
      }
    }
    return {
      activeName: 'register',
      loginForm: { userName: '', userPassword: '' },
      registerForm: { userEmail: '', mailCode: '' },
      rules: {
        userName: [{ validator: validateUserName, trigger: 'blur' }],
        userPassword: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 24, message: '密码长度为6~24个字符', trigger: 'blur' }
        ],
        userEmail: [
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { type: 'email', message: '邮箱格式不正确', trigger: 'blur' }
        ],
        mailCode: [{ validator: validateMailCode, trigger: 'blur' }]
      }
    }
  },
  methods: {
    login () {
      this.$refs['loginForm'].validate(valid => {
        if (valid) {
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
      })
    },
    sendMailCode () {
      this.$axios.post('/user/sendMailCode', {
        userEmail: this.registerForm.userEmail
      })
    },
    register () {
      this.$refs['registerForm'].validate(valid => {
        if (valid) {
          console.log('注册测试')
        }
      })
    },
    resetForm () {
      this.$refs['loginForm'].resetFields()
      this.$refs['registerForm'].resetFields()
    }
  }
}
</script>

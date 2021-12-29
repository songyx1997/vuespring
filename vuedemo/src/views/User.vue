<template>
  <div class="user-background">
    <div class="user-form">
      <el-tabs v-model="activeName" @tab-click="resetForm">
        <el-tab-pane label="登 录" name="login">
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
                >登 录</el-button
              >
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="注 册" name="register">
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
                >注 册</el-button
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
import { successInfo, errorInfo } from '@/utils/message'
import { checkUserName, checkPasswordRepeat } from '@/utils/validate'
export default {
  data () {
    return {
      // 初始化表单为登录
      activeName: 'login',
      // 初始化全屏加载
      fullscreenLoading: false,
      loginForm: { userName: '', userPassword: '' },
      registerForm: {
        userEmail: '',
        userPassword: '',
        checkPassword: ''
      },
      rules: {
        userName: [{ validator: checkUserName, trigger: 'blur' }],
        userPassword: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 5, max: 24, message: '密码长度为5~24个字符', trigger: 'blur' }
        ],
        checkPassword: [
          {
            validator: (rule, value, callback) =>
              checkPasswordRepeat(
                rule,
                value,
                callback,
                this.registerForm.userPassword
              ),
            trigger: 'blur'
          }
        ],
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
                this.selectUserInfo(result.data.paraMap.user.userId)
              } else {
                errorInfo(result.data.returnMessage)
              }
            })
            .catch(failResponse => {
              this.fullscreenLoading = false
              errorInfo(failResponse)
            })
        }
      })
    },
    // 注册入口
    register () {
      let _this = this
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
                successInfo(result.data.returnMessage)
                // 记录用户信息
                _this.$store.dispatch(
                  'user/getUserInfo',
                  result.data.paraMap.user
                )
                this.$router.push({ path: '/home' })
              } else {
                errorInfo(result.data.returnMessage)
              }
            })
            .catch(failResponse => {
              this.fullscreenLoading = false
              errorInfo(failResponse)
            })
        }
      })
    },
    // 重置表单
    resetForm () {
      this.$refs['loginForm'].resetFields()
      this.$refs['registerForm'].resetFields()
    },
    // 查询用户信息（通过用户编号）
    selectUserInfo (userId) {
      this.$axios
        .get('/user/selectUserInfo', {
          params: {
            userId: userId
          }
        })
        .then(result => {
          // 记录新的用户信息
          this.$store.dispatch('user/getUserInfo', result.data)
          this.$router.replace({ path: '/home' })
        })
        .catch(failResponse => {
          errorInfo(failResponse)
        })
    }
  }
}
</script>

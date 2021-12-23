<template>
  <div class="edit-form">
    <el-form
      ref="editPasswordForm"
      :model="editPasswordForm"
      :rules="rules"
      label-width="0px"
    >
      <el-form-item prop="oldPassword">
        <el-input
          prefix-icon="el-icon-lock"
          v-model="editPasswordForm.oldPassword"
          type="password"
          placeholder="旧密码"
        ></el-input>
      </el-form-item>
      <el-form-item prop="userPassword">
        <el-input
          prefix-icon="el-icon-lock"
          v-model="editPasswordForm.userPassword"
          type="password"
          placeholder="新密码"
        ></el-input>
      </el-form-item>
      <el-form-item prop="checkPassword">
        <el-input
          prefix-icon="el-icon-lock"
          v-model="editPasswordForm.checkPassword"
          type="password"
          placeholder="确认密码"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          @click="edit"
          v-loading.fullscreen.lock="fullscreenLoading"
          >提 交</el-button
        >
        <el-button @click="resetForm">重 置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<style scoped>
.edit-form {
  margin: 0px auto;
  padding-top: 25px;
  max-width: 320px;
}
</style>
<script>
import { newCheckPasswordRepeat, checkPasswordRepeat } from '@/utils/validate'
import { successInfo, errorInfo } from '@/utils/message'
export default {
  data () {
    return {
      // 初始化全屏加载
      fullscreenLoading: false,
      editPasswordForm: {
        oldPassword: '',
        userPassword: '',
        checkPassword: ''
      },
      rules: {
        oldPassword: [
          { required: true, message: '请输入旧密码', trigger: 'blur' },
          { min: 5, max: 24, message: '密码长度为5~24个字符', trigger: 'blur' }
        ],
        userPassword: [
          {
            validator: (rule, value, callback) =>
              newCheckPasswordRepeat(
                rule,
                value,
                callback,
                this.editPasswordForm.oldPassword
              ),
            trigger: 'blur'
          },
          { min: 5, max: 24, message: '密码长度为5~24个字符', trigger: 'blur' }
        ],
        checkPassword: [
          {
            validator: (rule, value, callback) =>
              checkPasswordRepeat(
                rule,
                value,
                callback,
                this.editPasswordForm.userPassword
              ),
            trigger: 'blur'
          }
        ]
      }
    }
  },
  methods: {
    edit () {
      this.$refs['editPasswordForm'].validate(valid => {
        if (valid) {
          this.fullscreenLoading = true
          let user = JSON.parse(window.localStorage.getItem('user'))
          this.$axios
            .post('/user/editPassword', {
              userId: user.userId,
              userPassword: this.editPasswordForm.oldPassword,
              ext1: this.editPasswordForm.userPassword
            })
            .then(result => {
              this.fullscreenLoading = false
              if (result.data.returnCode === 'SUCCESS') {
                successInfo(result.data.returnMessage)
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
      this.$refs['editPasswordForm'].resetFields()
    }
  }
}
</script>

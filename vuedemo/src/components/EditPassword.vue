<template>
  <div class="edit-form">
    <el-form ref="editPasswordForm" :model="editPasswordForm" label-width="0px">
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
        <el-button type="primary">提交</el-button>
        <el-button>重置</el-button>
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
export default {
  data () {
    return {
      editPasswordForm: {
        oldPassword: '',
        userPassword: '',
        checkPassword: ''
      }
    }
  }
}
</script>

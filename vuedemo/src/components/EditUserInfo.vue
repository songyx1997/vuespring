<template>
  <div style="display:inline-block">
    <el-button
      type="primary"
      icon="el-icon-edit"
      size="mini"
      circle
      plain
      @click="open"
    ></el-button>
    <el-dialog
      title="个人信息修改"
      :visible.sync="formVisible"
      :close-on-click-modal="false"
    >
      <el-form
        ref="editForm"
        :model="editForm"
        :rules="rules"
        label-width="0px"
        v-loading="loading"
      >
        <el-form-item prop="userName">
          <el-input
            prefix-icon="el-icon-user"
            v-model="editForm.userName"
            placeholder="用户名"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="editForm.groupId" filterable placeholder="项目组">
            <el-option
              v-for="group in groups"
              :key="group.groupId"
              :label="group.groupName"
              :value="group.groupId"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="userPhone">
          <el-input
            prefix-icon="el-icon-phone"
            v-model="editForm.userPhone"
            placeholder="手机号"
          ></el-input>
        </el-form-item>
        <el-form-item prop="userEmail">
          <el-input
            prefix-icon="el-icon-message"
            v-model="editForm.userEmail"
            placeholder="邮箱"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="resetForm">取 消</el-button>
        <el-button type="primary" @click="confirm">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { successInfo, errorInfo } from '@/utils/message'
import { onlyCheckUserName, checkPhone } from '@/utils/validate'
export default {
  data () {
    return {
      // 初始化全屏加载
      loading: false,
      // 初始化弹框不可见
      formVisible: false,
      editForm: {
        userName: this.$store.getters.userInfo.userName,
        userPhone: this.$store.getters.userInfo.userPhone,
        groupId: this.$store.getters.userInfo.groupId,
        userEmail: this.$store.getters.userInfo.userEmail
      },
      groups: [],
      rules: {
        userName: [{ validator: onlyCheckUserName, trigger: 'blur' }],
        userPhone: [{ validator: checkPhone, trigger: 'blur' }],
        userEmail: [
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { type: 'email', message: '邮箱格式不正确', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    open () {
      this.loading = true
      // 获取所有项目组
      this.$axios
        .get('/group/getAllGroups')
        .then(result => {
          this.loading = false
          let defaultGroup = {}
          defaultGroup.groupId = ''
          defaultGroup.groupName = '无'
          result.data.splice(0, 0, defaultGroup)
          this.groups = result.data
          // 打开弹框
          this.formVisible = true
        })
        .catch(failResponse => {
          this.loading = false
          errorInfo(failResponse)
        })
    },
    confirm () {
      let _this = this
      this.$refs['editForm'].validate(valid => {
        if (valid) {
          this.loading = true
          this.$axios
            .post('/user/editUserInfo', {
              userId: this.$store.getters.userInfo.userId,
              userName: this.editForm.userName,
              userPhone: this.editForm.userPhone,
              groupId: this.editForm.groupId,
              userEmail: this.editForm.userEmail
            })
            .then(result => {
              this.loading = false
              if (result.data.returnCode === 'SUCCESS') {
                // 记录新的用户信息
                _this.$store.dispatch(
                  'user/getUserInfo',
                  result.data.paraMap.user
                )
                this.resetForm()
                successInfo(result.data.returnMessage)
              } else {
                errorInfo(result.data.returnMessage)
              }
            })
            .catch(failResponse => {
              this.loading = false
              errorInfo(failResponse)
            })
        }
      })
    },
    // 重置表单
    resetForm () {
      // 关闭弹框
      this.formVisible = false
      this.$refs['editForm'].resetFields()
      this.editForm.userName = this.$store.getters.userInfo.userName
      this.editForm.userPhone = this.$store.getters.userInfo.userPhone
      this.editForm.groupId = this.$store.getters.userInfo.groupId
      this.editForm.userEmail = this.$store.getters.userInfo.userEmail
    }
  }
}
</script>

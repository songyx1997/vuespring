<template>
  <div style="display:inline-block">
    <el-button
      type="primary"
      icon="el-icon-edit"
      size="mini"
      circle
      plain
      @click="formVisible = true"
    ></el-button>
    <el-dialog title="个人信息修改" :visible.sync="formVisible">
      <el-form ref="editForm" :model="editForm" label-width="0px">
        <el-form-item>
          <el-input
            prefix-icon="el-icon-user"
            v-model="editForm.userName"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            prefix-icon="el-icon-house"
            v-model="editForm.groupId"
            placeholder="请输入项目组"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            prefix-icon="el-icon-phone"
            v-model="editForm.userPhone"
            placeholder="请输入手机号"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            prefix-icon="el-icon-message"
            v-model="editForm.userEmail"
            placeholder="请输入邮箱号"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="formVisible = false">取 消</el-button>
        <el-button type="primary" @click="formVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data () {
    return {
      // 初始化弹框不可见
      formVisible: false,
      editForm: {
        userName: this.$store.getters.userInfo.userName,
        groupId: this.$store.getters.userInfo.groupId,
        userPhone: this.$store.getters.userInfo.userPhone,
        userEmail: this.$store.getters.userInfo.userEmail
      }
    }
  }
}
</script>

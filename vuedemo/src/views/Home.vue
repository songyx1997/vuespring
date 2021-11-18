<template>
  <el-row :gutter="20">
    <el-col style="padding-bottom:20px" :xs="24" :sm="5">
      <user-info-card></user-info-card>
    </el-col>
    <el-col :xs="24" :sm="19">
      <el-tabs v-model="activeName" type="border-card">
        <el-tab-pane name="notes">
          <span slot="label"
            ><i class="el-icon-edit-outline"></i>&nbsp;学习笔记</span
          >
          <div class="home-notes">
            <article class="markdown-body"><notes></notes></article>
          </div>
        </el-tab-pane>
        <el-tab-pane name="editPassword">
          <span slot="label"><i class="el-icon-lock"></i>&nbsp;修改密码</span>
          <edit-password></edit-password>
        </el-tab-pane>
      </el-tabs>
    </el-col>
  </el-row>
</template>
<style scoped>
.home-notes {
  text-align: left;
}
</style>
<script>
import UserInfoCard from '../components/UserInfoCard.vue'
import EditPassword from '../components/EditPassword.vue'
import notes from '../assets/Notes.md'
export default {
  name: 'Home',
  components: {
    UserInfoCard,
    EditPassword,
    notes
  },
  data () {
    return {
      activeName: 'notes'
    }
  }
}
</script>

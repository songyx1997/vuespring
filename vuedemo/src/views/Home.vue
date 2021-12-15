<template>
  <el-row :gutter="20">
    <el-col style="padding-bottom:20px" :xs="24" :sm="24" :lg="5">
      <user-info-card></user-info-card>
    </el-col>
    <el-col :xs="24" :sm="24" :lg="19">
      <el-tabs v-model="activeName" type="border-card">
        <el-tab-pane name="notes">
          <span slot="label"
            ><i class="el-icon-edit-outline"></i>&nbsp;CSS笔记</span
          >
          <div class="home-notes">
            <article class="markdown-body"><notes></notes></article>
          </div>
        </el-tab-pane>
        <el-tab-pane name="vuenotes">
          <span slot="label"
            ><i class="el-icon-edit-outline"></i>&nbsp;VUE笔记</span
          >
          <div class="home-notes">
            <article class="markdown-body"><vue-notes></vue-notes></article>
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
import Notes from '../assets/Notes.md'
import VueNotes from '../assets/VueNotes.md'
export default {
  components: {
    UserInfoCard,
    EditPassword,
    Notes,
    VueNotes
  },
  data () {
    return {
      activeName: 'notes'
    }
  }
}
</script>

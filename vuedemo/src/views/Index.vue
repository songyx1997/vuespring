<template>
  <el-container>
    <el-aside><scroll-menu></scroll-menu></el-aside>
    <el-container
      ><el-header style="height:50px;padding:0px"
        ><nav-menu @navClick="navClick"></nav-menu
      ></el-header>
      <el-main>
        <el-row :gutter="20">
          <el-col :xs="24" :sm="6">
            <user-info-card></user-info-card>
          </el-col>
          <el-col :xs="24" :sm="18">
            <el-tabs v-model="activeName" type="border-card">
              <el-tab-pane name="date">
                <span slot="label"><i class="el-icon-date"></i>&nbsp;日程</span>
                <calendar></calendar>
              </el-tab-pane>
              <el-tab-pane name="editPassword">
                <span slot="label"
                  ><i class="el-icon-lock"></i>&nbsp;修改密码</span
                >
                <edit-password></edit-password>
              </el-tab-pane>
              <el-tab-pane name="notes">
                <span slot="label"
                  ><i class="el-icon-edit-outline"></i>&nbsp;学习笔记</span
                >
                <div class="index-notes">
                  <article class="markdown-body"><notes></notes></article>
                </div>
              </el-tab-pane>
            </el-tabs>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </el-container>
</template>
<style>
.index-notes {
  text-align: left;
}
</style>
<script>
import NavMenu from '../components/NavMenu.vue'
import ScrollMenu from '../components/ScrollMenu.vue'
import UserInfoCard from '../components/UserInfoCard.vue'
import Calendar from '../components/Calendar.vue'
import EditPassword from '../components/EditPassword.vue'
import notes from '../assets/Notes.md'
import ResizeHandler from '../utils/resizeHandle'
export default {
  name: 'Home',
  components: {
    NavMenu,
    ScrollMenu,
    UserInfoCard,
    Calendar,
    EditPassword,
    notes,
    ResizeHandler
  },
  // 混入
  mixins: [ResizeHandler],
  data () {
    return {
      activeName: 'date'
    }
  },
  methods: {
    navClick () {
      this.$store.dispatch('reverseSideBar')
    }
  }
}
</script>

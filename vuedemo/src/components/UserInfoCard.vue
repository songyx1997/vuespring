<template>
  <el-card>
    <div slot="header" class="clearfix">
      <div class="card-title-font">
        <i class="el-icon-user"></i>&nbsp;个人中心
        <edit-user-info></edit-user-info>
      </div>
    </div>
    <el-avatar :size="100"
      ><span class="card-avatar">{{ user.avatar }}</span></el-avatar
    >
    <div class="card-name">{{ user.userName }}</div>
    <div class="card-content-font">{{ user.userRole }}</div>
    <div class="card-info">
      <div class="card-li">
        <div class="card-title card-title-font">
          <i class="el-icon-house"></i>&nbsp;项目组
        </div>
        <span class="card-content-font">{{ user.groupId }}</span>
      </div>
      <div class="card-li">
        <div class="card-title card-title-font">
          <i class="el-icon-mobile-phone"></i>&nbsp;手机
        </div>
        <span class="card-content-font">{{ user.userPhone }}</span>
      </div>
      <div class="card-li">
        <div class="card-title card-title-font">
          <i class="el-icon-message"></i>&nbsp;邮箱
        </div>
        <span class="card-content-font">{{ user.userEmail }}</span>
      </div>
    </div>
  </el-card>
</template>
<style scoped>
.card-avatar {
  color: var(--blue);
  font-size: 40px;
}
.card-name {
  padding: 10px 0px;
}
.card-title-font {
  font-weight: bold;
  font-size: 14px;
  color: black;
}
.card-content-font {
  font-weight: 400;
  font-size: 14px;
  color: grey;
}
.card-info {
  text-align: left;
}
.card-li {
  padding-top: 15px;
}
.card-title {
  border-bottom: 1px dashed var(--grey);
  padding-bottom: 10px;
  margin-bottom: 10px;
}
</style>
<script>
import EditUserInfo from './EditUserInfo.vue'
export default {
  components: {
    EditUserInfo
  },
  computed: {
    user () {
      let user = this.$store.getters.userInfo
      return {
        userName: user.userName,
        groupId: user.groupId == null ? '无' : user.groupId,
        userRole: user.userRole === '0' ? 'admin' : 'general',
        userPhone: user.userPhone == null ? '无' : user.userPhone,
        userEmail: user.userEmail == null ? '无' : user.userEmail,
        avatar: user.userName.charAt(0).toUpperCase()
      }
    }
  }
}
</script>

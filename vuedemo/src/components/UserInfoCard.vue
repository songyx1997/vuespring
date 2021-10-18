<template>
  <el-card>
    <div class="card-avatar">
      <el-avatar :size="100" :src="user.avatarUrl"></el-avatar>
      <div class="card-name">{{ user.name }}</div>
      <div class="card-identity">{{ user.identity }}</div>
    </div>
  </el-card>
</template>
<style scoped>
.card-avatar {
  padding-top: 4px;
  border-radius: 10px;
}
</style>
<script>
import avatar from '@/assets/avatar.gif'
export default {
  name: 'UserInfoCard',
  data () {
    return {
      user: {
        name: 'songyx',
        identity: 'admin',
        avatarUrl: avatar
      }
    }
  }
}
</script>

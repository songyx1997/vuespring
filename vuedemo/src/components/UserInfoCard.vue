<template>
  <el-card>
    <div slot="header" class="clearfix">
      <div class="card-title-font">
        <i class="el-icon-user"></i>&nbsp;个人中心
      </div>
    </div>
    <div class="card-avatar">
      <el-avatar :size="100" :src="user.avatarUrl"></el-avatar>
      <div class="card-name">{{ user.name }}</div>
      <div class="card-content-font">{{ user.identity }}</div>
    </div>
    <div class="card-info">
      <div class="card-li">
        <div class="card-title card-title-font">
          <i class="el-icon-mobile-phone"></i>&nbsp;手机
        </div>
        <span class="card-content-font">{{ user.phone }}</span>
      </div>
      <div class="card-li">
        <div class="card-title card-title-font">
          <i class="el-icon-message"></i>&nbsp;邮箱
        </div>
        <span class="card-content-font">{{ user.email }}</span>
      </div>
    </div>
  </el-card>
</template>
<style scoped>
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
  border-bottom: 1px solid var(--grey);
  padding-bottom: 10px;
  margin-bottom: 10px;
}
</style>
<script>
import avatar from '@/assets/avatar.gif'
export default {
  data () {
    return {
      user: {
        name: 'Songyx',
        identity: 'admin',
        phone: '13076058182',
        email: '1048461309@qq.com',
        avatarUrl: avatar
      }
    }
  }
}
</script>

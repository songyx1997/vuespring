<template>
  <body>
    <el-container>
      <el-aside style="width:210px"><scroll-menu></scroll-menu></el-aside>
      <el-container
        ><el-header style="height:50px;padding:0px"
          ><nav-menu @navClick="navClick"></nav-menu
        ></el-header>
        <el-main>
          <el-row :gutter="20">
            <el-col :xs="24" :sm="6">
              <el-card class="box-card"> </el-card>
            </el-col>
            <el-col :xs="24" :sm="18">
              <el-tabs v-model="activeName" type="border-card">
                <el-tab-pane name="timeline">
                  <span slot="label"
                    ><i class="el-icon-s-promotion"></i>&nbsp;时间线</span
                  >
                </el-tab-pane>
                <el-tab-pane name="account">
                  <span slot="label"
                    ><i class="el-icon-user-solid"></i>&nbsp;个人中心</span
                  >
                </el-tab-pane>
              </el-tabs>
            </el-col>
          </el-row>
        </el-main>
      </el-container>
    </el-container>
  </body>
</template>
<style></style>
<script>
import NavMenu from '../components/NavMenu.vue'
import ScrollMenu from '../components/ScrollMenu.vue'
export default {
  name: 'Home',
  components: {
    NavMenu,
    ScrollMenu
  },
  data () {
    return {
      activeName: 'account'
    }
  },
  methods: {
    navClick () {
      console.log('父类方法调用测试')
    }
  }
}
</script>

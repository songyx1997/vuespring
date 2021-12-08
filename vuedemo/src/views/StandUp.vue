<template>
  <el-row :gutter="20">
    <el-col :xs="24" :sm="24" :lg="8">
      <div class="standup-chart">
        <time-line></time-line>
      </div>
    </el-col>
    <el-col :xs="24" :sm="24" :lg="16">
      <div class="standup-chart">
        <line-chart></line-chart>
      </div>
    </el-col>
    <el-col :xs="24" :sm="24">
      <el-tabs v-model="activeName" type="border-card">
        <el-tab-pane name="improvement">
          <span slot="label"><i class="el-icon-edit"></i>&nbsp;改进项</span>
        </el-tab-pane>
        <el-tab-pane name="followUpItem">
          <span slot="label"><i class="el-icon-view"></i>&nbsp;跟进项</span>
        </el-tab-pane>
        <el-tab-pane name="riskItem">
          <span slot="label"><i class="el-icon-loading"></i>&nbsp;风险项</span>
        </el-tab-pane>
      </el-tabs>
    </el-col>
  </el-row>
</template>
<style scoped>
.standup-chart {
  background: white;
  margin-bottom: 20px;
}
</style>
<script>
import TimeLine from '../components/standUpPages/TimeLine.vue'
import LineChart from '../components/standUpPages/LineChart .vue'
export default {
  components: {
    TimeLine,
    LineChart
  },
  data () {
    return {
      activeName: 'improvement'
    }
  }
}
</script>

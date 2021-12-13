<template>
  <el-row :gutter="20">
    <el-col :xs="24" :sm="24" :lg="10">
      <div class="standup-chart">
        <turn-table></turn-table>
      </div>
    </el-col>
    <el-col :xs="24" :sm="24" :lg="14">
      <div class="standup-chart">
        <line-chart></line-chart>
      </div>
    </el-col>
    <el-col :xs="24" :sm="24">
      <el-tabs v-model="activeName" type="border-card">
        <el-tab-pane name="log">
          <span slot="label"><i class="el-icon-tickets"></i>&nbsp;日志</span>
          <log-table></log-table>
        </el-tab-pane>
        <el-tab-pane name="improvement">
          <span slot="label"
            ><i class="el-icon-edit-outline"></i>&nbsp;改进项</span
          >
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
import LineChart from '../components/standUpPages/LineChart .vue'
import LogTable from '../components/standUpPages/LogTable.vue'
import TurnTable from '../components/standUpPages/TurnTable.vue'
export default {
  components: {
    TurnTable,
    LineChart,
    LogTable
  },
  data () {
    return {
      activeName: 'log'
    }
  }
}
</script>

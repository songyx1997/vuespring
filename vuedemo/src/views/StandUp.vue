<template>
  <el-row :gutter="32">
    <el-col :xs="24" :sm="12">
      <div class="standup-chart">
        <turn-table></turn-table>
      </div>
    </el-col>
    <el-col :xs="24" :sm="12">
      <div class="standup-chart">
        <bar-graph></bar-graph>
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
import TurnTable from '../components/standUpPages/TurnTable.vue'
import BarGraph from '../components/standUpPages/BarGraph.vue'
export default {
  components: {
    TurnTable,
    BarGraph
  },
  data () {
    return {
      activeName: 'improvement'
    }
  }
}
</script>

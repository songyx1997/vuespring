<template>
  <el-row :gutter="20">
    <el-col :xs="24" :sm="24" :lg="10">
      <div class="standup-chart">
        <turn-table></turn-table>
      </div>
    </el-col>
    <el-col :xs="24" :sm="24" :lg="14">
      <div class="standup-chart">
        <histogram-chart></histogram-chart>
      </div>
    </el-col>
    <el-col :xs="24" :sm="24" style="padding-top: 20px;">
      <improvement-table></improvement-table>
    </el-col>
    <el-col :xs="24" :sm="24" style="padding-top: 20px;">
      <log-table></log-table>
    </el-col>
  </el-row>
</template>
<style scoped>
.standup-chart {
  background: white;
}
.el-tabs--border-card {
  /* 清除卡片样式 */
  border: 0;
  box-shadow: none;
}
</style>
<script>
import HistogramChart from '../components/standUpPages/HistogramChart .vue'
import LogTable from '../components/standUpPages/LogTable.vue'
import ImprovementTable from '../components/standUpPages/ImprovementTable.vue'
import TurnTable from '../components/standUpPages/TurnTable.vue'
export default {
  components: {
    TurnTable,
    HistogramChart,
    LogTable,
    ImprovementTable
  }
}
</script>

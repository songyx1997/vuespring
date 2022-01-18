<template>
  <el-row :gutter="20">
    <el-col :xs="24" :sm="24" :lg="12">
      <div class="standup-chart">
        <turn-table></turn-table>
      </div>
    </el-col>
    <el-col :xs="24" :sm="24" :lg="12">
      <div class="standup-chart">
        <histogram-chart></histogram-chart>
      </div>
    </el-col>
    <el-col :xs="24" :sm="24">
      <log-table></log-table>
    </el-col>
    <el-col :xs="24" :sm="24">
      <improvement-table></improvement-table>
    </el-col>
  </el-row>
</template>
<style scoped>
.el-col {
  padding-bottom: 20px;
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

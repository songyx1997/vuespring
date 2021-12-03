<template>
  <el-row :gutter="20">
    <el-col :xs="24" :sm="8">
      <turn-table></turn-table>
    </el-col>
    <el-col :xs="24" :sm="16">
      <bar-graph></bar-graph>
    </el-col>
    <el-col :xs="24" :sm="24">
      <el-tabs v-model="activeName" type="border-card">
        <el-tab-pane name="improvement">
          <span slot="label"
            ><i class="el-icon-edit-outline"></i>&nbsp;改进项</span
          >
        </el-tab-pane>
        <el-tab-pane name="followUpItem">
          <span slot="label"
            ><i class="el-icon-edit-outline"></i>&nbsp;跟进项</span
          >
        </el-tab-pane>
        <el-tab-pane name="riskItem">
          <span slot="label"
            ><i class="el-icon-edit-outline"></i>&nbsp;风险项</span
          >
        </el-tab-pane>
      </el-tabs>
    </el-col>
  </el-row>
</template>
<style scoped>
.table-config {
  margin: 0px auto;
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

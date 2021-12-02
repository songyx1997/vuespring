<template>
  <el-card>
    <el-table :data="tableData" highlight-current-row>
      <el-table-column type="index" width="30"> </el-table-column>
      <el-table-column property="lottery" label="抽奖人" width="80">
      </el-table-column>
      <el-table-column property="winner" label="中奖人" width="80">
      </el-table-column>
      <el-table-column property="time" label="时间"> </el-table-column>
    </el-table>
    <div class="table-button">
      <el-button type="primary">排序</el-button>
      <el-button type="danger">删除</el-button>
    </div>
  </el-card>
</template>
<style scoped>
.table-button {
  padding-top: 20px;
}
</style>
<script>
export default {
  data () {
    return {
      tableData: [
        {
          lottery: 'songyx1',
          winner: 'songyx2',
          time: '2016-05-02 16:45:20'
        },
        {
          lottery: 'songyx3',
          winner: 'songyx4',
          time: '2016-05-03 07:11:23'
        }
      ],
      currentRow: null
    }
  }
}
</script>

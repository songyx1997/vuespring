<template>
  <el-tabs v-model="activeName" type="border-card">
    <el-tab-pane name="log">
      <span slot="label"><i class="el-icon-tickets"></i>&nbsp;日志</span>
      <el-table :data="tableData" highlight-current-row v-loading="loading">
        <el-table-column
          property="creationTime"
          :sortable="true"
          label="日志创建时间"
          min-width="160"
        >
        </el-table-column>
        <el-table-column property="lotteryUserName" label="抽奖人" width="100">
        </el-table-column>
        <el-table-column property="winnerUserName" label="中奖人" width="100">
        </el-table-column>
        <el-table-column width="75">
          <el-popconfirm
            icon="el-icon-info"
            icon-color="red"
            title="确定删除所选的日志吗？"
          >
            <el-button
              slot="reference"
              type="danger"
              icon="el-icon-delete"
              size="mini"
              round
              plain
            ></el-button>
          </el-popconfirm>
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="5"
        :total="total"
        :current-page="pageNum"
        @current-change="handleCurrentChange"
      >
      </el-pagination>
    </el-tab-pane>
  </el-tabs>
</template>
<style scoped></style>
<script>
import { errorInfo } from '@/utils/message'
export default {
  created () {
    // 初始化查询第一页
    this.search(0, 5)
  },
  data () {
    return {
      activeName: 'log',
      total: 0,
      pageNum: 1,
      loading: false,
      tableData: []
    }
  },
  methods: {
    search (offset, limit) {
      this.loading = true
      this.$axios
        .get('/lotteryLog/search', {
          params: {
            offset: offset,
            limit: limit
          }
        })
        .then(result => {
          if (result.data.total === 0) {
            this.total = 0
            this.tableData = []
            return
          }
          this.total = result.data.total
          this.tableData = result.data.list
          this.loading = false
        })
        .catch(failResponse => {
          this.loading = false
          errorInfo(failResponse)
        })
    },
    handleCurrentChange (val) {
      // 清空上一页数据
      this.tableData = []
      this.search((val - 1) * 5, 5)
    }
  }
}
</script>

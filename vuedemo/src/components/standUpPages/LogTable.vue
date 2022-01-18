<template>
  <base-panel>
    <template #headLeft> <i class="el-icon-tickets"></i>&nbsp;日志 </template>
    <template #body>
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
        <el-table-column width="80">
          <template slot-scope="scope">
            <el-button
              type="danger"
              size="mini"
              @click="deleteById(scope.row.id)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="5"
        :total="total"
        :current-page.sync="pageNum"
        @current-change="handleCurrentChange"
      >
      </el-pagination>
    </template>
  </base-panel>
</template>
<style scoped></style>
<script>
import { successInfo, errorInfo, cancelInfo } from '@/utils/message'
import BasePanel from '../BasePanel.vue'
export default {
  components: {
    BasePanel
  },
  created () {
    // 初始化查询第一页
    this.search(0, 5)
  },
  data () {
    return {
      total: 0,
      pageNum: 1,
      loading: false,
      tableData: []
    }
  },
  watch: {
    '$store.getters.monitorFlag': function () {
      let monitorFlag = this.$store.getters.monitorFlag
      if (monitorFlag) {
        this.pageNum = 1
        this.search(0, 5)
      }
    }
  },
  methods: {
    search (offset, limit) {
      this.loading = true
      this.$axios
        .get('/lotteryLog/search', {
          params: {
            offset: offset,
            limit: limit,
            lotteryUserId: this.$store.getters.userInfo.userId
          }
        })
        .then(result => {
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
    },
    deleteById (id) {
      this.$store.dispatch('monitor/endMonitor')
      this.$confirm('确定删除所选的日志吗？', '删除确认', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          this.loading = true
          this.$axios
            .get('/lotteryLog/delete', { params: { id: id } })
            .then(result => {
              this.loading = false
              if (result.data.returnCode === 'SUCCESS') {
                successInfo(result.data.returnMessage)
                this.pageNum = 1
                this.search(0, 5)
                // 记录监听状态
                this.$store.dispatch('monitor/startMonitor')
              } else {
                errorInfo(result.data.returnMessage)
              }
            })
            .catch(failResponse => {
              this.loading = false
              errorInfo(failResponse)
            })
        })
        .catch(() => cancelInfo('已取消'))
    }
  }
}
</script>

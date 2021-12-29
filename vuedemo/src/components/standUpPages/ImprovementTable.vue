<template>
  <el-tabs v-model="activeName" type="border-card">
    <el-tab-pane name="improvement">
      <span slot="label"><i class="el-icon-view"></i>&nbsp;改进项</span>
      <el-table :data="tableData" :max-height="400" highlight-current-row>
        <el-table-column label="操作" width="115">
          <el-button
            type="primary"
            icon="el-icon-edit"
            size="mini"
            round
            plain
          ></el-button>
          <el-popconfirm
            icon="el-icon-info"
            icon-color="red"
            title="确定删除所选的项目吗？"
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
        <el-table-column property="proposerUserName" label="提出人" width="100">
        </el-table-column>
        <el-table-column
          property="principalUserName"
          label="负责人"
          width="100"
        >
        </el-table-column>
        <el-table-column prop="itemStyle" label="类型" width="70">
          <template slot-scope="scope">
            <el-tag type="warning">{{ scope.row.itemStyle }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="state" label="状态" width="70">
          <template slot-scope="scope">
            <el-tag>{{ scope.row.state }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="priority" label="优先级" width="70">
          <template slot-scope="scope">
            <el-tag>{{ scope.row.priority }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          property="itemDescription"
          label="说明"
          min-width="400"
        >
        </el-table-column>
        <el-table-column property="measure" label="改进措施" min-width="200">
        </el-table-column>
        <el-table-column property="remark" label="备注" min-width="100">
        </el-table-column>
        <el-table-column
          property="creationTime"
          :sortable="true"
          label="创建时间"
          width="160"
        >
        </el-table-column>
      </el-table>
    </el-tab-pane>
  </el-tabs>
</template>
<script>
export default {
  data () {
    return {
      activeName: 'improvement',
      tableData: [
        {
          proposerUserName: '尼古拉斯',
          principalUserName: '阿列克谢',
          itemDescription: '',
          itemStyle: '风险项',
          measure: '',
          state: '活动',
          priority: '高',
          remark: '',
          creationTime: '2021-12-14 07:11:23'
        }
      ]
    }
  }
}
</script>

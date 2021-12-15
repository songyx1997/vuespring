<template>
  <div>
    <el-table border :data="tableData" :max-height="400" highlight-current-row>
      <el-table-column property="proposerUserName" label="提出人" width="100">
      </el-table-column>
      <el-table-column property="principalUserName" label="负责人" width="100">
      </el-table-column>
      <el-table-column property="itemDescription" label="说明">
      </el-table-column>
      <el-table-column property="measure" label="改进措施"> </el-table-column>
      <el-table-column property="state" label="状态"> </el-table-column>
      <el-table-column property="priority" label="优先级"> </el-table-column>
      <el-table-column property="remark" label="备注"> </el-table-column>
      <el-table-column
        property="creationTime"
        :sortable="true"
        label="创建时间"
      >
      </el-table-column>
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
    </el-table>
  </div>
</template>
<script>
export default {
  data () {
    return {
      tableData: [
        {
          proposerUserName: '尼古拉斯',
          principalUserName: '阿列克谢',
          itemDescription: '',
          measure: '',
          state: '活动中',
          priority: '高',
          remark: '',
          creationTime: '2021-12-14 07:11:23'
        }
      ]
    }
  }
}
</script>

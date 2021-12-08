<template>
  <div class="line-panel">
    <el-table :data="tableData" :max-height="381" highlight-current-row>
      <el-table-column property="time" :sortable="true" label="日志创建时间">
      </el-table-column>
      <el-table-column property="lottery" label="抽奖者" width="100">
      </el-table-column>
      <el-table-column property="winner" label="中奖者" width="100">
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
  </div>
</template>
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
          time: '2017-05-03 07:11:23'
        },
        {
          lottery: 'songyx5',
          winner: 'songyx6',
          time: '2018-05-03 07:11:23'
        },
        {
          lottery: 'songyx7',
          winner: 'songyx8',
          time: '2019-05-03 07:11:23'
        },
        {
          lottery: 'songyx9',
          winner: 'songyx10',
          time: '2020-05-03 07:11:23'
        },
        {
          lottery: 'songyx11',
          winner: 'songyx12',
          time: '2021-05-03 07:11:23'
        }
      ]
    }
  }
}
</script>

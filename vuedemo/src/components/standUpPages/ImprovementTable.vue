<template>
  <el-tabs v-model="activeName" type="border-card">
    <el-tab-pane name="improvement">
      <span slot="label"
        ><i class="el-icon-view"></i>&nbsp;改进项&nbsp;<el-button
          type="text"
          icon="el-icon-plus"
          @click="openDialog"
        ></el-button
      ></span>
      <!-- 弹窗 -->
      <el-dialog
        title="改进项修改"
        :visible.sync="formVisible"
        :close-on-click-modal="false"
      >
        <el-form
          ref="itemForm"
          :model="itemForm"
          :inline="true"
          label-width="0px"
          v-loading="dialogLoading"
        >
          <el-form-item>
            <el-select
              v-model="itemForm.proposerUserName"
              filterable
              placeholder="提出人"
            >
              <!-- <el-option
              v-for="group in groups"
              :key="group.groupId"
              :label="group.groupName"
              :value="group.groupId"
            >
            </el-option> -->
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-select
              v-model="itemForm.principalUserName"
              filterable
              placeholder="负责人"
            >
              <!-- <el-option
              v-for="group in groups"
              :key="group.groupId"
              :label="group.groupName"
              :value="group.groupId"
            >
            </el-option> -->
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-select
              v-model="itemForm.itemStyle"
              filterable
              placeholder="类型"
            >
              <!-- <el-option
              v-for="group in groups"
              :key="group.groupId"
              :label="group.groupName"
              :value="group.groupId"
            >
            </el-option> -->
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-select v-model="itemForm.state" filterable placeholder="状态">
              <!-- <el-option
              v-for="group in groups"
              :key="group.groupId"
              :label="group.groupName"
              :value="group.groupId"
            >
            </el-option> -->
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-select
              v-model="itemForm.priority"
              filterable
              placeholder="优先级"
            >
              <!-- <el-option
              v-for="group in groups"
              :key="group.groupId"
              :label="group.groupName"
              :value="group.groupId"
            >
            </el-option> -->
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="resetForm">取 消</el-button>
          <el-button type="primary" @click="confirm">确 定</el-button>
        </div>
      </el-dialog>
      <!-- 展示表格 -->
      <el-table :data="tableData" :max-height="400" highlight-current-row>
        <el-table-column label="操作" width="125">
          <el-button
            type="primary"
            icon="el-icon-edit"
            size="mini"
            round
            plain
          ></el-button>
          <el-button
            type="danger"
            icon="el-icon-delete"
            size="mini"
            round
            plain
          ></el-button>
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
      // 初始化弹框不可见
      formVisible: false,
      dialogLoading: false,
      itemForm: {},
      users: {},
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
  },
  methods: {
    openDialog () {
      this.loading = true
      this.formVisible = true
      // // 获取所有项目组
      // this.$axios
      //   .get('/group/getAllGroups')
      //   .then(result => {
      //     this.loading = false
      //     let defaultGroup = {}
      //     defaultGroup.groupId = ''
      //     defaultGroup.groupName = '无'
      //     result.data.splice(0, 0, defaultGroup)
      //     this.groups = result.data
      //     // 打开弹框
      //     this.formVisible = true
      //   })
      //   .catch(failResponse => {
      //     this.loading = false
      //     errorInfo(failResponse)
      //   })
    },
    confirm () {
      console.log('测试')
    },
    // 重置表单
    resetForm () {
      // 关闭弹框
      this.formVisible = false
      this.$refs['itemForm'].resetFields()
    }
  }
}
</script>

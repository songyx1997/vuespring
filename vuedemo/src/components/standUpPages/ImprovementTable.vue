<template>
  <el-tabs v-model="activeName" type="border-card">
    <el-tab-pane name="improvement">
      <span slot="label" @click="openDialog">
        <el-tooltip
          class="item"
          effect="dark"
          content="点击新增改进项"
          placement="top-start"
        >
          <el-button type="text" icon="el-icon-view"></el-button> </el-tooltip
        >&nbsp;改进项</span
      >
      <!-- 弹窗 -->
      <el-dialog
        title="改进项新增"
        :visible.sync="formVisible"
        :close-on-click-modal="false"
      >
        <el-form
          ref="itemForm"
          :model="itemForm"
          label-position="top"
          v-loading="dialogLoading"
        >
          <el-row :gutter="15">
            <el-col :xs="12" :sm="12">
              <el-form-item label="提出人">
                <el-select
                  v-model="itemForm.proposerUserName"
                  filterable
                  placeholder="请选择"
                >
                  <el-option
                    v-for="member in members"
                    :key="member.id"
                    :label="member.name"
                    :value="member.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :xs="12" :sm="12">
              <el-form-item label="负责人">
                <el-select
                  v-model="itemForm.principalUserName"
                  filterable
                  placeholder="请选择"
                >
                  <el-option
                    v-for="member in members"
                    :key="member.id"
                    :label="member.name"
                    :value="member.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="15">
            <el-col :xs="8" :sm="8">
              <el-form-item label="类型">
                <el-select
                  v-model="itemForm.itemStyle"
                  filterable
                  placeholder="请选择"
                >
                  <el-option
                    v-for="itemStyle in itemStyles"
                    :key="itemStyle.id"
                    :label="itemStyle.name"
                    :value="itemStyle.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :xs="8" :sm="8">
              <el-form-item label="状态">
                <el-select
                  v-model="itemForm.state"
                  filterable
                  placeholder="请选择"
                >
                  <el-option
                    v-for="state in states"
                    :key="state.id"
                    :label="state.name"
                    :value="state.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :xs="8" :sm="8">
              <el-form-item label="优先级">
                <el-select
                  v-model="itemForm.priority"
                  filterable
                  placeholder="请选择"
                >
                  <el-option
                    v-for="priority in prioritys"
                    :key="priority.id"
                    :label="priority.name"
                    :value="priority.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="项目说明">
            <el-input
              type="textarea"
              v-model="itemForm.itemDescription"
            ></el-input>
          </el-form-item>
          <el-form-item label="措施">
            <el-input type="textarea" v-model="itemForm.measure"></el-input>
          </el-form-item>
          <el-form-item label="备注">
            <el-input type="textarea" v-model="itemForm.remark"></el-input>
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
<style scoped>
/* 调整表格样式 */
.el-form-item {
  margin: 0;
}
</style>
<script>
import { getSelections } from '@/utils/commonRequest'
export default {
  data () {
    return {
      activeName: 'improvement',
      // 初始化弹框不可见
      formVisible: false,
      dialogLoading: false,
      itemForm: {
        proposerUserName: this.$store.getters.userInfo.userId,
        principalUserName: this.$store.getters.userInfo.userId,
        itemStyle: '1',
        state: '0',
        priority: '1',
        itemDescription: '',
        measure: '',
        remark: ''
      },
      members: {},
      itemStyles: [
        { id: '0', name: '风险项' },
        { id: '1', name: '待改进项' },
        { id: '2', name: '跟进项' }
      ],
      states: [
        { id: '0', name: '待处理' },
        { id: '1', name: '活动中' },
        { id: '2', name: '已关闭' }
      ],
      prioritys: [
        { id: '0', name: '低' },
        { id: '1', name: '中' },
        { id: '2', name: '高' }
      ],
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
      // 获取同小组的成员
      this.members = getSelections(
        '/user/getUsers',
        {
          userId: this.$store.getters.userInfo.userId,
          userName: this.$store.getters.userInfo.userName
        },
        'userId',
        'userName',
        null
      )
      this.loading = false
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

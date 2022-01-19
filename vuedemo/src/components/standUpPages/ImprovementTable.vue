<template>
  <div>
    <base-panel>
      <template #headLeft><i class="el-icon-view"></i>&nbsp;改进项</template>
      <template #headRight>
        <el-button type="success" size="mini" @click="openDialog"
          >新增</el-button
        >
        <el-select
          style="width:110px"
          v-model="selectedItemStyle"
          size="mini"
          @change="handleChange"
        >
          <el-option
            v-for="itemStyle in itemStyles"
            :key="itemStyle.id"
            :label="itemStyle.name"
            :value="itemStyle.id"
          ></el-option>
        </el-select>
      </template>
      <template #body>
        <!-- 展示表格 -->
        <el-table
          :data="tableData"
          :max-height="400"
          highlight-current-row
          v-loading="loading"
        >
          <el-table-column label="操作" width="150">
            <el-button type="primary" size="mini">修改</el-button>
            <el-button type="danger" size="mini">删除</el-button>
          </el-table-column>
          <el-table-column
            property="proposerUserName"
            label="提出人"
            width="100"
          >
          </el-table-column>
          <el-table-column
            property="principalUserName"
            label="负责人"
            width="100"
          >
          </el-table-column>
          <el-table-column prop="itemStyle" label="类型" width="80">
            <template slot-scope="scope">
              <el-tag type="warning">{{ scope.row.itemStyle }}</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="state" label="状态" width="80">
            <template slot-scope="scope">
              <el-tag>{{ scope.row.state }}</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="priority" label="优先级" width="80">
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
    <!-- 弹窗 -->
    <el-dialog
      title="改进项新增"
      v-loading="loading"
      :visible.sync="formVisible"
      :close-on-click-modal="false"
    >
      <el-form
        ref="itemForm"
        :model="itemForm"
        label-position="top"
        v-loading="loading"
        :rules="rules"
      >
        <el-row :gutter="15">
          <el-col :xs="12" :sm="12">
            <el-form-item label="提出人">
              <el-select
                v-model="itemForm.proposerUserId"
                filterable
                placeholder="请选择"
              >
                <el-option
                  v-for="member in members"
                  :key="member.userId"
                  :label="member.userName"
                  :value="member.userId"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :xs="12" :sm="12">
            <el-form-item label="负责人">
              <el-select
                v-model="itemForm.principalUserId"
                filterable
                placeholder="请选择"
              >
                <el-option
                  v-for="member in members"
                  :key="member.userId"
                  :label="member.userName"
                  :value="member.userId"
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
        <el-form-item label="项目说明" prop="itemDescription">
          <el-input
            v-model="itemForm.itemDescription"
            type="textarea"
            maxlength="80"
            show-word-limit
          ></el-input>
        </el-form-item>
        <el-form-item label="措施">
          <el-input
            v-model="itemForm.measure"
            type="textarea"
            maxlength="80"
            show-word-limit
          ></el-input>
        </el-form-item>
        <el-form-item label="备注">
          <el-input
            v-model="itemForm.remark"
            type="textarea"
            maxlength="80"
            show-word-limit
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="resetForm">取 消</el-button>
        <el-button type="primary" @click="confirm">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { successInfo, errorInfo } from '@/utils/message'
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
      // 初始化弹框不可见
      formVisible: false,
      loading: false,
      defaultForm: {
        currentUserGroupId: this.$store.getters.userInfo.groupId,
        proposerUserId: this.$store.getters.userInfo.userId,
        principalUserId: this.$store.getters.userInfo.userId,
        itemStyle: '2',
        state: '1',
        priority: '1',
        itemDescription: '',
        measure: '',
        remark: ''
      },
      itemForm: {},
      members: {},
      itemStyles: [
        { id: '0', name: '风险项' },
        { id: '1', name: '跟进项' },
        { id: '2', name: '待改进项' }
      ],
      states: [
        { id: '0', name: '活动中' },
        { id: '1', name: '待处理' },
        { id: '2', name: '已关闭' }
      ],
      prioritys: [
        { id: '0', name: '低' },
        { id: '1', name: '中' },
        { id: '2', name: '高' }
      ],
      rules: {
        itemDescription: [
          { required: true, message: '请输入内容', trigger: 'blur' }
        ]
      },
      total: 0,
      pageNum: 1,
      tableData: [],
      // 初始化查询条件
      selectedItemStyle: '1'
    }
  },
  methods: {
    openDialog () {
      this.itemForm = { ...this.defaultForm }
      this.loading = true
      // 获取同小组的成员
      this.$axios
        .get('/user/getUsers', {
          params: {
            userId: this.$store.getters.userInfo.userId,
            userName: this.$store.getters.userInfo.userName
          }
        })
        .then(result => {
          this.members = result.data
        })
        .catch(failResponse => {
          errorInfo(failResponse)
        })
      this.loading = false
      this.formVisible = true
    },
    search (offset, limit) {
      this.loading = true
      this.$axios
        .get('/standUpItemRecord/search', {
          params: {
            offset: offset,
            limit: limit,
            currentUserGroupId: this.$store.getters.userInfo.groupId,
            itemStyle: this.selectedItemStyle
          }
        })
        .then(result => {
          this.total = result.data.total
          this.tableData =
            result.data.list == null ? [] : this.formatTable(result.data.list)
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
    confirm () {
      this.$refs['itemForm'].validate(valid => {
        if (valid) {
          this.loading = true
          this.$axios
            .post('/standUpItemRecord/add', this.itemForm)
            .then(result => {
              if (result.data.returnCode === 'SUCCESS') {
                this.resetForm()
                this.pageNum = 1
                this.search(0, 5)
                successInfo(result.data.returnMessage)
              } else {
                errorInfo(result.data.returnMessage)
              }
            })
            .catch(failResponse => {
              errorInfo(failResponse)
            })
          this.loading = false
        }
      })
    },
    handleChange (value) {
      this.selectedItemStyle = value
      this.search(0, 5)
    },
    // 重置表单
    resetForm () {
      // 关闭弹框
      this.formVisible = false
      this.$refs['itemForm'].resetFields()
      this.itemForm = { ...this.defaultForm }
    },
    formatTable (data) {
      for (let index = 0; index < data.length; index++) {
        data[index].itemStyle = this.getCn(
          data[index].itemStyle,
          this.itemStyles
        )
        data[index].state = this.getCn(data[index].state, this.states)
        data[index].priority = this.getCn(data[index].priority, this.prioritys)
      }
      return data
    },
    getCn (id, items) {
      for (let index = 0; index < items.length; index++) {
        if (items[index].id === id) return items[index].name
      }
    }
  }
}
</script>

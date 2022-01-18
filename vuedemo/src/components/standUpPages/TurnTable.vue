<template>
  <base-panel>
    <template #headLeft><i class="el-icon-loading"></i>&nbsp;转盘</template>
    <template #headRight>
      <el-select
        style="width:160px"
        v-model="selectedMembers"
        multiple
        collapse-tags
        size="mini"
        @change="handleChange"
      >
        <el-option
          v-for="prize in prizes"
          :key="prize.id"
          :label="prize.fonts[0].text"
          :value="prize.id"
        >
        </el-option>
      </el-select>
    </template>
    <template #body>
      <div v-if="showFlag" class="table-panel">
        <LuckyWheel
          ref="tableId"
          width="400px"
          height="400px"
          style="margin: 10px auto"
          :blocks="blocks"
          :prizes="prizes"
          :buttons="buttons"
          :defaultConfig="defaultConfig"
          :defaultStyle="defaultStyle"
          @start="startCallback"
          @end="endCallback"
        />
      </div>
      <div v-else class="table-panel" v-loading="loading">
        <el-empty description="未查询到小组成员"></el-empty>
      </div>
    </template>
  </base-panel>
</template>
<style scoped>
.table-panel {
  overflow: auto;
  height: 420px;
}
</style>
<script>
import { successInfo, errorInfo, cancelInfo } from '@/utils/message'
import BasePanel from '../BasePanel.vue'
export default {
  components: {
    BasePanel
  },
  created () {
    this.init()
  },
  data () {
    return {
      loading: false,
      showFlag: false,
      // 转盘配置项
      blocks: [{ padding: '3px', background: '#409eff' }],
      buttons: [
        { radius: '35px', background: '#409eff' },
        { radius: '25px', background: '#409eff', pointer: true },
        {
          radius: '30px',
          background: '#f5f5f5',
          pointer: false,
          fonts: [{ text: 'GO!', top: '-10px' }]
        }
      ],
      defaultConfig: {
        gutter: '2px'
      },
      defaultStyle: {
        background: '#f5f5f5',
        fontSize: '15px',
        fontColor: '#f56c6c',
        fontWeight: 700
      },
      // 初始化转盘数据
      prizes: [],
      selectedMembers: []
    }
  },
  methods: {
    // 加载转盘数据
    init () {
      this.loading = true
      this.$axios
        .get('/user/getUsers', {
          params: {
            userId: this.$store.getters.userInfo.userId,
            userName: this.$store.getters.userInfo.userName
          }
        })
        .then(result => {
          this.loading = false
          if (result.data == null || result.data.length <= 1) {
            this.showFlag = false
          } else {
            this.initPrizes(result.data)
            this.showFlag = true
          }
        })
        .catch(failResponse => {
          this.loading = false
          errorInfo(failResponse)
        })
    },
    // 格式化小组用户
    initPrizes (userNames) {
      for (let index = 0; index < userNames.length; index++) {
        this.prizes.push({
          name: index,
          id: userNames[index].userId,
          fonts: [{ text: userNames[index].userName, top: '10px' }]
        })
        this.selectedMembers.push(userNames[index].userId)
      }
    },
    handleChange () {
      console.log(this.selectedMembers)
    },
    startCallback () {
      // 清除监听状态
      this.$store.dispatch('monitor/endMonitor')
      // 调用组件的play方法启动转盘
      this.$refs.tableId.play()
      setTimeout(() => {
        let index = Math.round(Math.random() * (this.prizes.length - 1))
        // 调用stop停止旋转
        this.$refs.tableId.stop(index)
      }, 3000)
    },
    endCallback (prize) {
      this.$confirm(
        '已抽中：' + prize.fonts[0].text + '，是否记录该结果？',
        '提示',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'success'
        }
      )
        .then(() => {
          this.$axios
            .post('/lotteryLog/add', {
              lotteryUserId: this.$store.getters.userInfo.userId,
              lotteryUserGroupId: this.$store.getters.userInfo.groupId,
              winnerUserId: prize.id
            })
            .then(result => {
              if (result.data.returnCode === 'SUCCESS') {
                // 记录监听状态
                this.$store.dispatch('monitor/startMonitor')
                successInfo(result.data.returnMessage)
              } else {
                errorInfo(result.data.returnMessage)
              }
            })
            .catch(failResponse => {
              errorInfo(failResponse)
            })
        })
        .catch(() => cancelInfo('已取消'))
    }
  }
}
</script>

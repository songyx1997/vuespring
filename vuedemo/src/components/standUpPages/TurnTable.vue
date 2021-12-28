<template>
  <div class="table-panel" v-loading="loading">
    <LuckyWheel
      ref="tableId"
      width="360px"
      height="360px"
      style="margin: 0 auto"
      :blocks="blocks"
      :prizes="prizes"
      :buttons="buttons"
      :defaultConfig="defaultConfig"
      :defaultStyle="defaultStyle"
      @start="startCallback"
      @end="endCallback"
    />
  </div>
</template>
<style scoped>
.table-panel {
  overflow: auto;
  padding: 20px 0;
}
</style>
<script>
import { errorInfo } from '@/utils/message'
export default {
  created () {
    this.init()
  },
  data () {
    return {
      loading: false,
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
      prizes: []
    }
  },
  methods: {
    // 加载转盘数据
    init () {
      this.loading = true
      this.$axios
        .post('/user/getUsers', {
          userId: this.$store.getters.userInfo.userId,
          userName: this.$store.getters.userInfo.userName
        })
        .then(result => {
          this.loading = false
          if (result.data.returnCode === 'SUCCESS') {
            this.prizes = this.initPrizes(result.data.paraMap.userNames)
          } else {
            errorInfo(result.data.returnMessage)
          }
        })
        .catch(failResponse => {
          this.loading = false
          errorInfo(failResponse)
        })
    },
    // 格式化小组用户
    initPrizes (userNames) {
      let prizes = []
      for (let index = 0; index < userNames.length; index++) {
        prizes.push({
          name: index,
          fonts: [{ text: userNames[index], top: '10px' }]
        })
      }
      return prizes
    },
    startCallback () {
      // 调用组件的play方法启动转盘
      this.$refs.tableId.play()
      // 异步抽奖
      setTimeout(() => {
        // 假设后端返回的中奖索引是0
        const index = 0
        // 调用stop停止旋转
        this.$refs.tableId.stop(index)
      }, 3000)
    },
    endCallback (prize) {
      alert(prize.fonts[0].text)
    }
  }
}
</script>

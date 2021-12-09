<template>
  <div class="table-panel">
    <LuckyWheel
      ref="tableId"
      width="360px"
      height="360px"
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
  text-align: -webkit-center;
}
</style>
<script>
export default {
  mounted () {},
  data () {
    return {
      blocks: [{ padding: '5px', background: '#f56c6c' }],
      prizes: [
        {
          name: 'songyx1',
          fonts: [{ text: '一二三四', top: '50px' }]
        },
        {
          name: 'songyx2',
          fonts: [{ text: '五六七', top: '50px' }]
        }
      ],
      buttons: [
        { radius: '60px', background: '#f56c6c' },
        {
          radius: '55px',
          background: '#f5f5f5'
        },
        { radius: '50px', background: '#f56c6c', pointer: true },
        { radius: '40px', background: '#f5f5f5', pointer: false }
      ],
      defaultConfig: {
        gutter: '2px'
      },
      defaultStyle: {
        background: '#f5f5f5',
        fontSize: '24px',
        fontColor: '#c1242a',
        fontWeight: 900
      }
    }
  },
  methods: {
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
      console.log(prize)
    }
  }
}
</script>

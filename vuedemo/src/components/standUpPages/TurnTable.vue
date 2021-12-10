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
  data () {
    return {
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
      }
    }
  },
  computed: {
    prizes () {
      return [
        {
          name: '1',
          fonts: [{ text: '刘大', top: '10px' }]
        },
        {
          name: '2',
          fonts: [{ text: '张三', top: '10px' }]
        },
        {
          name: '3',
          fonts: [{ text: '赵四', top: '10px' }]
        }
      ]
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
      alert(prize.fonts[0].text)
    }
  }
}
</script>

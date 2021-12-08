<template>
  <div ref="lineChart" class="bar-panel"></div>
</template>
<style scoped>
.bar-panel {
  width: 95%;
  margin: 0 auto;
  height: 380px;
}
</style>
<script>
export default {
  beforeDestroy () {
    window.removeEventListener('resize', this.init)
  },
  mounted () {
    this.init()
    window.addEventListener('resize', this.init)
  },
  methods: {
    init () {
      let lineChart = this.$echarts.init(this.$refs.lineChart)
      let months = [
        '1月',
        '2月',
        '3月',
        '4月',
        '5月',
        '6月',
        '7月',
        '8月',
        '9月',
        '10月',
        '11月',
        '12月'
      ]
      let option = {
        tooltip: {
          trigger: 'axis'
        },
        toolbox: {
          // 不显示工具栏提示
          showTitle: false,
          feature: {
            // 可重置
            restore: {
              show: true
            },
            magicType: {
              type: ['bar']
            }
          }
        },
        grid: {
          top: '13%',
          left: '0%',
          right: '2%',
          bottom: '4%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            // 坐标轴两边不留白
            boundaryGap: false,
            axisTick: { show: false },
            splitLine: { show: true },
            data: months
          }
        ],
        yAxis: [
          {
            type: 'value',
            axisTick: { show: false },
            splitLine: { show: true }
          }
        ],
        series: [
          {
            // 平滑曲线
            smooth: true,
            name: 'songyx1',
            type: 'line',
            // 拐点数字
            label: { show: true, position: 'top', fontWeight: 900 },
            data: [7, 5, 2, 3, 4, 2, 3, 2, 2, 5, 9, 10]
          },
          {
            smooth: true,
            name: 'songyx3',
            type: 'line',
            label: { show: true, position: 'top', fontWeight: 900 },
            data: [5, 3, 1, 7, 8, 1, 4, 3, 8, 1, 2, 7]
          }
        ]
      }
      lineChart.setOption(option)
      lineChart.resize()
    }
  }
}
</script>

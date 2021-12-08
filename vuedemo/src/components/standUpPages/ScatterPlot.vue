<template>
  <div ref="scatterPlot" class="scatter-plot-panel"></div>
</template>
<style scoped>
.scatter-plot-panel {
  width: 95%;
  margin: 0 auto;
  height: 400px;
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
      let scatterPlot = this.$echarts.init(this.$refs.scatterPlot)
      let option = {
        color: ['#f56c6c'],
        tooltip: { trigger: 'item' },
        grid: {
          top: '13%',
          left: '0%',
          right: '0%',
          bottom: '4%',
          containLabel: true
        },
        xAxis: { show: false, type: 'category' },
        yAxis: {
          type: 'time',
          axisLine: { show: true },
          axisTick: { show: true },
          splitLine: { show: false },
          axisLabel: {
            formatter: function (param) {
              let date = new Date(param)
              let dateString = date.toLocaleString()
              let timeString = date.toTimeString()
              return (
                dateString.substring(0, dateString.indexOf(' ') + 1) +
                timeString.substring(0, 8)
              )
            }
          }
        },
        series: [
          {
            symbolSize: 20,
            type: 'scatter',
            data: [
              ['songyx1', new Date(2021, 5, 24, 0, 0, 0)],
              ['songyx1', new Date(2021, 6, 24, 0, 0, 0)],
              ['songyx1', new Date(2021, 7, 24, 0, 0, 0)],
              ['songyx1', new Date(2021, 8, 24, 0, 0, 0)],
              ['songyx1', new Date(2021, 9, 24, 0, 0, 0)],
              ['songyx1', new Date(2021, 10, 24, 0, 0, 0)],
              ['songyx1', new Date(2021, 11, 24, 0, 0, 0)],
              ['songyx1', new Date(2021, 12, 30, 0, 0, 0)],
              ['songyx1', new Date(2021, 12, 40, 0, 0, 0)],
              ['songyx1', new Date(2021, 12, 50, 0, 0, 0)]
            ]
          }
        ]
      }
      scatterPlot.setOption(option)
      scatterPlot.resize()
    }
  }
}
</script>

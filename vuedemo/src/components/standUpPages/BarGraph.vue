<template>
  <div ref="barGraph" class="bar-panel"></div>
</template>
<style scoped>
.bar-panel {
  width: 100%;
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
      let barGraph = this.$echarts.init(this.$refs.barGraph)
      let option = {
        color: ['#409eff'],
        tooltip: {},
        grid: {},
        xAxis: {
          type: 'category',
          axisTick: { show: false },
          splitLine: {
            show: true
          },
          data: [
            'songyx1',
            'songyx2',
            'songyx3',
            'songyx4',
            'songyx5',
            'songyx6'
          ]
        },
        yAxis: {
          type: 'value',
          name: '次数',
          axisTick: { show: false },
          splitLine: { show: true }
        },
        series: [
          {
            type: 'bar',
            label: {
              show: true,
              position: 'top',
              color: '#409eff',
              fontWeight: 900
            },
            data: [7, 5, 2, 3, 4, 2]
          }
        ]
      }
      barGraph.setOption(option)
      barGraph.resize()
    }
  }
}
</script>

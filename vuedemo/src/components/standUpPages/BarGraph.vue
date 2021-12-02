<template>
  <el-card>
    <div ref="barGraph" class="bar-panel"></div>
  </el-card>
</template>
<style scoped>
.bar-panel {
  width: 100%;
  height: 300px;
}
</style>
<script>
export default {
  mounted () {
    this.init()
  },
  methods: {
    init () {
      let barGraph = this.$echarts.init(this.$refs.barGraph)
      let option = {
        color: ['#409eff'],
        tooltip: {},
        grid: {
          left: '0%',
          right: '11%',
          bottom: '10%',
          containLabel: true
        },
        yAxis: {
          type: 'category',
          name: '中奖人',
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
        xAxis: {
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
              position: 'right',
              color: '#409eff',
              fontWeight: 900
            },
            data: [7, 5, 2, 3, 4, 2]
          }
        ]
      }
      barGraph.setOption(option)
    }
  }
}
</script>

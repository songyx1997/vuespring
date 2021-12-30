<template>
  <el-tabs v-model="activeName" type="border-card">
    <el-tab-pane name="histogram">
      <span slot="label"
        ><i class="el-icon-s-data"></i>&nbsp;近期抽奖结果
        <el-dropdown
          size="medium"
          @command="handleCommand"
          trigger="click"
          placement="bottom"
        >
          <i class="el-icon-date"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item
              v-for="item in items"
              :command="item.value"
              :key="item.value"
              >{{ item.text }}</el-dropdown-item
            >
          </el-dropdown-menu>
        </el-dropdown>
      </span>
      <div ref="histogram" class="line-chart-panel" v-loading="loading"></div>
    </el-tab-pane>
  </el-tabs>
</template>
<style scoped>
.el-icon-date {
  color: var(--blue);
}
.line-chart-panel {
  width: 95%;
  margin: 0 auto;
  height: 381px;
}
</style>
<script>
import { errorInfo } from '@/utils/message'
export default {
  data () {
    return {
      activeName: 'histogram',
      items: [
        { value: 10, text: '10次' },
        { value: 50, text: '50次' },
        { value: 100, text: '100次' },
        { value: 200, text: '200次' },
        { value: 400, text: '400次' }
      ],
      histogram: {},
      loading: false
    }
  },
  created () {
    this.$nextTick(() => {
      this.init()
      this.getHistogramData(50)
    })
  },
  mounted () {
    let _this = this
    window.onresize = function () {
      _this.histogram.resize()
    }
  },
  watch: {
    '$store.getters.monitorFlag': function () {
      let monitorFlag = this.$store.getters.monitorFlag
      if (monitorFlag) {
        this.getHistogramData(50)
      }
    }
  },
  methods: {
    init () {
      this.histogram = this.$echarts.init(this.$refs.histogram)
      let option = {
        tooltip: {},
        grid: {
          top: '6%',
          left: '1%',
          right: '2%',
          bottom: '1%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            axisTick: { show: false },
            splitLine: { show: true },
            axisLine: { show: false },
            data: []
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
            type: 'bar',
            label: {
              show: true,
              position: 'top',
              fontWeight: 500,
              color: '#868890'
            },
            // 柱子宽度
            barWidth: 20,
            data: []
          }
        ]
      }
      this.histogram.setOption(option)
    },
    handleCommand (command) {
      this.getHistogramData(command)
    },
    // 统计中奖人次数
    getHistogramData (limit) {
      this.loading = true
      this.$axios
        .get('/lotteryLog/getHistogramData', {
          params: {
            limit: limit,
            lotteryUserId: this.$store.getters.userInfo.userId
          }
        })
        .then(result => {
          this.formatData(result.data)
          this.loading = false
        })
        .catch(failResponse => {
          this.loading = false
          errorInfo(failResponse)
        })
    },
    // 格式化统计数据，重新加载柱形图数据
    formatData (data) {
      let userNames = []
      let times = []
      let index = 0
      for (let userName in data) {
        userNames.push(userName)
        times.push({
          value: data[userName],
          itemStyle: { color: this.getColorByIndex(index) }
        })
        index++
      }
      // 加载数据
      let option = this.histogram.getOption()
      option.xAxis[0].data = userNames
      option.series[0].data = times
      this.histogram.setOption(option, true)
    },
    // 获取图表指定颜色
    getColorByIndex (index) {
      index = index % 8
      let colors = [
        '#00b1ed',
        '#f56c6c',
        '#e6a23c',
        '#fde000',
        '#67c23a',
        '#409eff',
        '#c1242a',
        '#800080'
      ]
      return colors[index]
    }
  }
}
</script>

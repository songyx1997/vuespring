<template>
  <base-panel>
    <template #headLeft>
      <i class="el-icon-s-data"></i>&nbsp;近期抽奖结果
    </template>
    <template #headRight>
      <el-select
        style="width:90px"
        v-model="selectedTimes"
        size="mini"
        @change="handleChange"
      >
        <el-option
          v-for="item in items"
          :key="item.value"
          :label="item.text"
          :value="item.value"
        ></el-option>
      </el-select>
    </template>
    <template #body>
      <div v-if="showFlag">
        <div class="line-chart-panel" ref="histogram"></div>
      </div>
      <div v-else class="line-chart-panel" v-loading="loading">
        <el-empty description="未查询到统计数据"></el-empty>
      </div>
    </template>
  </base-panel>
</template>
<style scoped>
.el-icon-date {
  color: var(--blue);
}
.line-chart-panel {
  width: 100%;
  margin: 0 auto;
  height: 420px;
  border: 2px dashed var(--grey);
  box-sizing: border-box;
}
</style>
<script>
import { errorInfo } from '@/utils/message'
import BasePanel from '../BasePanel.vue'
export default {
  components: {
    BasePanel
  },
  data () {
    return {
      items: [
        { value: 10, text: '10次' },
        { value: 20, text: '20次' },
        { value: 50, text: '50次' },
        { value: 100, text: '100次' },
        { value: 200, text: '200次' }
      ],
      loading: false,
      showFlag: false,
      // 初始化图表数据
      histogram: {},
      userNames: [],
      times: [],
      selectedTimes: 20
    }
  },
  created () {
    this.getHistogramData(20)
  },
  mounted () {
    let _this = this
    window.onresize = function () {
      if (_this.showFlag) {
        _this.histogram.resize()
      }
    }
  },
  watch: {
    '$store.getters.monitorFlag': function () {
      let monitorFlag = this.$store.getters.monitorFlag
      if (monitorFlag) {
        this.getHistogramData(20)
      }
    }
  },
  methods: {
    init () {
      this.histogram = this.$echarts.init(this.$refs.histogram)
      let option = {
        tooltip: {},
        grid: {
          top: '8%',
          left: '1%',
          right: '2%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            axisTick: { show: false },
            splitLine: { show: false },
            axisLine: { show: false },
            data: this.userNames
          }
        ],
        yAxis: [
          {
            show: false,
            type: 'value'
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
            data: this.times
          }
        ]
      }
      this.histogram.setOption(option)
    },
    handleChange (value) {
      this.getHistogramData(value)
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
          let formatedData = this.formatData(result.data)
          this.userNames = formatedData.userNames
          this.times = formatedData.times
          if (this.showFlag && formatedData.count !== 0) {
            // 已有柱形图
            this.refresh(formatedData)
          } else if (this.showFlag && formatedData.count === 0) {
            // 数据被清空
            this.showFlag = false
            this.histogram.dispose()
          } else if (!this.showFlag && formatedData.count !== 0) {
            // 初始化柱形图
            this.showFlag = true
            this.$nextTick(() => {
              this.init()
            })
          } else {
            // 初始化无数据
            this.showFlag = false
          }
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
      return {
        times: times,
        userNames: userNames,
        count: index
      }
    },
    refresh (formatedData) {
      // 加载数据
      let option = this.histogram.getOption()
      option.xAxis[0].data = formatedData.userNames
      option.series[0].data = formatedData.times
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

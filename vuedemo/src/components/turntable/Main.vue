<template>
  <el-row :gutter="20">
    <el-col style="padding-bottom:20px" :xs="24" :sm="8">
      <el-card>
        <LuckyWheel
          width="400px"
          height="400px"
          class="table-config"
          :blocks="blocks"
          :prizes="prizes"
          :buttons="buttons"
          :defaultStyle="defaultStyle"
        />
      </el-card>
    </el-col>
    <el-col style="padding-bottom:20px" :xs="24" :sm="3">
      <select-cofig></select-cofig>
    </el-col>
    <el-col style="padding-bottom:20px" :xs="24" :sm="6">
      <time-line></time-line>
    </el-col>
    <el-col style="padding-bottom:20px" :xs="24" :sm="6">
      <el-card></el-card>
    </el-col>
  </el-row>
</template>
<style scoped>
.table-config {
  margin: 0px auto;
}
</style>
<script>
import SelectCofig from './SelectConfig.vue'
import TimeLine from './TimeLine.vue'
export default {
  components: {
    SelectCofig,
    TimeLine
  },
  data () {
    return {
      blocks: [
        {
          padding: '10px',
          background: 'rgba(64, 158, 255, 1)'
        }
      ],
      prizes: [
        {
          name: 'songyx1',
          background: 'rgba(102, 177, 255, 1)',
          fonts: [
            {
              text: 'songyx1',
              top: '70px'
            }
          ]
        },
        {
          name: 'songyx2',
          background: 'rgba(217, 236, 255, 1)',
          fonts: [
            {
              text: 'songyx2',
              top: '70px'
            }
          ]
        },
        {
          name: 'songyx3',
          background: 'rgba(102, 177, 255, 1)',
          fonts: [
            {
              text: 'songyx3',
              top: '70px'
            }
          ]
        },
        {
          name: 'songyx4',
          background: 'rgba(217, 236, 255, 1)',
          fonts: [
            {
              text: 'songyx4',
              top: '70px'
            }
          ]
        }
      ],
      buttons: [
        {
          radius: '60px',
          background: 'rgba(64, 158, 255, 1)'
        },
        {
          radius: '55px',
          background: 'rgba(255, 255, 255, 1)'
        },
        {
          radius: '50px',
          background: 'rgba(64, 158, 255, 1)',
          pointer: true
        },
        {
          radius: '40px',
          background: 'rgba(217, 236, 255, 1)',
          pointer: false
        }
      ],
      defaultStyle: {
        fontColor: '#d64737',
        fontSize: '14px'
      }
    }
  }
}
</script>

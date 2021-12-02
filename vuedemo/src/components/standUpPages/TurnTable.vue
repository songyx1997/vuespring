<template>
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
</template>
<style scoped></style>
<script>
export default {
  data () {
    return {
      blocks: [{ padding: '10px', background: 'rgba(64, 158, 255, 1)' }],
      prizes: [
        {
          name: 'songyx1',
          background: 'rgba(102, 177, 255, 1)',
          fonts: [{ text: 'songyx1', top: '70px' }]
        },
        {
          name: 'songyx2',
          background: 'rgba(217, 236, 255, 1)',
          fonts: [{ text: 'songyx2', top: '70px' }]
        },
        {
          name: 'songyx3',
          background: 'rgba(102, 177,255, 1)',
          fonts: [{ text: 'songyx3', top: '70px' }]
        },
        {
          name: 'songyx4',
          background: 'rgba(217, 236, 255, 1)',
          fonts: [{ text: 'songyx4', top: '70px' }]
        }
      ],
      buttons: [
        { radius: '60px', background: 'rgba(64, 158, 255, 1)' },
        {
          radius: '55px',
          background: 'rgba(255, 255, 255, 1)'
        },
        { radius: '50px', background: 'rgba(64, 158, 255, 1)', pointer: true },
        { radius: '40px', background: 'rgba(217, 236, 255, 1)', pointer: false }
      ],
      defaultStyle: {
        fontColor: '#d64737',
        fontSize: '14px'
      }
    }
  }
}
</script>

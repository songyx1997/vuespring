<template>
  <el-calendar v-model="value"> </el-calendar>
</template>
<style scoped></style>
<script>
export default {
  name: 'Calendar',
  data () {
    return {
      value: new Date()
    }
  }
}
</script>

<template>
  <el-card>
    <div class="config-panel">
      <el-checkbox
        class="config-line"
        :indeterminate="isIndeterminate"
        v-model="checkAll"
        @change="handleCheckAllChange"
        >全选</el-checkbox
      >
      <el-checkbox-group v-model="checkedObjs" @change="handleCheckedChange">
        <el-checkbox
          v-for="obj in objs"
          :label="obj"
          :key="obj"
          class="config-line"
          >{{ obj }}</el-checkbox
        >
      </el-checkbox-group>
    </div>
  </el-card>
</template>
<style scoped>
.config-panel {
  text-align: left;
}
.config-line {
  display: block;
  padding: 2px 0px;
}
</style>
<script>
const initObjs = [
  'songyx1',
  'songyx2',
  'songyx3',
  'songyx4',
  'songyx5',
  'songyx6',
  'songyx7',
  'songyx8'
]
export default {
  data () {
    return {
      checkAll: false,
      // 默认为全部
      checkedObjs: initObjs,
      objs: initObjs,
      isIndeterminate: true
    }
  },
  methods: {
    handleCheckAllChange (val) {
      this.checkedObjs = val ? initObjs : []
      this.isIndeterminate = false
    },
    handleCheckedChange (value) {
      let checkedCount = value.length
      this.checkAll = checkedCount === this.objs.length
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.objs.length
    }
  }
}
</script>

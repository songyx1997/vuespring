<template>
  <div class="panel-overall">
    <div class="panel-head">
      <div class="panel-head-left">
        <slot name="headLeft">空标题</slot>
      </div>
      <div class="panel-head-right"><slot name="headRight"></slot></div>
    </div>
    <div class="panel-body"><slot name="body">暂无内容</slot></div>
  </div>
</template>
<style scoped>
.panel-overall {
  background-color: white;
  border: 1.5px solid var(--grey);
}
.panel-head {
  display: flex;
  height: 40px;
  line-height: 40px;
  font-weight: bold;
  background-color: var(--lightgrey2);
  justify-content: space-between;
}
.panel-head-left {
  display: inline-block;
  padding: 0 18px;
  font-size: 14px;
  color: var(--blue);
  background-color: white;
  border-right: 1.5px solid var(--grey);
}
.panel-head-right {
  padding: 0 10px;
  color: black;
}
.panel-body {
  text-align: left;
  padding: 10px;
}
</style>
<script>
export default {}
</script>

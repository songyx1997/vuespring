<template>
  <div id="app">
    <router-view />
  </div>
</template>
<script>
export default {
  name: 'App'
}
</script>
<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  text-align: center;
  height: 100%;
}
/* 变更滚动条样式 */
::-webkit-scrollbar {
  width: 7px;
  height: 7px;
  background-color: var(--grey);
}
::-webkit-scrollbar-thumb {
  border-radius: 5px;
  background-color: rgba(0, 0, 0, 0.1);
}
</style>

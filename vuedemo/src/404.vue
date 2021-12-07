<template>
  <div class="error-box">
    <h1>404</h1>
    <p>Page not found</p>
    <div>
      <el-button type="primary" round onclick="history.back(-1)"
        >Go Back</el-button
      >
      <el-button type="success" round @click="returnHome"
        >Go to Home Page</el-button
      >
    </div>
  </div>
</template>
<style scoped>
h1 {
  color: var(--red);
  animation: hue 3s infinite linear;
}
@keyframes hue {
  from {
    color: var(--red);
  }
  to {
    color: var(--orange);
  }
}
.error-box {
  padding-top: 50px;
  font-weight: bold;
}
.error-box h1 {
  font-size: 60px;
  line-height: 25px;
}
</style>
<script>
export default {
  methods: {
    returnHome () {
      this.$router.push({
        path: this.$router.options.routes[1].children[0].path,
        replace: true
      })
    }
  }
}
</script>

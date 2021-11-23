#### 1. Version 2.0

##### 1.1 基础语法

`v-bind`实现声明式渲染。

`v-if`与`v-for`分别对应条件与循环

```vue
<template>
  <div>
    <span v-bind:title="message">测试文字</span>
    <p v-if="flag">测试段落</p>
    <li v-for="todo in todos" :key="todo.id">{{ todo.text }}</li>
  </div>
</template>
<script>
export default {
  data () {
    return {
      message: '绑定文字',
      flag: true,
      todos: [
        { id: '1', text: 'JavaScript' },
        { id: '2', text: 'Vue' }
      ]
    }
  }
}
</script>
```

`v-on` 指令添加一个事件监听器。

`v-model` 指令，实现表单输入和应用状态之间的双向绑定。

```vue
<template>
  <div>
    <p>{{ message }}</p>
    <input v-model="message" />
  </div>
</template>
<script>
export default {
  data () {
    return {
      // 初始化
      message: ''
    }
  }
}
</script>
```


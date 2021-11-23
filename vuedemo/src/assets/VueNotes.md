#### 1. 箭头函数

引入箭头函数有两个方面的作用：更简短的函数并且不绑定`this`。

##### 1.1 用法

```js
var elements = [
  'Hydrogen',
  'Helium',
  'Lithium',
  'Beryllium'
];

// [8, 6, 7, 9]
elements.map((element) => {
  return element.length;
});

elements.map(element => {
 return element.length;
});

// 只有一个 return 语句时，进一步简写
elements.map(element => element.length);

// 参数解构，"length" 是我们想要获得的属性的名称，而 lengthFooBArX 只是个变量名。
elements.map(({ "length": lengthFooBArX }) => lengthFooBArX); // [8, 6, 7, 9]
```

##### 1.2 this特性

箭头函数不会创建自己的`this`，它只会从自己的作用域链的上一层继承。

```js
var obj = {
  i: 10,
  b: () => console.log(this.i, this),
  c: function() {
    console.log( this.i, this)
  }
}
// undefined, Window{window: Window, document: document, …}
obj.b();
// 10, Object {i: 10, b: ƒ, c: ƒ}
obj.c();
```

#### 2. Version 2.0

##### 2.1 模板语法

`v-bind`实现声明式渲染，可支持 JavaScript 表达式。

`v-on` 指令添加一个事件监听器。

`v-if`与`v-for`分别对应条件与循环。

```vue
<template>
  <div>
    <button :disabled="isButtonDisabled > 3" @click="click">
      Button
    </button>
    <p v-if="flag">测试段落</p>
    <li v-for="todo in todos" :key="todo.id">{{ todo.text }}</li>
  </div>
</template>
<script>
export default {
  data () {
    return {
      // 按钮非禁用
      isButtonDisabled: 2,
      // 文字消失
      flag: false,
      todos: [
        { id: '1', text: 'JavaScript' },
        { id: '2', text: 'Vue' }
      ]
    }
  },
  methods: {
    click () {
      alert('点击测试')
    }
  }
}
</script>
```
attributeName、 eventName会被作为 JavaScript 表达式进行动态求值，求得的值将会作为最终的参数来使用。
```vue
<!-- 动态参数 -->
<a v-bind:[attributeName]="url"> ... </a>
<a v-on:[eventName]="doSomething"> ... </a>
```

双大括号会将数据解释为普通文本，而非 HTML 代码，可使用`v-html`（类似于js中的innerHTML）。

`v-model` 指令，实现表单输入和应用状态之间的双向绑定。

```vue
<template>
  <div>
    <p>测试<span v-html="message"></span></p>
    <p>{{ message }}</p>
    <input v-model="message" />
  </div>
</template>
<script>
export default {
  data () {
    return {
      // 初始化
      message: '<span style="color:red">文字</span>'
    }
  }
}
</script>
```

##### 2.2 计算属性与侦听

```vue
<template>
  <div>
    <div>{{ message }}</div>
    <div>{{ reverseMessage }}</div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      message: 'abc'
    }
  },
  computed: {
    reverseMessage: function () {
      return this.message
        .split('')
        .reverse()
        .join('')
    }
  }
}
</script>
```

可以使用方法调用，而非计算属性。

```vue
<template>
  <div>
    <div>{{ message }}</div>
    <div>{{ reverseMessage() }}</div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      message: 'abc'
    }
  },
  methods: {
    reverseMessage () {
      return this.message
        .split('')
        .reverse()
        .join('')
    }
  }
}
</script>
```

计算属性是基于它们的响应式依赖进行缓存的，只有相关响应式依赖发生改变时它们才会重新求值。

##### 2.3 条件渲染

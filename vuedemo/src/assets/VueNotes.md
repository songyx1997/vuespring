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


```vue
<template>
  <div>
    <p>测试<span v-html="message"></span></p>
  </div>
</template>
<script>
export default {
  data () {
    return {
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

除了`v-if`与`v-else`外，`v-show`也用于根据条件展示元素。但不同的是带有 `v-show` 的元素始终会被渲染并保留在 DOM 中，只是简单地切换元素的`display`。

```vue
<template>
  <div>
    <p v-show="flag">测试段落</p>
  </div>
</template>
<script>
export default {
  data () {
    return {
      // p标签添加样式display: none
      flag: false
    }
  }
}
</script>
```

`v-if` 有更高的切换开销，而 `v-show` 有更高的初始渲染开销。因此，如果需要非常频繁地切换，则使用 `v-show` ；如果在运行时条件很少改变，则使用 `v-if` 。

##### 2.4 列表渲染

`v-for`也可用于遍历对象中的属性。三个变量：index（索引）、name（键）、value（值）。

```vue
<template>
  <div>
    <li v-for="(index, name, value) in obj" :key="index">
      {{ index }}-{{ name }}-{{ value }}
    </li>
  </div>
</template>
<script>
export default {
  data () {
    return {
      obj: {
        title: 'vue',
        author: 'songyx',
        data: '2021-11-24'
      }
    }
  }
}
</script>
```

`v-for` 的优先级比 `v-if` 更高，因此可用于部分渲染节点。

```vue
<li v-for="todo in todos" v-if="!todo.isComplete">
  <!-- 只渲染未完成的todo -->
  {{ todo }}
</li>
```

##### 2.5 表单输入
`v-model` 指令在表单 `<input>`、`<textarea>` 及单选框、复选框、选择框上创建双向数据绑定。

```vue
<template>
  <div>
    <select v-model="selected">
      <option v-for="option in options" :key="option.value">{{
        option.text
      }}</option>
    </select>
    <span>已选择: {{ selected }}</span>
  </div>
</template>
<script>
export default {
  data () {
    return {
      selected: ''
    }
  },
  computed: {
    options: function () {
      return [
        { value: '', text: '请选择' },
        { value: 'A', text: '我' },
        { value: 'B', text: '是' },
        { value: 'C', text: '谁' }
      ]
    }
  }
}
</script>
```

三种修饰符`.lazy`、`.number`、`.trim`。

```vue
<!-- 在change事件之后进行同步 -->
<input v-model.lazy="age">
<!-- 自动将用户的输入值转为数值 -->
<input v-model.number="age" type="number">
<!-- 自动过滤用户输入的首尾空白字符 -->
<input v-model.number="age" type="number">
```

##### 2.6 Prop & Slot

通过 Prop 向子组件传递数据，传输方式为单向。

```vue
<template>
  <div>
    <text-table v-bind="post"></text-table>
  </div>
</template>
<script>
import Vue from 'vue'
Vue.component('TextTable', {
  props: ['title', 'myText'],
  template: '<h3>{{ title }}<span>{{ myText }}一</span></h3>'
})
export default {
  computed: {
    post: function () {
      return {
        title: '默认',
        value: 24,
        myText: '文本'
      }
    }
  }
}
</script>
```

若 props 绑定值为 [ ' post ' ] ，二者对比如下：

```html
<h3 value="24">默认<span>文本一</span></h3>
<h3 title="默认" value="24" mytext="文本"><span>一</span></h3>
```

插槽用于替换组件起始标签和结束标签之间的内容，若没有`slot`元素，则内容被抛弃。

```vue
<template>
  <div>
    <text-table v-bind="post"
      ><span style="color:red">{{ message }}</span></text-table
    >
  </div>
</template>
<script>
import Vue from 'vue'
Vue.component('TextTable', {
  props: ['title', 'myText'],
  // 插槽中的内容为后备内容
  template: '<h3>{{ title }}<slot>文本一</slot></h3>'
})
export default {
  computed: {
    post: function () {
      return {
        title: '默认',
        value: 24
      }
    },
    message: function () {
      return '文本二'
    }
  }
}
</script>
```

显示结果如下：

<h3 value="24">默认<span style="color: red;">文本二</span></h3>

若删去`span`元素，显示结果如下：

<h3 value="24">默认文本一</h3>

为了绑定多个插槽，可以使用插槽的`name`属性。

```vue
<template>
  <div>
    <text-table>
      <template v-slot:label><span style="color:red">性别</span></template>
      <template v-slot:age><span style="color:green">男</span></template>
    </text-table>
  </div>
</template>
<script>
import Vue from 'vue'
Vue.component('TextTable', {
  template:
    "<h3>{{ title }}<slot name='label'>年龄</slot>&nbsp;<slot name='age'>18</slot></h3>"
})
export default {}
</script>
```

显示结果如下：

<h3><span style="color: red;">性别</span>&nbsp;<span style="color: green;">男</span></h3>

为了让插槽能够访问子组件中才有的数据，可以使用插槽`prop`。`v-slot:`可简写为`#`。

```vue
// 父组件
<template>
  <div>
    <text-table>
      <template #default="slotProps">
        {{ slotProps.user.lastName }}
      </template></text-table
    >
  </div>
</template>
<script>
import TextTable from '../TextTable.vue'
export default {
  components: {
    TextTable
  }
}
</script>
// 子组件
<template>
  <span
    ><slot :user="user">{{ user.firstName }}</slot></span
  >
</template>
<script>
export default {
  computed: {
    user: function () {
      return {
        firstName: '宋',
        lastName: '三'
      }
    }
  }
}
</script>
```

显示结果为：`三`。若`text-table`元素内为空，显示结果为：`宋`。

为了使组件实例第一次创建的时候缓存下来，可使用 `<keep-alive>` 元素将其动态组件包裹起来。

##### 2.7 过渡

vue中有6种过渡类名。

<img src="https://cn.vuejs.org/images/transition.png" style="zoom: 50%;" />

具体使用方式如下：

```vue
<transition name="fade" mode="out-in">
    <router-view :key="key" />
</transition>
<style>
.fade-leave-active,
.fade-enter-active {
  transition: all 0.5s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>
```

vue中有两种过渡模式。

`in-out`：新元素先进行过渡，完成之后当前元素过渡离开。`out-in`：当前元素先进行过渡，完成之后新元素过渡进入。

[列表过渡](https://cn.vuejs.org/v2/guide/transitions.html#%E5%88%97%E8%A1%A8%E8%BF%87%E6%B8%A1)、[状态过渡](https://cn.vuejs.org/v2/guide/transitioning-state.html)

##### 2.8 混入

当组件使用混入对象时，所有混入对象的选项将进入该组件本身的选项。

混入时的合并操作：

（1）数据对象在内部会进行递归合并，并在发生冲突时以组件数据优先。

（2）同名钩子函数将都将被调用，但混入对象的钩子将在组件自身钩子之前调用。

（3）methods、components 和 directives合并时，若两个对象键名发生冲突，以组件对象优先。

##### 2.9 自定义指令

```vue
<template>
  <div>
    <div v-pin:[color]="{ size: '25px', weight: 900 }">测试文本</div>
  </div>
</template>
<script>
export default {
  directives: {
    pin: {
      bind (el, binding) {
        el.style.color = binding.arg
        el.style.fontWeight = binding.value.weight
        el.style.fontSize = binding.value.size
      }
    }
  },
  computed: {
    color () {
      return 'red'
    }
  }
}
</script>
```

显示结果如下：

<div style="color: red; font-weight: 900; font-size: 25px;">测试文本</div>

##### 2.10 过滤器

过滤器可以用在两个地方：双花括号插值和 v-bind 表达式。

```vue
<template>
  <div>
    <h3 :id="id | test">{{ message | test }}</h3>
  </div>
</template>
<script>
export default {
  data () {
    return {
      id: 'testId',
      message: '测试'
    }
  },
  filters: {
    test: function (value) {
      let parrern = new RegExp('^[a-zA-Z]+$')
      return parrern.test(value) ? value : value + '文本'
    }
  }
}
</script>
```

显示结果如下：

<h3 id="testId">测试文本</h3>

##### 2.11 渲染函数

<table>
    <tr>
        <td>title：Notes</td>
        <td>description：项目实施过程中获得的新知识</td>
    </tr>
</table>

#### 1.CSS

##### 1.1基础

```css
div {
  background-color: green;
  opacity: 0.3;
}
```

opacity 属性指定元素的透明度，取值范围为 0.0 - 1.0。

```css
body {
  background-image: url("tree.png");
  background-repeat: no-repeat;
}
```

不重复(no-repeat)、水平重复(repeat-x)、垂直重复(repeat-y)。

```css
body {
  background-image: url("tree.png");
  background-attachment: fixed;
}
```

不随页面滚动(fixed)、随页面滚动(scroll)。

```css
p {
  border: 2px solid red;
  border-radius: 5px;
}
```

border-radius 属性用于向元素添加圆角边框。

```css
div {
  width: 300px;
  padding: 25px;
  box-sizing: border-box;
}
```

box-sizing 属性将宽度保持为 300px，但增加内边距，会使可用的内容空间减少。

[外边距合并问题](https://www.w3school.com.cn/css/css_margin_collapse.asp)、[盒子模型](https://www.w3school.com.cn/css/css_boxmodel.asp)

```css
p.ex3 {
  border: 1px solid black;
  outline-style: solid;
  outline-width: 4px;
  outline-color: grey;
  outline-offset: 25px;
}
```

轮廓与边框不同！不同之处在于：轮廓是在元素边框之外绘制的，并且可能与其他内容重叠。同样，轮廓也不是元素尺寸的一部分，元素的总宽度和高度不受轮廓线宽度的影响。

outline-offset 属性在元素的轮廓与边框之间添加透明空间。

```css
div {
  color: blue;
  text-align: justify;
  text-decoration: underline;
  text-transform: uppercase;
  text-shadow: 2px 2px 5px red;
}
```

color 属性用于设置文本的颜色。

justify 将拉伸每一行，使每一行具有相等的宽度。

text-decoration 属性用于设置或删除文本装饰。

text-transform 属性用于指定文本中的大写和小写字母。

text-shadow 属性为文本添加阴影，依次为水平阴影、垂直阴影、模糊效果、阴影颜色。

```css
.p1 {
  font-family: "Times New Roman", Times, serif;
  font-style: italic;
}
```

font-family 属性应包含多个字体名称作为“后备”系统，以确保浏览器的最大兼容性。

font-style 属性主要用于指定斜体文本。

##### 1.2中级

```css
div {
  display: inline;
}
span {
  display: block;
}
table {
  display: none;
}
```

依次为：块级元素div变为行级元素、行级元素span变为块级元素、隐藏表格。

行内元素：不从新行开始，仅占用所需的宽度。span、a、img

块级元素：从新行开始，并占据可用的全部宽度。div、h1-h6、p、form

```css
div.ex2 {
  max-width: 500px;
  margin: auto;
  border: 3px solid #73AD21;
}
```

max-width 可以改善浏览器对小窗口的处理，窗口缩小至500px以内不会出现水平滚动条。

| position | 搭配top、right、bottom、left定位                             |
| -------- | ------------------------------------------------------------ |
| relative | 元素相对于其正常位置进行定位                                 |
| fixed    | 元素是相对于视口定位的，这意味着即使滚动页面，它也始终位于同一位置 |
| absolute | 元素相对于最近的定位祖先元素进行定位，若无祖先则与fixed相同  |
| sticky   | 元素根据滚动位置在相对（relative）和固定（fixed）之间切换    |

```css
img {
  position: absolute;
  left: 0px;
  top: 0px;
  z-index: -1;
}
```

z-index 属性指定元素的堆叠顺序，如果两个定位的元素重叠而未指定 **z-index**，则位于 HTML 代码中最后的元素将显示在顶部。

```css
div {
  overflow: auto;
}
```

auto 值类似于 scroll，但是它仅在必要时添加滚动条。

```css
img {
  float: left;
}
```

left - 元素浮动到其容器的左侧、none - 元素不会浮动（将显示在文本中刚出现的位置）。

```css
div {
  clear: both;
}
```

left - 左侧不允许浮动元素、both - 左侧或右侧均不允许浮动元素。

在清除浮动时，应该对清除与浮动进行匹配：如果某个元素浮动到左侧，则应清除左侧。您的浮动元素会继续浮动，但是被清除的元素将显示在其下方。

```css
.clearfix {
  overflow: auto;
}
```

如果一个元素比包含它的元素高，并且它是浮动的，它将“溢出”到其容器之外。可以向**包含元素**添加 overflow: auto来解决。

```css
span.b {
  display: inline-block;
  width: 100px;
  height: 100px;
  padding: 5px;
  border: 1px solid blue; 
  background-color: yellow; 
}
```

与 display: inline 相比，主要区别在于 display: inline-block 允许在元素上设置宽度和高度。

| 对齐方式      | 代码                                                         |
| ------------- | ------------------------------------------------------------ |
| 元素水平居中  | margin: auto                                                 |
| 文本水平居中  | text-align: center                                           |
| 元素左/右对齐 | position: absolute; right: 0px; 或者 float: right;           |
| 元素垂直居中  | （使用 line-height 属性，其值等于 height 属性）line-height: 200px; height: 200px; |
| 元素垂直居中  | 使用 position 和 transform 属性                              |
| 元素垂直居中  | 使用 Flexbox                                                 |

四种伪类：link(未访问)、visited(已访问)、hover(鼠标悬停)、active(已选择)。hover 必须在 CSS 定义中的 link 和 visited 之后，才能生效。active 必须在 CSS 定义中的 hover 之后才能生效。伪类名称对大小写不敏感。

```css
div::selection {
  color: red;
  background: yellow;
}
```

伪元素::selection，div元素字体被选中时，字体颜色为红色，背景为黄色。此外常用伪元素有::before、::after。

```css
input[type=text]:focus {
  background-color: lightblue;
}
```

:focus 选择器可以在输入字段获得焦点时为其设置样式。

```css
input[type=text] {
  background-color: white;
  background-image: url('searchicon.png');
  background-position: 10px 10px; 
  background-repeat: no-repeat;
  padding-left: 40px;
}
```

上述CSS为带有图标的输入框。

```css
textarea {
  width: 100%;
  height: 150px;
  resize: none;
}
```

resize 属性可防止对 textareas 调整大小。

##### 1.3高级
#### 1. CSS

##### 1.1 基础

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

##### 1.2 中级

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

##### 1.3 高级

```css
#div1 {
  background: url(img_flower.jpg);
  background-size: cover;
}
```

background-size 属性可以通过长度、百分比或使用以下两个关键字之一来指定背景图像的大小：contain 或 cover。

background-origin 属性指定背景图像的位置；background-clip 属性指定背景的绘制区域。两个属性均接受三个不同的值：border-box - 边框的外部边缘（默认）、padding-box - 内边距的外边缘、content-box - 内容框中。

```css
div {
  box-shadow: 10px 10px 5px grey;
}
```

box-shadow 属性应用阴影于元素，其语法与文字阴影相同。

```css
p.test {
  width: 200px; 
  border: 1px solid #000000;
  overflow: hidden;
  text-overflow: ellipsis;
}
```

text-overflow 属性规定应如何向用户呈现未显示的溢出内容，ellipsis为添加省略号。

```css
p.test:hover {
  overflow: visible;
}
```

鼠标悬停时文字将被显示。

| transform                              | 移动、旋转、缩放和倾斜元素                                   |
| -------------------------------------- | ------------------------------------------------------------ |
| transform: translate(50px, 100px)      | 从其当前位置向右移动 50 个像素，并向下移动 100 个像素        |
| transform: rotate(-20deg)              | 元素逆时针旋转 20 度                                         |
| transform: scale(2, 3)                 | 元素增大为其原始宽度的两倍和其原始高度的三倍                 |
| transform: skew(20deg, 10deg)          | 元素沿 X 轴倾斜 20 度，同时沿 Y 轴倾斜 10 度                 |
| transform: matrix(1, -0.3, 0, 1, 0, 0) | matrix(scaleX(),skewY(),skewX(),scaleY(),translateX(),translateY()) |
| transform: rotateX(150deg)             | 元素绕其 X 轴旋转给定角度                                    |

```css
div {
  width: 100px;
  transition: width 2s, transform 4s;
}
div:hover {
  width: 300px;
  transform: rotateZ(180deg);
}
```

当光标放在元素上时，将开始过渡效果。

[动画](https://www.w3school.com.cn/css/css3_animations.asp)、[工具提示](https://www.w3school.com.cn/css/css_tooltip.asp)、[图像样式](https://www.w3school.com.cn/css/css3_images.asp)、[按钮](https://www.w3school.com.cn/css/css3_buttons.asp)、[分页](https://www.w3school.com.cn/css/css3_pagination.asp)

```css
img {
  width: 200px;
  height: 400px;
  object-fit: cover;
}
```

object-fit 属性用于规定应如何调整 img 或 video 的大小来适应其容器。contain - 缩放替换后的内容以保持其纵横比，同时将其放入元素的内容框；cover - 调整图片尺寸，以在填充元素的整个内容框时保持其长宽比；none - 不对替换的内容调整大小；scale-down - 调整内容大小就像没有指定内容或包含内容一样。

```css
.disabled {
  opacity: 0.6;
  cursor: not-allowed;
}
```

鼠标悬停在按钮上时会显示禁停标志，且按钮变为透明。

```css
div {
  column-count: 3;
  column-width: 200px;
  column-gap: 40px;
  column-rule-style: solid;
  column-rule-width: 1px;
  column-rule-color: red;
}
```

依次为：列数、列宽、列间距、列之间的规则、规则宽度、规则颜色。

```css
div {
  resize: both;
  overflow: auto;
}
```

resize属性包括：horizontal - 调整宽度；vertical - 调整高度；both - 调整宽度和高度；none - 禁用，如可防止对 textareas 调整大小。

```css
:root {
  --blue: #1e90ff;
  --white: #ffffff;
}

h2 { border-bottom: 2px solid var(--blue); }
```

变量名称必须以两个破折号（--）开头，且区分大小写。

```css
@media screen and (max-width: 600px) {
  .topnav a {
    float: none;
    width: 100%;
  }
}
```

通过媒体查询，实现响应式导航栏。

#### 2. Flexbox

采用 Flex 布局的元素，称为 Flex 容器。它的所有子元素自动成为容器成员，称为 Flex 项目。

容器默认存在两根轴：水平的主轴（main axis）和垂直的交叉轴（cross axis）。主轴的开始位置（与边框的交叉点）叫做main start，结束位置叫做main end；交叉轴的开始位置叫做cross start，结束位置叫做cross end。

项目默认沿主轴排列。单个项目占据的主轴空间叫做main size，占据的交叉轴空间叫做cross size。

##### 2.1 容器

```css
.box {
  display: flex;
  flex-direction: row | row-reverse | column | column-reverse;
  flex-wrap: nowrap | wrap | wrap-reverse;
}
```

通过将父元素 display 属性设置为 flex，flex 容器将可伸缩。

flex-direction 定义父元素要在哪个方向上堆叠 flex 项目，依次为：从左到右、从右到左、从上到下、从下到上。

flex-wrap 规定是否应该对 flex 项目换行，依次为：默认不换行、必要时进行换行、相反顺序换行。

```css
.box {
  display: flex;
  justify-content: flex-start | flex-end | center | space-between | space-around;
}
```

justify-content属性定义了项目在主轴（水平方向）上的对齐方式，依次为：默认左对齐、右对齐、居中、flex项目之间的间隔都相等、每个flex项目两侧的间隔相等。

```css
.box {
  display: flex;
  align-items: stretch | flex-start | flex-end | center | baseline;
}
```

align-items属性定义项目在交叉轴（竖直方向）上的对齐方式，依次为：默认占满整个容器的高度、交叉轴的起点对齐、交叉轴的终点对齐、交叉轴的中点对齐、flex项目的第一行文字的基线对齐。

完美居中的flex项目

```css
.box {
  display: flex;
  justify-content: center;
  align-items: center;
}
```

```CSS
.box {
  display: flex;
  flex-wrap: wrap
  align-content: flex-start | flex-end | center | space-between | space-around | stretch;
}
```

由于换行产生了多条水平轴线，align-content属性定义了多根轴线的对齐方式，依次为：与交叉轴的起点对齐、与交叉轴的终点对齐、与交叉轴的中点对齐、轴线之间的间隔平均分布、每根轴线两侧的间隔都相等、默认轴线占满整个交叉轴。

##### 2.2 项目

```css
.item {
  order: 2;
  flex-grow: 4;
}
```

order 属性定义项目的排列顺序。数值越小，排列越靠前，默认为0。

flex-grow 属性规定某个 flex 项目相对于其余 flex 项目将增长多少，默认为0。

```css
.item {
  flex-shrink: 6;
}
```

flex-shrink 属性规定某个 flex 项目相对于其余 flex 项目将收缩多少，默认为1。如果一个项目的 flex-shrink 属性为0，其他项目都为1，则空间不足时，前者不缩小。

```css
.item {
  flex-basis: 300px
}
```

flex-basis 属性规定 flex 项目的初始长度，默认值为auto，即项目的本来大小。

```css
.item {
  align-self: auto | flex-start | flex-end | center | baseline | stretch;
}
```

align-self 属性允许单个项目有与其他项目不一样的对齐方式，可覆盖 align-items 属性。默认值为auto，表示继承父元素的 align-items 属性，如果没有父元素，则等同于stretch。

// 随机颜色（rgb格式）
export function randomRgb () {
  return (
    '(' +
    Math.floor(Math.random() * 256) +
    ',' +
    Math.floor(Math.random() * 256) +
    ',' +
    Math.floor(Math.random() * 256) +
    ')'
  )
}

// 随机颜色（hex格式）
export function randomHex () {
  return (
    '#' +
    Math.floor(Math.random() * 256).toString(16) +
    Math.floor(Math.random() * 256).toString(16) +
    Math.floor(Math.random() * 256).toString(16)
  )
}

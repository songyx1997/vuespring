import Vue from 'vue'
import { errorInfo } from './message'

/**
 * <p>Title: getSelections</p>
 * <p>Description: 获取选择器数据</p>
 * @param url 请求地址
 * @param params 请求参数
 * @param id 选择项编号
 * @param name 选择项名称
 * @param defaultName 无数据选择项名称
 * @return 选择器数据，键为id，值为name
 */
export function getSelections (url, params, id, name, defaultName) {
  let selections = []
  // 获取所有项目组
  Vue.prototype.$axios
    .get(url, { params: params })
    .then(result => {
      for (let index in result.data) {
        let selection = {
          id: result.data[index][id],
          name: result.data[index][name]
        }
        selections.push(selection)
      }
      if (defaultName) {
        // 配置无数据选择项
        selections.splice(0, 0, { id: '', name: defaultName })
      }
    })
    .catch(failResponse => {
      errorInfo(failResponse)
    })
  return selections
}

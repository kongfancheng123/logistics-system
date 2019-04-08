// 引入配置中导出的对象
import { instance } from '@/axiosConfig.js'
//  过滤：条件查询赛事
let getSearchData = {
  r: params => {
    return instance.post('/GameInfo/selectByGameInfo', params)
  }
}

// 更新赛事
let sendWarnData = {
  r: params => {
    return instance.post('/GameInfo/updateGame', params)
  }
}


// 删除赛事
let deleteGame = {
    r: params => {
    return instance.post('/GameInfo/deleteGame', params)
  }
}

// 添加赛事
let addGame = {
    r: params => {
    return instance.post('/GameInfo/addGame', params)
  }

}
export {
  getSearchData,
  sendWarnData,
  deleteGame,
  addGame
}

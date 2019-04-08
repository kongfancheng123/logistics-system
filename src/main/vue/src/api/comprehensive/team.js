// 引入配置中导出的对象
import { instance } from '@/axiosConfig.js'

//  过滤：条件查询战队
let getSearchData = {
    r: params => {
    return instance.post('/TeamInfo/selectByTeamInfo', params)
}
}

// 更新战队
let sendWarnData = {
    r: params => {
    return instance.post('/TeamInfo/updateTeam', params)
}
}


// 删除战队
let deleteTeam = {
    r: params => {
    return instance.post('/TeamInfo/deleteTeam', params)
}
}

// 添加战队
let addTeam = {
    r: params => {
    return instance.post('/TeamInfo/addTeam', params)
}

}
export {
    getSearchData,
    sendWarnData,
    deleteTeam,
    addTeam
}

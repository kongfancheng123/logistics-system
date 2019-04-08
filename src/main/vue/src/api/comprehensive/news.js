// 引入配置中导出的对象
import { instance } from '@/axiosConfig.js'

//  过滤：条件查询新闻
let getSearchData = {
    r: params => {
    return instance.post('/NewsInfo/selectByNewsInfo', params)
}
}

// 更新新闻
let sendWarnData = {
    r: params => {
    return instance.post('/NewsInfo/updateNews', params)
}
}


// 删除新闻
let deleteNews = {
    r: params => {
    return instance.post('/NewsInfo/deleteNews', params)
}
}

// 添加新闻
let addNews = {
    r: params => {
    return instance.post('/NewsInfo/addNews', params)
}

}
export {
    getSearchData,
    sendWarnData,
    deleteNews,
    addNews
}

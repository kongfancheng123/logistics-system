// 引入配置中导出的对象
import { instance } from '@/axiosConfig.js'

// 登录
let login = {
    r: params => {
    return instance.post('/UserInfo/login', params)
 }
}

//  过滤：条件查询用户
let getSearchData = {
    r: params => {
    return instance.post('/UserInfo/selectByUserInfo', params)
}
}

// 更新用户
let sendWarnData = {
    r: params => {
    return instance.post('/UserInfo/updateUser', params)
}
}


// 删除用户
let deleteUser = {
    r: params => {
    return instance.post('/UserInfo/deleteUser', params)
}
}

// 添加用户
let addUser = {
    r: params => {
    return instance.post('/UserInfo/register', params)
}

}
export {
  login,
  getSearchData,
  sendWarnData,
  deleteUser,
  addUser
}

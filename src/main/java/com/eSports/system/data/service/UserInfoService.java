package com.eSports.system.data.service;

import com.eSports.system.data.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    /**
     * 新增
     *
     * @param userInfo
     * @return
     */
    Integer insertUserInfo(UserInfo userInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer deleteUserInfo(Integer id);

    /**
     * 多条件查询
     *
     * @param userInfo
     * @return
     */
    List<UserInfo> selectByUserInfo(UserInfo userInfo);

    /**
     * 更新
     *
     * @param userInfo
     * @return
     */
    Integer updateUserInfo(UserInfo userInfo);

    /**
     * 查找所有
     */
    List<UserInfo> selectAll();

    /**
     * 根据id进行查找历史数据
     */
    UserInfo selectByid(Integer id);
}

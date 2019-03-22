package com.eSports.system.data.dao;

import com.eSports.system.data.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {
    /**
     * 新增
     *
     * @param userInfo
     * @return
     */
    Integer insertUserInfo(@Param("userInfo") UserInfo userInfo);

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
    List<UserInfo> selectByUserInfo(@Param("userInfo") UserInfo userInfo);

    /**
     * 更新
     *
     * @param userInfo
     * @return
     */
    Integer updateUserInfo(@Param("userInfo") UserInfo userInfo);

    /**
     * 查找所有
     */
    List<UserInfo> selectAll();

    /**
     * 根据id进行查找历史数据
     */
    UserInfo selectByid(Integer id);
}

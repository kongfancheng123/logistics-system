package com.eSports.system.data.dao;

import com.eSports.system.data.entity.NewsInfo;
import com.eSports.system.data.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsInfoDao {
    /**
     * 新增
     *
     * @param newsInfo
     * @return
     */
    Integer insertNewsInfo(@Param("newsInfo") NewsInfo newsInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer deleteNewsInfo(Integer id);

    /**
     * 多条件查询
     *
     * @param newsInfo
     * @return
     */
    List<NewsInfo> selectByNewsInfo(@Param("newsInfo") NewsInfo newsInfo);

    /**
     * 更新
     *
     * @param newsInfo
     * @return
     */
    Integer updateNewsInfo(@Param("newsInfo") NewsInfo newsInfo);

    /**
     * 查找所有
     */
    List<NewsInfo> selectAll();

    /**
     * 根据id进行查找历史数据
     */
    NewsInfo selectByid(Integer id);
}

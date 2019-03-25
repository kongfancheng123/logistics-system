package com.eSports.system.data.service;

import com.eSports.system.data.entity.NewsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsInfoService {
    /**
     * 新增
     *
     * @param newsInfo
     * @return
     */
    Integer insertNewsInfo(NewsInfo newsInfo);

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
    List<NewsInfo> selectByNewsInfo(NewsInfo newsInfo);

    /**
     * 更新
     *
     * @param newsInfo
     * @return
     */
    Integer updateNewsInfo(NewsInfo newsInfo);

    /**
     * 查找所有
     */
    List<NewsInfo> selectAll();

    /**
     * 根据id进行查找历史数据
     */
    NewsInfo selectByid(Integer id);
}

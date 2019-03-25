package com.eSports.system.data.dao;

import com.eSports.system.data.entity.GameInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameInfoDao {
    /**
     * 新增
     *
     * @param gameInfo
     * @return
     */
    Integer insertGameInfo(@Param("gameInfo") GameInfo gameInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer deleteGameInfo(Integer id);

    /**
     * 多条件查询
     *
     * @param gameInfo
     * @return
     */
    List<GameInfo> selectByGameInfo(@Param("gameInfo") GameInfo gameInfo);

    /**
     * 更新
     *
     * @param gameInfo
     * @return
     */
    Integer updateGameInfo(@Param("gameInfo") GameInfo gameInfo);

    /**
     * 查找所有
     */
    List<GameInfo> selectAll();

    /**
     * 根据id进行查找历史数据
     */
    GameInfo selectByid(Integer id);
}

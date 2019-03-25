package com.eSports.system.data.service;

import com.eSports.system.data.entity.GameInfo;
import com.eSports.system.data.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameInfoService {
    /**
     * 新增
     *
     * @param gameInfo
     * @return
     */
    Integer insertGameInfo(GameInfo gameInfo);

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
    List<GameInfo> selectByGameInfo(GameInfo gameInfo);

    /**
     * 更新
     *
     * @param gameInfo
     * @return
     */
    Integer updateGameInfo(GameInfo gameInfo);

    /**
     * 查找所有
     */
    List<GameInfo> selectAll();

    /**
     * 根据id进行查找历史数据
     */
    GameInfo selectByid(Integer id);
}

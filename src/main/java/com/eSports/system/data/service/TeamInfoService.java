package com.eSports.system.data.service;

import com.eSports.system.data.entity.TeamInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamInfoService {
    /**
     * 新增
     *
     * @param teamInfo
     * @return
     */
    Integer insertTeamInfo(TeamInfo teamInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer deleteTeamInfo(Integer id);

    /**
     * 多条件查询
     *
     * @param teamInfo
     * @return
     */
    List<TeamInfo> selectByTeamInfo(TeamInfo teamInfo);

    /**
     * 更新
     *
     * @param teamInfo
     * @return
     */
    Integer updateTeamInfo(TeamInfo teamInfo);

    /**
     * 查找所有
     */
    List<TeamInfo> selectAll();

    /**
     * 根据id进行查找历史数据
     */
    TeamInfo selectByid(Integer id);
}

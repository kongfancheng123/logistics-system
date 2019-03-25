package com.eSports.system.data.dao;

import com.eSports.system.data.entity.TeamInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamInfoDao {
    /**
     * 新增
     *
     * @param teamInfo
     * @return
     */
    Integer insertTeamInfo(@Param("teamInfo") TeamInfo teamInfo);

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
    List<TeamInfo> selectByTeamInfo(@Param("teamInfo") TeamInfo teamInfo);

    /**
     * 更新
     *
     * @param teamInfo
     * @return
     */
    Integer updateTeamInfo(@Param("teamInfo") TeamInfo teamInfo);

    /**
     * 查找所有
     */
    List<TeamInfo> selectAll();

    /**
     * 根据id进行查找历史数据
     */
    TeamInfo selectByid(Integer id);
}

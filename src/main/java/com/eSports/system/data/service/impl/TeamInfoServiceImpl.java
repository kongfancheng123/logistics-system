package com.eSports.system.data.service.impl;

import com.eSports.system.data.dao.TeamInfoDao;
import com.eSports.system.data.entity.TeamInfo;
import com.eSports.system.data.service.TeamInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamInfoServiceImpl implements TeamInfoService {
    @Resource
    private TeamInfoDao teamInfoDao;

    @Override
    public Integer insertTeamInfo(TeamInfo teamInfo) {
        return teamInfoDao.insertTeamInfo(teamInfo);
    }

    @Override
    public Integer deleteTeamInfo(Integer id) {
        return teamInfoDao.deleteTeamInfo(id);
    }

    @Override
    public List<TeamInfo> selectByTeamInfo(TeamInfo teamInfo) {
        return teamInfoDao.selectByTeamInfo(teamInfo);
    }

    @Override
    public Integer updateTeamInfo(TeamInfo teamInfo) {
        return teamInfoDao.updateTeamInfo(teamInfo);
    }

    @Override
    public List<TeamInfo> selectAll() {
        return teamInfoDao.selectAll();
    }

    @Override
    public TeamInfo selectByid(Integer id) {
        return teamInfoDao.selectByid(id);
    }
}

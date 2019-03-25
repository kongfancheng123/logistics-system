package com.eSports.system.data.service.impl;

import com.eSports.system.data.dao.GameInfoDao;
import com.eSports.system.data.entity.GameInfo;
import com.eSports.system.data.entity.UserInfo;
import com.eSports.system.data.service.GameInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GameInfoServiceImpl implements GameInfoService {
    @Resource
    private GameInfoDao gameInfoDao;

    @Override
    public Integer insertGameInfo(GameInfo gameInfo) {
        return gameInfoDao.insertGameInfo(gameInfo);
    }

    @Override
    public Integer deleteGameInfo(Integer id) {
        return gameInfoDao.deleteGameInfo(id);
    }

    @Override
    public List<UserInfo> selectByGameInfo(GameInfo gameInfo) {
        return gameInfoDao.selectByGameInfo(gameInfo);
    }

    @Override
    public Integer updateGameInfo(GameInfo gameInfo) {
        return gameInfoDao.updateGameInfo(gameInfo);
    }

    @Override
    public List<GameInfo> selectAll() {
        return gameInfoDao.selectAll();
    }

    @Override
    public GameInfo selectByid(Integer id) {
        return gameInfoDao.selectByid(id);
    }
}

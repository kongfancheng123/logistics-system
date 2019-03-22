package com.eSports.system.data.service.impl;

import com.eSports.system.data.dao.UserInfoDao;
import com.eSports.system.data.entity.UserInfo;
import com.eSports.system.data.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public Integer insertUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
    }

    @Override
    public Integer deleteUserInfo(Integer id) {
        return userInfoDao.deleteUserInfo(id);
    }

    @Override
    public List<UserInfo> selectByUserInfo(UserInfo userInfo) {
        return userInfoDao.selectByUserInfo(userInfo);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public List<UserInfo> selectAll() {
        return userInfoDao.selectAll();
    }

    @Override
    public UserInfo selectByid(Integer id) {
        return userInfoDao.selectByid(id);
    }
}

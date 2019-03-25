package com.eSports.system.data.service.impl;

import com.eSports.system.data.dao.NewsInfoDao;
import com.eSports.system.data.entity.NewsInfo;
import com.eSports.system.data.service.NewsInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {
    @Resource
    private NewsInfoDao newsInfoDao;

    @Override
    public Integer insertNewsInfo(NewsInfo newsInfo) {
        return newsInfoDao.insertNewsInfo(newsInfo);
    }

    @Override
    public Integer deleteNewsInfo(Integer id) {
        return newsInfoDao.deleteNewsInfo(id);
    }

    @Override
    public List<NewsInfo> selectByNewsInfo(NewsInfo newsInfo) {
        return newsInfoDao.selectByNewsInfo(newsInfo);
    }

    @Override
    public Integer updateNewsInfo(NewsInfo newsInfo) {
        return newsInfoDao.updateNewsInfo(newsInfo);
    }

    @Override
    public List<NewsInfo> selectAll() {
        return newsInfoDao.selectAll();
    }

    @Override
    public NewsInfo selectByid(Integer id) {
        return newsInfoDao.selectByid(id);
    }
}

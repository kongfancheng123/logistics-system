package com.eSports.system.data.controller;

import com.eSports.system.data.entity.NewsInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.page.PageBean;
import com.eSports.system.data.qo.SelectByNewsInfoQo;
import com.eSports.system.data.service.NewsInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value = "/NewsInfo")
public class NewsController {
    @Resource
    private NewsInfoService newsInfoService;


    /**
     * 添加新闻
     */
    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse addNews(@RequestBody NewsInfo newsInfo) {
        Integer integer = newsInfoService.insertNewsInfo(newsInfo);
        return WebResponse.success();
    }

    /**
     * 查询所有新闻
     */
    @RequestMapping(value = "/selectAllNews", method = RequestMethod.GET)
    @ResponseBody
    public WebResponse selectAllNews() {
        List<NewsInfo> newsInfos = newsInfoService.selectAll();
        return WebResponse.success(newsInfos);
    }

    /**
     * 条件查询新闻
     */
    @RequestMapping(value = "/selectByNewsInfo", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse selectByNewsInfo(@RequestBody SelectByNewsInfoQo selectByNewsInfoQo) {

        Integer pageNow = selectByNewsInfoQo.getPageNow();
        Integer pageSize = selectByNewsInfoQo.getPageSize();
        Integer countNums = newsInfoService.selectAll().size();
        NewsInfo newsInfo=new NewsInfo();
        newsInfo.setNewsName(selectByNewsInfoQo.getNewsName());
        PageHelper.startPage(pageNow, pageSize);
        List<NewsInfo> newsInfos = newsInfoService.selectByNewsInfo(newsInfo);
        PageBean<NewsInfo> pageData = new PageBean<>(pageNow, pageSize, countNums);
        pageData.setItems(newsInfos);

        return WebResponse.success(pageData);
    }

    /**
     * 更新新闻
     */
    @RequestMapping(value = "/updateNews", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateNews(@RequestBody NewsInfo newsInfo) {
        Integer integer = newsInfoService.updateNewsInfo(newsInfo);
        return WebResponse.success();
    }

    /**
     * 删除新闻
     */
    @RequestMapping(value = "/deleteNews", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse deleteNews(@RequestBody NewsInfo newsInfo) {
        Integer integer = newsInfoService.deleteNewsInfo(newsInfo.getId());
        return WebResponse.success();
    }

}

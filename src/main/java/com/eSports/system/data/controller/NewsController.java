package com.eSports.system.data.controller;

import com.eSports.system.data.entity.GameInfo;
import com.eSports.system.data.entity.NewsInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.service.GameInfoService;
import com.eSports.system.data.service.NewsInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by fchkong on 2019/3/25.
 */
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
    public WebResponse selectByNewsInfo(@RequestBody NewsInfo newsInfo) {
        List<NewsInfo> newsInfos = newsInfoService.selectByNewsInfo(newsInfo);
        return WebResponse.success(newsInfos);
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
    @RequestMapping(value = "/deleteNews", method = RequestMethod.GET)
    @ResponseBody
    public WebResponse deleteNews(@RequestParam Integer id) {
        Integer integer = newsInfoService.deleteNewsInfo(id);
        return WebResponse.success();
    }

}

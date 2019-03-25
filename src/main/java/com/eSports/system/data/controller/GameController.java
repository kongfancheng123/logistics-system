package com.eSports.system.data.controller;

import com.eSports.system.data.entity.GameInfo;
import com.eSports.system.data.entity.UserInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.service.GameInfoService;
import com.eSports.system.data.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by fchkong on 2019/3/25.
 */
@RestController
@RequestMapping(value = "/GameInfo")
public class GameController {
    @Resource
    private GameInfoService gameInfoService;


    /**
     * 添加赛事
     */
    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse addGame(@RequestBody GameInfo gameInfo) {
        Integer integer = gameInfoService.insertGameInfo(gameInfo);
        return WebResponse.success();
    }

    /**
     * 查询所有赛事
     */
    @RequestMapping(value = "/selectAllGame", method = RequestMethod.GET)
    @ResponseBody
    public WebResponse selectAllGame() {
        List<GameInfo> gameInfos = gameInfoService.selectAll();
        return WebResponse.success(gameInfos);
    }

    /**
     * 条件查询赛事
     */
    @RequestMapping(value = "/selectByGameInfo", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse selectByGameInfo(@RequestBody GameInfo gameInfo) {
        List<GameInfo> gameInfos = gameInfoService.selectByGameInfo(gameInfo);
        return WebResponse.success(gameInfos);
    }

    /**
     * 更新赛事
     */
    @RequestMapping(value = "/updateGame", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateGame(@RequestBody GameInfo gameInfo) {
        Integer integer = gameInfoService.updateGameInfo(gameInfo);
        return WebResponse.success();
    }

    /**
     * 删除赛事
     */
    @RequestMapping(value = "/deleteGame", method = RequestMethod.GET)
    @ResponseBody
    public WebResponse deleteGame(@RequestParam Integer id) {
        Integer integer = gameInfoService.deleteGameInfo(id);
        return WebResponse.success();
    }

}

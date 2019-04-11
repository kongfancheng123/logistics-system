package com.eSports.system.data.controller;

import com.eSports.system.data.Vo.GameInfoVo;
import com.eSports.system.data.entity.GameInfo;
import com.eSports.system.data.entity.UserInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.page.PageBean;
import com.eSports.system.data.qo.AddGameQo;
import com.eSports.system.data.qo.SelectByGameInfoQo;
import com.eSports.system.data.qo.UpdateGameQo;
import com.eSports.system.data.service.GameInfoService;
import com.eSports.system.data.service.UserInfoService;
import com.eSports.system.data.util.TimeUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


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
    public WebResponse addGame(@RequestBody AddGameQo addGameQo) {

        try {
            GameInfo gameInfo=new GameInfo();
            gameInfo.setGameName(addGameQo.getGameName());
            gameInfo.setGameDesc(addGameQo.getGameDesc());
            gameInfo.setGameTime(TimeUtil.stringToDate(addGameQo.getGameTime()));
            Integer integer = gameInfoService.insertGameInfo(gameInfo);
            return WebResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return WebResponse.error(400,"添加失败");
        }
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
    public WebResponse selectByGameInfo(@RequestBody SelectByGameInfoQo selectByGameInfoQo) {

        List<GameInfoVo> gameInfos=new ArrayList<>();
        GameInfo gameInfo=new GameInfo();
        gameInfo.setGameName(selectByGameInfoQo.getGameName()==""?null:selectByGameInfoQo.getGameName());
        Integer pageNow = selectByGameInfoQo.getPageNow();
        Integer pageSize = selectByGameInfoQo.getPageSize();
        Integer countNums = gameInfoService.selectAll().size();
        PageHelper.startPage(pageNow, pageSize);
        List<GameInfo> gameInfos1 = gameInfoService.selectByGameInfo(gameInfo);
        for(GameInfo gameInfo1:gameInfos1){
            GameInfoVo gameInfo2=new GameInfoVo();
            gameInfo2.setId(gameInfo1.getId());
            gameInfo2.setGameDesc(gameInfo1.getGameDesc());
            gameInfo2.setGameName(gameInfo1.getGameName());
            gameInfo2.setGameTime(TimeUtil.format(gameInfo1.getGameTime(),"yyyy-MM-dd HH:mm:ss"));
            gameInfos.add(gameInfo2);
        }
        PageBean<GameInfoVo> pageData = new PageBean<>(pageNow, pageSize, countNums);
        pageData.setItems(gameInfos);
        return WebResponse.success(pageData);
    }

    /**
     * 更新赛事
     */
    @RequestMapping(value = "/updateGame", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateGame(@RequestBody UpdateGameQo updateGameQo) {
        try {
            GameInfo gameInfo=new GameInfo();
            gameInfo.setId(updateGameQo.getId());
            gameInfo.setGameName(updateGameQo.getGameName());
            gameInfo.setGameDesc(updateGameQo.getGameDesc());
            gameInfo.setGameTime(TimeUtil.stringToDate(updateGameQo.getGameTime()));
            Integer integer = gameInfoService.updateGameInfo(gameInfo);
            return WebResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return  WebResponse.error(400,"更新失败");
        }
    }

    /**
     * 删除赛事
     */
    @RequestMapping(value = "/deleteGame", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse deleteGame(@RequestBody GameInfo gameInfo) {
        Integer integer = gameInfoService.deleteGameInfo(gameInfo.getId());
        return WebResponse.success();
    }

}

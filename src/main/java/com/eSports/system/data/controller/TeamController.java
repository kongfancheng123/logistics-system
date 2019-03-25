package com.eSports.system.data.controller;

import com.eSports.system.data.entity.GameInfo;
import com.eSports.system.data.entity.TeamInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.service.GameInfoService;
import com.eSports.system.data.service.TeamInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by fchkong on 2019/3/25.
 */
@RestController
@RequestMapping(value = "/TeamInfo")
public class TeamController {
    @Resource
    private TeamInfoService teamInfoService;


    /**
     * 添加战队
     */
    @RequestMapping(value = "/addTeam", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse addTeam(@RequestBody TeamInfo teamInfo) {
        Integer integer = teamInfoService.insertTeamInfo(teamInfo);
        return WebResponse.success();
    }

    /**
     * 查询所有战队
     */
    @RequestMapping(value = "/selectAllTeam", method = RequestMethod.GET)
    @ResponseBody
    public WebResponse selectAllTeam() {
        List<TeamInfo> teamInfos = teamInfoService.selectAll();
        return WebResponse.success(teamInfos);
    }

    /**
     * 条件查询战队
     */
    @RequestMapping(value = "/selectByTeamInfo", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse selectByTeamInfo(@RequestBody TeamInfo teamInfo) {
        List<TeamInfo> teamInfos = teamInfoService.selectByTeamInfo(teamInfo);
        return WebResponse.success(teamInfos);
    }

    /**
     * 更新战队
     */
    @RequestMapping(value = "/updateTeam", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateTeam(@RequestBody TeamInfo teamInfo) {
        Integer integer = teamInfoService.updateTeamInfo(teamInfo);
        return WebResponse.success();
    }

    /**
     * 删除战队
     */
    @RequestMapping(value = "/deleteTeam", method = RequestMethod.GET)
    @ResponseBody
    public WebResponse deleteTeam(@RequestParam Integer id) {
        Integer integer = teamInfoService.deleteTeamInfo(id);
        return WebResponse.success();
    }

}

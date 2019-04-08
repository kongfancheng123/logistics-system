package com.eSports.system.data.controller;

import com.eSports.system.data.entity.GameInfo;
import com.eSports.system.data.entity.NewsInfo;
import com.eSports.system.data.entity.TeamInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.page.PageBean;
import com.eSports.system.data.service.GameInfoService;
import com.eSports.system.data.service.TeamInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
//        Integer integer = teamInfoService.insertTeamInfo(teamInfo);
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
//        List<TeamInfo> teamInfos = teamInfoService.selectByTeamInfo(teamInfo);
        List<TeamInfo> teamInfos=new ArrayList<>();
        TeamInfo teamInfo1=new TeamInfo();
        teamInfo1.setId(1);
        teamInfo1.setTeamName("湖人");
        teamInfo1.setTeamDesc("这是一支历史悠久的战队");

        TeamInfo teamInfo2=new TeamInfo();
        teamInfo2.setId(2);
        teamInfo2.setTeamName("凯尔特人");
        teamInfo2.setTeamDesc("这是一支历史悠久的战队1111");

        teamInfos.add(teamInfo1);
        teamInfos.add(teamInfo2);

        PageBean<TeamInfo> pageData = new PageBean<>(1, 30, 2);
        pageData.setItems(teamInfos);

        return WebResponse.success(pageData);
    }

    /**
     * 更新战队
     */
    @RequestMapping(value = "/updateTeam", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateTeam(@RequestBody TeamInfo teamInfo) {
//        Integer integer = teamInfoService.updateTeamInfo(teamInfo);
        return WebResponse.success();
    }

    /**
     * 删除战队
     */
    @RequestMapping(value = "/deleteTeam", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse deleteTeam(@RequestBody TeamInfo teamInfo) {
//        Integer integer = teamInfoService.deleteTeamInfo(teamInfo.getId());
        return WebResponse.success();
    }

}

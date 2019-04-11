package com.eSports.system.data.controller;

import com.eSports.system.data.entity.TeamInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.page.PageBean;
import com.eSports.system.data.qo.SelectByTeamInfoQo;
import com.eSports.system.data.service.TeamInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public WebResponse selectByTeamInfo(@RequestBody SelectByTeamInfoQo selectByTeamInfoQo) {
        Integer pageNow = selectByTeamInfoQo.getPageNow();
        Integer pageSize = selectByTeamInfoQo.getPageSize();
        Integer countNums = teamInfoService.selectAll().size();
        TeamInfo teamInfo=new TeamInfo();
        teamInfo.setTeamName(selectByTeamInfoQo.getTeamName()==""?null:selectByTeamInfoQo.getTeamName());
        PageHelper.startPage(pageNow, pageSize);
        List<TeamInfo> teamInfos = teamInfoService.selectByTeamInfo(teamInfo);
        PageBean<TeamInfo> pageData = new PageBean<>(pageNow, pageSize, countNums);
        pageData.setItems(teamInfos);

        return WebResponse.success(pageData);
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
    @RequestMapping(value = "/deleteTeam", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse deleteTeam(@RequestBody TeamInfo teamInfo) {
        Integer integer = teamInfoService.deleteTeamInfo(teamInfo.getId());
        return WebResponse.success();
    }

}

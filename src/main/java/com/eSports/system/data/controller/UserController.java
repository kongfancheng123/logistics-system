package com.eSports.system.data.controller;

import com.eSports.system.data.entity.UserInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.page.PageBean;
import com.eSports.system.data.qo.SelectByUserInfoQo;
import com.eSports.system.data.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/UserInfo")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    /**
     * 登录
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse login(@RequestBody UserInfo userInfo) {
        List<UserInfo> userInfos = userInfoService.selectByUserInfo(userInfo);
        if (userInfos.size()>0){
            return WebResponse.success(userInfos.get(0));
        }else{
            return WebResponse.error(400,"用户名或密码错误");
        }
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse register(@RequestBody UserInfo userInfo) {
        //先查询
        UserInfo userInfo1=new UserInfo();
        userInfo1.setUserName(userInfo.getUserName());
        List<UserInfo> userInfos = userInfoService.selectByUserInfo(userInfo1);
        if(userInfos.size()>0){
            return WebResponse.error(400,"用户名已存在");
        }else{
            userInfo.setUserRole(0);
            Integer integer = userInfoService.insertUserInfo(userInfo);
            return WebResponse.success("注册成功");
        }
    }

    /**
     * 查询所有用户
     */
    @RequestMapping(value = "/selectAllUser", method = RequestMethod.GET)
    @ResponseBody
    public WebResponse selectAllUser() {
        List<UserInfo> userInfos = userInfoService.selectAll();
        return WebResponse.success(userInfos);
    }

    /**
     * 条件查询用户
     */
    @RequestMapping(value = "/selectByUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse selectByUserInfo(@RequestBody SelectByUserInfoQo selectByUserInfoQo) {
        Integer pageNow = selectByUserInfoQo.getPageNow();
        Integer pageSize = selectByUserInfoQo.getPageSize();
        Integer countNums = userInfoService.selectAll().size();
        UserInfo userInfo=new UserInfo();
        userInfo.setUserRole(0);
        userInfo.setUserName(selectByUserInfoQo.getUserName());
        PageHelper.startPage(pageNow, pageSize);
        List<UserInfo> userInfos = userInfoService.selectByUserInfo(userInfo);
        PageBean<UserInfo> pageData = new PageBean<>(pageNow, pageSize, countNums);
        pageData.setItems(userInfos);

        return WebResponse.success(pageData);
    }

    /**
     * 更新用户
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateUser(@RequestBody UserInfo userInfo) {
        Integer integer = userInfoService.updateUserInfo(userInfo);
        return WebResponse.success();
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse deleteUser(@RequestBody UserInfo userInfo) {
        Integer integer = userInfoService.deleteUserInfo(userInfo.getId());
        return WebResponse.success();
    }

}

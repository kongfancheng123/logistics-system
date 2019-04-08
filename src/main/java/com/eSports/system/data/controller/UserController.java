package com.eSports.system.data.controller;

import com.eSports.system.data.entity.UserInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.page.PageBean;
import com.eSports.system.data.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        userInfo.setId(1);
        userInfo.setUserRole(0);
//        List<UserInfo> userInfos = userInfoService.selectByUserInfo(userInfo);
//        if (userInfos.size()>0){
//            return WebResponse.success();
//        }else{
//            return WebResponse.error(400,"用户名或密码错误");
//        }
//        return WebResponse.success(userInfo);
        return WebResponse.error(400,"用户名或密码错误");
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse register(@RequestBody UserInfo userInfo) {
        userInfo.setUserRole(0);
//        Integer integer = userInfoService.insertUserInfo(userInfo);
//        return WebResponse.success("注册成功");
        return WebResponse.error(400,"用户名已存在");
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
    public WebResponse selectByUserInfo(@RequestBody UserInfo userInfo) {
//        List<UserInfo> userInfos = userInfoService.selectByUserInfo(userInfo);

        List<UserInfo> userInfos=new ArrayList<>();
        UserInfo userInfo1=new UserInfo();
        userInfo1.setId(1);
        userInfo1.setUserName("kfc");
        userInfo1.setPassword("kfc1111");
        userInfo1.setUserRole(0);

        UserInfo userInfo2=new UserInfo();
        userInfo2.setId(2);
        userInfo2.setUserName("kfc");
        userInfo2.setPassword("kfc1111");
        userInfo2.setUserRole(0);

        userInfos.add(userInfo1);
        userInfos.add(userInfo2);

        PageBean<UserInfo> pageData = new PageBean<>(1, 30, 2);
        pageData.setItems(userInfos);

        return WebResponse.success(pageData);
    }

    /**
     * 更新用户
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateUser(@RequestBody UserInfo userInfo) {
//        Integer integer = userInfoService.updateUserInfo(userInfo);
        return WebResponse.success();
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse deleteUser(@RequestBody UserInfo userInfo) {
//        Integer integer = userInfoService.deleteUserInfo(userInfo.getId());
        return WebResponse.success();
    }

}

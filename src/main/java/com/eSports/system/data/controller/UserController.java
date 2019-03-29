package com.eSports.system.data.controller;

import com.eSports.system.data.entity.UserInfo;
import com.eSports.system.data.entity.WebResponse;
import com.eSports.system.data.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by fchkong on 2019/3/25.
 */
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
//        List<UserInfo> userInfos = userInfoService.selectByUserInfo(userInfo);
//        if (userInfos.size()>0){
//            return WebResponse.success();
//        }else{
//            return WebResponse.error(400,"用户名或密码错误");
//        }
        return WebResponse.success(userInfo);
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse register(@RequestBody UserInfo userInfo) {
        Integer integer = userInfoService.insertUserInfo(userInfo);
        return WebResponse.success();
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
        List<UserInfo> userInfos = userInfoService.selectByUserInfo(userInfo);
        return WebResponse.success(userInfos);
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
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    @ResponseBody
    public WebResponse deleteUser(@RequestParam Integer id) {
        Integer integer = userInfoService.deleteUserInfo(id);
        return WebResponse.success();
    }

}

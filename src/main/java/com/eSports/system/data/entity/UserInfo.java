package com.eSports.system.data.entity;

import lombok.Data;


@Data
public class UserInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户角色  0普通用户  1管理员
     */
    private Integer userRole;
}

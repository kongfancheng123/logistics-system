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
}

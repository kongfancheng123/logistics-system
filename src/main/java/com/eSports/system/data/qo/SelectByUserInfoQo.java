package com.eSports.system.data.qo;

import lombok.Data;

@Data
public class SelectByUserInfoQo {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 当前页
     */
    private Integer pageNow;
    /**
     * 每页显示数量
     */
    private Integer pageSize;
}

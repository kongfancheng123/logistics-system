package com.eSports.system.data.qo;

import lombok.Data;

@Data
public class SelectByGameInfoQo {
    /**
     * 赛事名称
     */
    private String gameName;
    /**
     * 当前页
     */
    private Integer pageNow;
    /**
     * 每页显示数量
     */
    private Integer pageSize;
}

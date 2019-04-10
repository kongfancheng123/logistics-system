package com.eSports.system.data.qo;

import lombok.Data;

@Data
public class SelectByTeamInfoQo {
    /**
     * 战队名
     */
    private String teamName;
    /**
     * 当前页
     */
    private Integer pageNow;
    /**
     * 每页显示数量
     */
    private Integer pageSize;
}

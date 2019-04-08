package com.eSports.system.data.qo;

import lombok.Data;

@Data
public class SelectByNewsInfoQo {
    /**
     * 新闻名
     */
    private String newsName;
    /**
     * 当前页
     */
    private Integer pageNow;
    /**
     * 每页显示数量
     */
    private Integer pageSize;
}

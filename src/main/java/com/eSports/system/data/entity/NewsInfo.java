package com.eSports.system.data.entity;

import lombok.Data;

@Data
public class NewsInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * 新闻名
     */
    private String newsName;
    /**
     * 新闻描述
     */
    private String newsDesc;

}

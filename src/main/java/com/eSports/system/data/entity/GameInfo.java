package com.eSports.system.data.entity;

import lombok.Data;


@Data
public class GameInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * 赛事简称
     */
    private String gameName;
    /**
     * 赛事描述
     */
    private String gameDesc;
}

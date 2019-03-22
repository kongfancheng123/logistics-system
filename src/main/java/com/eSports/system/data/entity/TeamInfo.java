package com.eSports.system.data.entity;

import lombok.Data;

@Data
public class TeamInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * 战队名
     */
    private String teamName;
    /**
     * 战队信息
     */
    private String teamDesc;
}

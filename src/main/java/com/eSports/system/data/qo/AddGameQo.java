package com.eSports.system.data.qo;

import lombok.Data;


@Data
public class AddGameQo {
    /**
     * 赛事简称
     */
    private String gameName;
    /**
     * 赛事描述
     */
    private String gameDesc;
    /**
     * 赛事时间
     */
    private String gameTime;
}

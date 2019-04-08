package com.eSports.system.data.qo;

import lombok.Data;

@Data
public class UpdateGameQo {
    /**
     * id
     */
    private Integer id;
    /**
     * 赛事名
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

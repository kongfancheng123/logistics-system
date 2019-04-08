package com.eSports.system.data.Vo;

import lombok.Data;

/**
 * Create by fchkong on 2019/4/2.
 */
@Data
public class GameInfoVo {
    /**
     * id
     */
    private Integer id;
    /**
     * 赛事名称
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

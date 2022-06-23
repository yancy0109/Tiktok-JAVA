package com.tiktok.app.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


/**
 * 关注表对应实体
 */
@Data
@AllArgsConstructor
public class Follow {
    //被关注人id
    private Integer befollow;
    //关注人id
    private Integer follow;
    //关注存在状态
    private Integer isdel;
    //更改状态日期  创建or取消
    private Date updatetime;
}

package com.tiktok.app.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 视频表对应实体
 */
@Data
@AllArgsConstructor
public class Video {
    //视频作者唯一id
    private Integer authorid;
    //视频标题
    private String title;
    //视频地址
    private String playurl;
    //封面地址
    private String coverurl;
    //评论创建日期
    private Date createdate;
    //视频状态
    private boolean status;
}

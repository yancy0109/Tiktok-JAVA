package com.tiktok.app.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 评论表对应实体
 */
@Data
@AllArgsConstructor
public class Comment {
    //视频唯一id
    private Integer videoid;
    //作者唯一id
    private Integer authorid;
    //评论内容
    private String content;
    //评论创建日期
    private Date createdate;
    //评论状态
    private Integer status;
}

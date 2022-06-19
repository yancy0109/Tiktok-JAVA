package com.tiktok.app.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 评论相关信息
 */
@Data
@AllArgsConstructor
public class CommentInfo {
    //评论id
    private Integer id;
    //评论作者信息
    private UserInfo user;
    //评论内容
    private String content;
    //评论创建日期
    private Date createdate;
}

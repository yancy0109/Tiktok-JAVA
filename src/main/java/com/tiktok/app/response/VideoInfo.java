package com.tiktok.app.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 返回视频及相关信息
 */
@Data
@AllArgsConstructor
public class VideoInfo {
    //视频id
    private Integer id;
    //视频作者信息
    private UserInfo user;
    //视频地址
    private String playurl;
    //封面地址
    private String coverurl;
    //点赞总数
    private Integer favorite_count;
    //评论总数
    private Integer comment_count;
    //是否点赞
    private boolean is_favorite;
    //视频标题
    private String title;
}

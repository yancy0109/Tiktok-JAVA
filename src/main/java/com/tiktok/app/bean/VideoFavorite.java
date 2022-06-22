package com.tiktok.app.bean;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


/**
 *视频点赞表对应实体
 */
@Data
@AllArgsConstructor
public class VideoFavorite {
    //视频唯一id
    private Integer videoid;
    //点赞用户id
    private Integer userid;
    //点赞状态
    private Integer status;
    //创建日期
    private Date createdate;
}

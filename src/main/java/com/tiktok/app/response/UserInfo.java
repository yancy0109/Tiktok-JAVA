package com.tiktok.app.response;


import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 返回用户信息实体类
 */
@Data
@AllArgsConstructor
public class UserInfo {
    //用户对应唯一userid
    private Integer id;
    //用户name
    private String username;
    //用户关注总数
    private Integer follow_count;
    //用户粉丝总数
    private Integer follower_count;
    //关注状态
    private boolean is_follow;

}

package com.tiktok.app.serivce;


import com.tiktok.app.bean.Follow;
import com.tiktok.app.response.CommentList;

import java.util.Date;

public interface FollowService {
    /**
     * 用户进行关注，并保存到数据库。
     * @return
     */
    boolean saveFollow(Follow follow);

    /**
     * 用户更新关注操作
     */
    boolean updateFollow(Integer befollow, Integer follow, Date date,Integer status);

}

package com.tiktok.app.serivce.lmpl;


import com.tiktok.app.bean.Comment;
import com.tiktok.app.bean.Follow;
import com.tiktok.app.bean.User;
import com.tiktok.app.bean.Video;
import com.tiktok.app.mapper.*;
import com.tiktok.app.response.CommentInfo;
import com.tiktok.app.response.CommentList;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.response.VideoInfo;
import com.tiktok.app.serivce.CommentService;
import com.tiktok.app.serivce.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowMapper followMapper;

    @Override
    public boolean saveFollow(Follow follow) {
        int result = followMapper.addFollow(follow);
        if (result == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateFollow(Integer befollow, Integer follow, Date date, Integer status) {
        int result = followMapper.undateFollow(new Follow(befollow,follow,status,date));
        if (result == 0) {
            return false;
        }
        return true;
    }


}

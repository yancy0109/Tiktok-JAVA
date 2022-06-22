package com.tiktok.app.serivce.lmpl;

import com.tiktok.app.bean.User;
import com.tiktok.app.mapper.*;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.serivce.FollowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowListServiceImpl implements FollowListService {

    @Autowired
    VideoMapper videoMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    VideoFavoriteMapper videoFavoriteMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    FollowMapper followMapper;


    /**
     *获取关注列表
     * @param  userId
     * @return List<UserInfo>
     */
    @Override
    public List<UserInfo> getFollowList(Integer userId) {
        List<UserInfo> userInfos = new ArrayList<>();
        List<Integer> followList = followMapper.getFollowList(userId);
        for (Integer followId : followList) {
            User authord = userMapper.findUserById(followId);
            int follow = followMapper.countFollowCountById(authord.getUserid());
            int follower = followMapper.countFollowerCountById(authord.getUserid());
            int i = followMapper.selectFollowStatus(userId, authord.getUserid());
            boolean isFollow = (i == 1);
            UserInfo userInfo = new UserInfo(authord.getUserid(), authord.getUsername(), follow, follower, isFollow);
            userInfos.add(userInfo);
        }
        return userInfos;
    }

    /**
     *获取粉丝列表
     * @param userId
     * @return List<UserInfo>
     */
    @Override
    public List<UserInfo> getFollowerList(Integer userId) {
        List<UserInfo> userInfos = new ArrayList<>();
        List<Integer> followList = followMapper.getFollowerList(userId);
        for (Integer followId : followList) {
            User authord = userMapper.findUserById(followId);
            int follow = followMapper.countFollowCountById(authord.getUserid());
            int follower = followMapper.countFollowerCountById(authord.getUserid());
            int i = followMapper.selectFollowStatus(userId, authord.getUserid());
            boolean isFollow = (i == 1);
            UserInfo userInfo = new UserInfo(authord.getUserid(), authord.getUsername(), follow, follower, isFollow);
            userInfos.add(userInfo);
        }
        return userInfos;
    }
}

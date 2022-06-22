package com.tiktok.app.serivce;

import com.tiktok.app.response.UserInfo;

import java.util.List;

public interface FollowListService {

    List<UserInfo> getFollowList(Integer userId);


    List<UserInfo> getFollowerList(Integer userId);
}

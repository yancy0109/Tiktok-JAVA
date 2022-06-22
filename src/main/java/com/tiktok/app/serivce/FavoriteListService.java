package com.tiktok.app.serivce;

import com.tiktok.app.response.VideoInfo;

import java.util.List;

public interface FavoriteListService {
    List<VideoInfo> getFavoriteList(Integer userId);
}

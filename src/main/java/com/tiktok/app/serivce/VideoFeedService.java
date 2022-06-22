package com.tiktok.app.serivce;

import com.tiktok.app.response.VideoInfo;

import java.util.ArrayList;

public interface VideoFeedService {

    ArrayList<VideoInfo> getVideoFeed(Integer userId,boolean hasUserId);
}

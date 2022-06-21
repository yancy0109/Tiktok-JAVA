package com.tiktok.app.controller;


import com.tiktok.app.response.VideoInfo;
import com.tiktok.app.serivce.VideoFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class VideoFeedController {

    @Autowired
    VideoFeedService videoFeedService;

    @RequestMapping(value = "/douyin/feed",method = RequestMethod.GET)
    public String videoFeed(HttpSession session, Model model){
        Integer userId = (Integer) session.getAttribute("user_id");
        ArrayList<VideoInfo> videoInfos;
        if (userId == null){
             videoInfos = videoFeedService.getVideoFeed(userId, false);
        }else {
            videoInfos = videoFeedService.getVideoFeed(userId, true);
            model.addAttribute("hasUserId",true);
        }
        model.addAttribute("videoInfos",videoInfos);
        System.out.println(videoInfos);
        return "videofeed";
    }
}

package com.tiktok.app.controller;

import com.tiktok.app.response.UserInfo;
import com.tiktok.app.serivce.FollowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FollowListController {

    @Autowired
    FollowListService followListService;

    @RequestMapping(value = "/douyin/relation/follow/list/",method = RequestMethod.GET)
    public String getFollowList(HttpSession session, Model model){
        Integer userId = (Integer)session.getAttribute("user_id");
        List<UserInfo> followList = followListService.getFollowList(userId);
        model.addAttribute("user_id",userId);
        model.addAttribute("followList",followList);
        return "followList";
    }
    @RequestMapping(value = "/douyin/relation/follower/list/",method = RequestMethod.GET)
    public String getFollowerList(HttpSession session, Model model){
        Integer userId = (Integer)session.getAttribute("user_id");
        List<UserInfo> followerList = followListService.getFollowerList(userId);
        model.addAttribute("user_id",userId);
        model.addAttribute("followerList",followerList);
        return "followerList";
    }
}

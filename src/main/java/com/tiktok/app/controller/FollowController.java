package com.tiktok.app.controller;

import com.tiktok.app.bean.Follow;
import com.tiktok.app.mapper.CommentMapper;
import com.tiktok.app.serivce.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author bai
 * @version 1.0
 */
@RestController
public class FollowController {

    @Autowired
    FollowService followService;
    @Autowired
    CommentMapper commentMapper;


    @RequestMapping(value = "/douyin/relation/action/",method = RequestMethod.POST)
    String saveFollow(@RequestParam("video_id") Integer videoId, @RequestParam("action_type") Integer status, HttpSession session, RedirectAttributes attributes) {
        int follower = (Integer) session.getAttribute("user_id");
        int beFollower = commentMapper.InquaryAuthor(videoId);
        if (status==1) {
            if (!followService.saveFollow(new Follow(beFollower,follower,status,new Date()))) {
//                attributes.addAttribute("upload_msg", "关注失败");
//                return "followList";
                return "关注失败";
            }
//            attributes.addAttribute("upload_msg", "关注成功");
//            return "followList";
            return "关注失败";
        } else {
            if (!followService.deleteFollow(beFollower,follower,new Date())) {
//                attributes.addAttribute("upload_msg", "取消关注失败");
//                return "followList";
                return "取消关注失败";
            }
//            attributes.addAttribute("upload_msg", "取消关注成功");
//            return "followList";
            return "取消关注成功";
        }
    }


}

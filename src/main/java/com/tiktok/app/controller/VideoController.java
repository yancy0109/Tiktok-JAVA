package com.tiktok.app.controller;


import com.tiktok.app.response.UserInfo;
import com.tiktok.app.response.VideoInfo;
import com.tiktok.app.serivce.UserService;
import com.tiktok.app.serivce.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class VideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/douyin/publish/action/",method = RequestMethod.POST)
    String pushVideo(@RequestParam("title") String title, @RequestParam("data") MultipartFile file, HttpSession session, RedirectAttributes attributes){
        Integer authorId = (Integer) session.getAttribute("user_id");
        String filename = authorId+"_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
//        System.out.println(filename);
        if (file == null){
            attributes.addAttribute("upload_msg","上传失败");
            return "redirect:/douyin/user/";
        }
        if (!videoService.saveVideoAndCover(file,filename,title,authorId)){
            attributes.addAttribute("upload_msg","上传失败");
            return "redirect:/douyin/user/";
        }
        attributes.addAttribute("upload_msg","上传成功");
        return "redirect:/douyin/user/";
    }

    @RequestMapping(value = "/douyin/publish/list/",method = RequestMethod.GET)
    String pulishList(Model model,HttpSession session,RedirectAttributes attributes){
        Integer userId = (Integer) session.getAttribute("user_id");
        UserInfo userInfo = userService.showUserInfo(userId);
        if (userInfo == null){
            attributes.addAttribute("space_msg","查看失败");
            return "redirect:/douyin/user/";
        }
        ArrayList<VideoInfo> videoInfos = videoService.selectPublish(userId, userInfo);
        model.addAttribute("videoInfos",videoInfos);
        return "useruploadfile";
    }
}

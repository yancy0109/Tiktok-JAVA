package com.tiktok.app.controller;


import com.tiktok.app.serivce.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;



@Controller
public class VideoController {
    @Autowired
    VideoService videoService;

    @RequestMapping(value = "/douyin/publish/action/",method = RequestMethod.POST)
    String pushVideo(@RequestParam("title") String title, @RequestParam("data") MultipartFile file, HttpSession session, RedirectAttributes attributes){
        Integer authorId = (Integer) session.getAttribute("user_id");
        String filename = authorId+"_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
//        System.out.println(filename);
        if (!videoService.saveVideoAndCover(file,filename,title,authorId)){
            attributes.addAttribute("upload_msg","上传失败");
            return "redirect:/douyin/user/";
        }
        attributes.addAttribute("upload_msg","上传成功");
        return "redirect:/douyin/user/";
    }
}

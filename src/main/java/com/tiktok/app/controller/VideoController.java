package com.tiktok.app.controller;


import com.tiktok.app.serivce.VideoService;
import com.tiktok.app.until.JwtUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;



@RestController
public class VideoController {
    @Autowired
    VideoService videoService;
    @RequestMapping(value = "/douyin/publish/action/",method = RequestMethod.POST)
    HashMap pushVideo(@RequestParam("token") String token, @RequestParam("title") String title,@RequestParam("data") MultipartFile file){
        Integer authorId = JwtUntil.parseToken(token);
        if (authorId == null){
            HashMap map = new HashMap<String,Object>();
            map.put("status_code",-1);
            map.put("status_msg","token无效");
            return map;
        }
        String filename = authorId+"_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
//        System.out.println(filename);
        if (!videoService.saveVideoAndCover(file,filename,title,authorId)){
            HashMap map = new HashMap<String,Object>();
            map.put("status_code",-1);
            map.put("status_msg","上传失败");
            return map;
        }
        HashMap map = new HashMap<String,Object>();
        map.put("status_code",0);
        map.put("status_msg","上传成功");
        return map;
    }
}

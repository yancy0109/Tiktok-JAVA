package com.tiktok.app.controller;

import com.tiktok.app.serivce.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author bai
 * @version 1.0
 */
@Controller
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;


    @RequestMapping(value = "/douyin/favourite/action/",method = RequestMethod.POST)
    String saveFavourite(@RequestParam("video_id") Integer videoId, @RequestParam("action_type") Integer status, HttpSession session, RedirectAttributes attributes) {
        int authorId = (Integer) session.getAttribute("user_id");
        if (status==1) {
            if (!favoriteService.favoriteAdd(videoId,authorId,status)) {
                attributes.addAttribute("upload_msg", "点赞失败");
                return "redirect:/douyin/favourite/list";
            }
            attributes.addAttribute("upload_msg", "点赞成功");
            return "redirect:/douyin/favourite/list";
        } else {
            if (!favoriteService.favoriteUnAdd(videoId,authorId,status)) {
                attributes.addAttribute("upload_msg", "取消点赞失败");
                return "redirect:/douyin/favourite/list";
            }
            attributes.addAttribute("upload_msg", "取消点赞成功");
            return "redirect:/douyin/favourite/list";
        }
    }


}

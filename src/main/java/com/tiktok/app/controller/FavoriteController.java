package com.tiktok.app.controller;

import com.tiktok.app.mapper.VideoFavoriteMapper;
import com.tiktok.app.serivce.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author bai
 * @version 1.0
 */
@RestController
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;
    @Autowired
    VideoFavoriteMapper videoFavoriteMapper;


    @RequestMapping(value = "/douyin/favourite/action/",method = RequestMethod.POST)
    String saveFavourite(@RequestParam("video_id") Integer videoId, @RequestParam("action_type") Integer status, HttpSession session, RedirectAttributes attributes) {
        int authorId = (Integer) session.getAttribute("user_id");
        int exits = videoFavoriteMapper.inquery(videoId,authorId);
        if (status==1) {
            if (exits==0) {
                if (!favoriteService.favoriteAdd(videoId,authorId,status)) {
    //                attributes.addAttribute("upload_msg", "点赞失败");
    //                return "redirect:/douyin/favourite/list";
                    return "点赞失败";
                }
//            attributes.addAttribute("upload_msg", "点赞成功");
//            return "redirect:/douyin/favourite/list";
                return "点赞成功";
            } else {
                if (!favoriteService.favoriteUpdateAdd(videoId,authorId,status)) {
                    //                attributes.addAttribute("upload_msg", "点赞失败");
                    //                return "redirect:/douyin/favourite/list";
                    return "点赞失败";
                }
//            attributes.addAttribute("upload_msg", "点赞成功");
//            return "redirect:/douyin/favourite/list";
                return "点赞成功";
            }
        } else if (status==2){
            if (!favoriteService.favoriteUpdateAdd(videoId,authorId,status)) {
//                attributes.addAttribute("upload_msg", "取消点赞失败");
//                return "redirect:/douyin/favourite/list";
                return "取消点赞失败";
            }
//            attributes.addAttribute("upload_msg", "取消点赞成功");
//            return "redirect:/douyin/favourite/list";
            return "取消点赞成功";
        }else {
            return "操作失败";
        }
    }


}

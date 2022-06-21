package com.tiktok.app.controller;


import com.tiktok.app.serivce.CommentService;
import com.tiktok.app.serivce.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/douyin/comment/action/",method = RequestMethod.POST)
    String saveComment(@RequestParam("video_id") Integer videoId,@RequestParam("action_type") boolean status,@RequestParam("comment_text") String context, @RequestParam("comment_id") Integer commentId, HttpSession session, RedirectAttributes attributes) {
        int authorId = (Integer) session.getAttribute("user_id");
        if (status) {
            if (!commentService.saveComment(authorId, videoId, status, context)) {
                attributes.addAttribute("upload_msg", "评论失败");
                return "redirect:/douyin/user/";
            }
            attributes.addAttribute("upload_msg", "评论成功");
            return "redirect:/douyin/user/";
        } else {
            if (!commentService.deleteComment(authorId,videoId,commentId,status)) {
                attributes.addAttribute("upload_msg", "删除失败");
                return "redirect:/douyin/user/";
            }
            attributes.addAttribute("upload_msg", "删除成功");
            return "redirect:/douyin/user/";
        }
    }
}

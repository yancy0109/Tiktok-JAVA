package com.tiktok.app.controller;


import com.tiktok.app.response.VideoInfo;
import com.tiktok.app.serivce.FavoriteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FavoriteListController {

    @Autowired
    FavoriteListService favoriteListService;

    @RequestMapping(value = "/douyin/favorite/list/",method = RequestMethod.GET)
    public String getFavoriteList(HttpSession session, Model model){
        Integer userId = (Integer) session.getAttribute("user_id");
        if (userId == null)
            return "redirect:/login";
        List<VideoInfo> favoriteList = favoriteListService.getFavoriteList(userId);
        model.addAttribute("favoriteList",favoriteList);
        return "userfavorite";
    }
}

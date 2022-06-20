package com.tiktok.app.controller;


import com.tiktok.app.response.LoginAndResgiterResponese;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * 用户
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/douyin/user/register/",method = RequestMethod.POST)
    public String userRegister(@RequestParam String username, @RequestParam String password, HttpSession sesson,Model model){
        LoginAndResgiterResponese larResponse = userService.registerUser(username, password);
        //返回注册页
        if (larResponse == null){
            model.addAttribute("status_code",-1);
            model.addAttribute("status_msg","注册失败，用户名重复");
            sesson.setAttribute("user_id",null);
            sesson.setAttribute("token",null);
            return "register";
        }

        //正常跳转至用户信息
        model.addAttribute("status_code",0);
        model.addAttribute("status_msg","注册成功");
        sesson.setAttribute("user_id",larResponse.getUser_id());
        sesson.setAttribute("token",larResponse.getToken());
        return "redirect:/douyin/user/";
    }

    @RequestMapping(value = "/douyin/user/login/",method = RequestMethod.POST)
    public String userLogin(@RequestParam String username,@RequestParam String password, HttpSession sesson,Model model){
        LoginAndResgiterResponese loginAndResgiterResponese = userService.loginUser(username, password);
        //返回登录页
        if (loginAndResgiterResponese==null){
            model.addAttribute("status_code",-1);
            model.addAttribute("status_msg","登陆失败,用户名或密码错误");
            sesson.setAttribute("user_id",null);
            sesson.setAttribute("token",null);
            return "login";
        }
        //正常跳转至用户信息
        model.addAttribute("status_code",0);
        model.addAttribute("status_msg","登录成功");
        sesson.setAttribute("user_id",loginAndResgiterResponese.getUser_id());
        sesson.setAttribute("token",loginAndResgiterResponese.getToken());
        return "redirect:/douyin/user/";
    }

    @RequestMapping(value = "/douyin/user/",method = RequestMethod.GET)
    String userInfo(@RequestParam(value = "upload_msg",required = false) String upload_msg,Model model,HttpSession session){
        Integer userId = (Integer) session.getAttribute("user_id");
        UserInfo userInfo = userService.showUserInfo(userId);
        //返回登录页
        if (userInfo == null){
            model.addAttribute("status_code",-1);
            model.addAttribute("status_msg","查询失败");
            model.addAttribute("user",null);
            return "login";
        }
        //正常跳转至用户信息
        model.addAttribute("status_code",0);
        model.addAttribute("status_msg","查询成功");
        model.addAttribute("userinfo",userInfo);
        model.addAttribute("upload_msg",upload_msg);
        return "userspace";
    }
}

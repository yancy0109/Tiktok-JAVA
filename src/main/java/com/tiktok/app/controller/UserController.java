package com.tiktok.app.controller;


import com.tiktok.app.response.LoginAndResgiterResponese;
import com.tiktok.app.response.UserInfo;
import com.tiktok.app.serivce.UserService;
import com.tiktok.app.until.JwtUntil;
import com.tiktok.app.until.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 用户登陆注册
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/douyin/user/register/",method = RequestMethod.POST)
    public HashMap userRegister(@RequestParam String username, @RequestParam String password){
        LoginAndResgiterResponese larResponse = userService.registerUser(username, password);
        if (larResponse == null){
            HashMap map = new HashMap<String,Object>();
            map.put("status_code",-1);
            map.put("status_msg","注册失败，用户名重复");
            map.put("user_id",null);
            map.put("token",null);
            return map;
        }
        HashMap map = new HashMap<String,Object>();
        map.put("status_code",0);
        map.put("status_msg","注册成功");
        map.put("user_id",larResponse.getUser_id());
        map.put("token",larResponse.getToken());
        return map;
    }

    @RequestMapping(value = "/douyin/user/login/",method = RequestMethod.POST)
    public HashMap userLogin(@RequestParam String username,@RequestParam String password){
        LoginAndResgiterResponese loginAndResgiterResponese = userService.loginUser(username, password);
        if (loginAndResgiterResponese==null){
            HashMap map = new HashMap<String,Object>();
            map.put("status_code",-1);
            map.put("status_msg","登陆失败,用户名或密码错误");
            map.put("user_id",null);
            map.put("token",null);
            return map;
        }
        HashMap map = new HashMap<String,Object>();
        map.put("status_code",0);
        map.put("status_msg","登录成功");
        map.put("user_id",loginAndResgiterResponese.getUser_id());
        map.put("token",loginAndResgiterResponese.getToken());
        return map;
    }

    @RequestMapping(value = "/douyin/user/",method = RequestMethod.GET)
    HashMap userInfo(@RequestParam("user_id")Integer userId,@RequestParam("token")String token){
        Integer temp = JwtUntil.parseToken(token);
        if (temp != userId){
            HashMap map = new HashMap<String,Object>();
            map.put("status_code",-1);
            map.put("status_msg","token无效");
            map.put("user",null);
        }
        UserInfo userInfo = userService.showUserInfo(userId);
        if (userInfo == null){
            HashMap map = new HashMap<String,Object>();
            map.put("status_code",-1);
            map.put("status_msg","查询失败");
            map.put("user",null);
        }
        HashMap map = new HashMap<String,Object>();
        map.put("status_code",0);
        map.put("status_msg","查询成功");
        map.put("user",userInfo);
        return map;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    String hello(){
        return "hello";
    }
}

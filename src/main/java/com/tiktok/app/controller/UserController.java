package com.tiktok.app.controller;


import com.tiktok.app.serivce.UserService;
import com.tiktok.app.until.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户登陆注册
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/douyin/user/register",method = RequestMethod.POST)
    public ResultResponse UserRegister(@RequestParam String username,@RequestParam String password){
        userService.registerUser(username,password);
        return new ResultResponse<String>(0,"注册成功","哈哈");
    }
}

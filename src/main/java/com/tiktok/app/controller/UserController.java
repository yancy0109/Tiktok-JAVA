package com.tiktok.app.controller;


import com.tiktok.app.response.LoginAndResgiterResponese;
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

    @RequestMapping(value = "/douyin/user/register/",method = RequestMethod.POST)
    public ResultResponse userRegister(@RequestParam String username,@RequestParam String password){
        LoginAndResgiterResponese larResponse = userService.registerUser(username, password);
        if (larResponse == null){
            return new ResultResponse(-1,"注册失败","用户名重复");
        }
        return new ResultResponse(0,"注册成功",larResponse);
    }

    @RequestMapping(value = "/douyin/user/login/",method = RequestMethod.POST)
    public ResultResponse userLogin(@RequestParam String username,@RequestParam String password){
        LoginAndResgiterResponese loginAndResgiterResponese = userService.loginUser(username, password);
        if (loginAndResgiterResponese==null){
            return new ResultResponse(-1,"登陆失败","用户名或密码错误");
        }
        return new ResultResponse(0,"登陆成功",loginAndResgiterResponese);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    String hello(){
        return "hello";
    }
}

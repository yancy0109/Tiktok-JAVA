package com.tiktok.app.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 用户表对应实体
 */
@Data
@AllArgsConstructor
public class User {
    //用户唯一id
    private Integer userid;
    //用户唯一username
    private String username;
    //用户密码
    private String password;
    //加盐密码
    private String salt;
    //创建日期
    private Date createdate;
}

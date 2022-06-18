package com.tiktok.app.bean;

import lombok.Data;

import java.util.Date;


@Data
public class User {
    private Integer id;
    private Integer userid;
    private String username;
    private String password;
    private String salt;
    private Date date;

    public User(Integer userid, String username, String password, String salt, Date date) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.date = date;
    }
}

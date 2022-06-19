package com.tiktok.app.bean;

import lombok.Data;

import java.util.Date;


@Data
public class User {
    private Integer userid;
    private String username;
    private String password;
    private String salt;
    private Date createdate;

    public User(Integer userid, String username, String password, String salt, Date createdate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.createdate = createdate;
    }
}

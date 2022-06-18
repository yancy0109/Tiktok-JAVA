package com.tiktok.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tiktok.app.mapper")
public class TiktokApplication {
    public static void main(String[] args) {
        SpringApplication.run(TiktokApplication.class,args);
    }
}

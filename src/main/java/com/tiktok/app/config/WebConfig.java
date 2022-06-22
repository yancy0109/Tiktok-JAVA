package com.tiktok.app.config;

import com.tiktok.app.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")     //所有请求都被拦截 包括静态资源
                .excludePathPatterns("/","/register","/index","/login","/css/**","/js/**","/cover/**",
                        "/video/**","/douyin/user/login/","/douyin/user/register/","/favicon.ico","/image/**",
                        "/douyin/feed",
                        "/douyin/comment/list/");     //放行的请求;
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}

package com.tiktok.app.interceptor;

import com.tiktok.app.until.JwtUntil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 执行方法前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("当前拦截路径为"+request.getRequestURI());
        String token = (String) request.getSession().getAttribute("token");
        Integer userId = JwtUntil.parseToken(token);
        if (userId == null){
            log.info("token无效");
            request.setAttribute("status_msg","请先登录");
            request.getRequestDispatcher("login").forward(request,response);
            return false;
        }
        log.info("token有效  userId为"+userId);
        request.getSession().setAttribute("token",token);
        request.getSession().setAttribute("user_id",userId);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}

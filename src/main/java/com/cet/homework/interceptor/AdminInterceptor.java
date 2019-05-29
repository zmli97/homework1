package com.cet.homework.interceptor;

import com.cet.homework.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//王嘉奇
//管理拦截器，判断权限是否正确
@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        /**
         * 先经过Login拦截器，如果未登录不会进入
         * login拦截器已经将权限id注入request attribute，因此可直接取出，判断
         */
        int aid = (int) request.getAttribute("aid");
        if (aid != User.ADMIN_AUTHORITY) {
            throw  new ResponseStatusException(HttpStatus.FORBIDDEN, "无权限");
        }
        return true;
    }
}

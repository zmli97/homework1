package com.cet.homework.interceptor;

import com.cet.homework.component.EncryptorComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
//王嘉奇
//登录拦截器，判断header中token是否合法，将反序列化出的用户信息，加载到当前request
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    //注入拦截器组件
    private EncryptorComponent encryptorComponent;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional
        Optional.ofNullable(request.getHeader("token"))
                .ifPresentOrElse(token -> {
                    var map = encryptorComponent.decrypt(token);
                    request.setAttribute("uid", map.get("uid"));
                    request.setAttribute("aid", map.get("aid"));
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录！");
                });
        return true;
    }
}

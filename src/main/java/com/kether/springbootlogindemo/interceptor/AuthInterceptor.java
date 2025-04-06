package com.kether.springbootlogindemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String uri = request.getRequestURI();
        // 放行登入相關和靜態資源
        if (uri.startsWith("/auth") || uri.equals("/login.html") || uri.equals("/")) {
            return true;
        }
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return true;
        }
        // 未登入，導向登入頁
        response.sendRedirect("/login.html");
        return false;
    }
}

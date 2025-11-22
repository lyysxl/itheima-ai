package com.itheima.tliaswebmanagement.filter;

import com.itheima.tliaswebmanagement.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
//@Component
public class TokenFilter implements Filter {
//    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        if (requestURI.contains("login")) {
            log.info("登录请求：{}", requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");

        if (token == null || token.isEmpty()) {
            log.info("令牌为空， 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        try {
            jwtUtils.parseJwt(token);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}

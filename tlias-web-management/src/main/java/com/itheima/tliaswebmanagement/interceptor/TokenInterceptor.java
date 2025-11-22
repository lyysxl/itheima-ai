package com.itheima.tliaswebmanagement.interceptor;

import com.itheima.tliaswebmanagement.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Token拦截器类
 * 用于拦截HTTP请求，验证JWT令牌的有效性
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {
    private final JwtUtils jwtUtils;

    /**
     * 在请求处理之前进行拦截处理
     * 验证请求中的JWT令牌是否有效
     *
     * @param request HTTP请求对象
     * @param response HTTP响应对象
     * @param handler 处理器对象
     * @return boolean 返回true表示放行请求，返回false表示拦截请求
     * @throws Exception 处理过程中可能抛出的异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("请求：{}", requestURI);

        // 如果是登录请求，直接放行
        if (requestURI.contains("login")) {
            log.info("登录请求：{}", requestURI);
            return true;
        }

        String token = request.getHeader("token");

        // 检查令牌是否存在
        if (token == null || token.isEmpty()) {
            log.info("令牌为空， 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 验证令牌有效性
        try {
            jwtUtils.parseJwt(token);
        } catch (Exception e) {
            log.info("令牌非法， 响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;
    }
}

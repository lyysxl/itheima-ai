package com.itheima.tliaswebmanagement.interceptor;

import com.itheima.tliaswebmanagement.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 演示拦截器类
 * 实现Spring MVC的HandlerInterceptor接口，用于拦截HTTP请求处理过程
 */
@Slf4j
@Component
public class DemoInterceptor implements HandlerInterceptor {

    /**
     * 预处理回调方法，在目标方法执行前调用
     *
     * @param request  HTTP请求对象，包含客户端请求信息
     * @param response HTTP响应对象，用于向客户端发送响应
     * @param handler  处理器对象，即将执行的处理器方法
     * @return boolean 返回true表示继续执行后续拦截器和目标方法，返回false表示中断执行链
     * @throws Exception 处理过程中可能抛出的异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle ...");
        return true;
    }

    /**
     * 后处理回调方法，在目标方法执行后、视图渲染前调用
     *
     * @param request      HTTP请求对象
     * @param response     HTTP响应对象
     * @param handler      处理器对象
     * @param modelAndView 模型和视图对象，可在此方法中修改模型数据或视图信息
     * @throws Exception 处理过程中可能抛出的异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle ...");
    }

    /**
     * 完成回调方法，在整个请求处理完成后调用（视图渲染结束后）
     *
     * @param request  HTTP请求对象
     * @param response HTTP响应对象
     * @param handler  处理器对象
     * @param ex       异常对象，如果请求处理过程中发生异常则不为null
     * @throws Exception 处理过程中可能抛出的异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion ...");
    }
}


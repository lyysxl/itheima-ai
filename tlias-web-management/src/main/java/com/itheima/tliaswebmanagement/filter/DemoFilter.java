package com.itheima.tliaswebmanagement.filter;

import com.itheima.tliaswebmanagement.exception.BusinessException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 演示过滤器类
 * 用于拦截所有请求并进行处理
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    /**
     * 初始化过滤器
     * @param filterConfig 过滤器配置对象，包含过滤器的初始化参数和ServletContext引用
     * @throws ServletException 当初始化过程中发生错误时抛出
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器：{}", this.getClass().getName());
    }

    /**
     * 执行过滤逻辑
     * @param servletRequest 请求对象，包含客户端的请求信息
     * @param servletResponse 响应对象，用于向客户端发送响应
     * @param filterChain 过滤器链，用于调用下一个过滤器或目标资源
     * @throws IOException 当发生I/O异常时抛出
     * @throws ServletException 当发生Servlet相关异常时抛出
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("执行过滤逻辑：{}", this.getClass().getName());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 销毁过滤器
     * 用于释放过滤器占用的资源
     */
    @Override
    public void destroy() {
        log.info("销毁过滤器：{}", this.getClass().getName());
    }
}


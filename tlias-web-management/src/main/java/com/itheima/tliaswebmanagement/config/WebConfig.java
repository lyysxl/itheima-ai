package com.itheima.tliaswebmanagement.config;

import com.itheima.tliaswebmanagement.interceptor.DemoInterceptor;
import com.itheima.tliaswebmanagement.interceptor.TokenInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Web配置类，用于配置Spring MVC的相关组件
 */
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final DemoInterceptor demoInterceptor;
    private final TokenInterceptor tokenInterceptor;
    /**
     * 添加拦截器到Spring MVC配置中
     *
     * @param registry 拦截器注册器，用于注册和配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册DemoInterceptor拦截器，并应用到所有路径
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**");
        // 注册TokenInterceptor拦截器，并应用到所有路径
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}



package com.example.crossdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 全局CORS配置
     *
     * @param registry CORS注册器
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 映射服务器中那些http接口进行跨域访问
        registry.addMapping("/cors/*")
                // 配置哪些来源有权限跨域
                .allowedOrigins("http://localhost:8081")
                // 配置运行跨域访问的请求方法
                .allowedMethods("GET", "POST", "DELETE", "PUT");
    }

}

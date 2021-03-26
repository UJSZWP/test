//package com.example.chopeeservice.util;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//class InterceptorConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new TokenInterceptor())
////                .addPathPatterns("/service/**")
//                .excludePathPatterns("/api/common/login"); // 不拦截的请求  如登录接口
//    }
//
//
//}
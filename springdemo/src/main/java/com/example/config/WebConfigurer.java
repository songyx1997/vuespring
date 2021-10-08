package com.example.config;

import com.example.interceptor.UserInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Title: WebConfigurer</p>
 * <p>Description: 页面配置</p>
 * @author songy
 * @date 2021/10/8
 */
@SpringBootConfiguration
public class WebConfigurer implements WebMvcConfigurer {

    @Bean
    public UserInterceptor getUserInterceptor() {
        return new UserInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置登录与注册拦截器
        registry.addInterceptor(getUserInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");
    }
}

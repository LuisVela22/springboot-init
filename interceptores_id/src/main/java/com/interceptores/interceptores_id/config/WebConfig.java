package com.interceptores.interceptores_id.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.interceptores.interceptores_id.interceptores.TimeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer { 

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeInterceptor());
    }
}

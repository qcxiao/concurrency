package com.yaodao.concurrency;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 适配器
 * 注入自定义拦截器
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry){
        /**
         * 配置拦截器
         */
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}

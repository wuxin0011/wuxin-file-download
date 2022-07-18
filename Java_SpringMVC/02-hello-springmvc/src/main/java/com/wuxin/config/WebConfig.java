package com.wuxin.config;

import com.wuxin.interceptor.LoginInterceptor;
import com.wuxin.interceptor.UploadInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: wuxin001
 * @date: 2022/7/16 17:32
 * @Description:
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {


    /**
     * 注册拦截器
     *
     * @param registry 拦截器注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**");
        registry.addInterceptor(new UploadInterceptor()).addPathPatterns("/upload/**");
    }


    /**
     * 注册文件解析器
     *
     * @return 文件解析器
     */
    @Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
}

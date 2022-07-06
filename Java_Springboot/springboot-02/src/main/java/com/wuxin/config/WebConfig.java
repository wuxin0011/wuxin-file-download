package com.wuxin.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: wuxin001
 * @date: 2022/7/4 20:27
 * @Description: 注册错误页码
 */
@Configuration
public class WebConfig implements WebMvcConfigurer, ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        registry.addErrorPages(errorPage);
    }
}

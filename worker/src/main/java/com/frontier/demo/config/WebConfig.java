package com.frontier.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * WEB配置类
 *
 * @author bing-qian
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 跨域处理
     *
     * @param registry 注册对象
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*", "null")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE", "HEAD").maxAge(3600).allowCredentials(true)
                .allowedHeaders("Origin", "Content-Type", "Accept", "authorization", "sessionId", "fileName")
                .exposedHeaders("sessionId", "fileName");
    }
}

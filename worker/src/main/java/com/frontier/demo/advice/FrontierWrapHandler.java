package com.frontier.demo.advice;

import com.frontier.demo.common.ResponseVo;
import com.frontier.demo.util.BaseResponseUtil;
import com.frontier.demo.util.OperationEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 自定义全局包装处理器
 *
 * @author bing-qian
 */
@RestControllerAdvice
@Slf4j
public class FrontierWrapHandler<T> implements ResponseBodyAdvice<T> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> convertType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(convertType);
    }

    @Override
    public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType,
                             Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request, ServerHttpResponse response) {
        //系统发生异常执行 校验异常/自定义异常/系统异常
        if (body.getClass().equals(ResponseVo.class)){
            return body;
        }
        //写操作执行成功
        if (body.getClass().equals(Boolean.class)){
            return (T) BaseResponseUtil.success();
        }
        //写操作执行成功
        if (body.getClass().equals(OperationEnum.class)){
            return (T) BaseResponseUtil.success((OperationEnum)body);
        }
        //读操作执行成功
        return (T) BaseResponseUtil.success(body);
    }
}

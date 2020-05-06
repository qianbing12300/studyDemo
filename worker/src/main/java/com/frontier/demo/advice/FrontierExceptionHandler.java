package com.frontier.demo.advice;

import com.frontier.demo.common.ResponseVo;
import com.frontier.demo.exception.ServiceException;
import com.frontier.demo.util.BaseResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.xml.ws.Response;
import java.net.BindException;
import java.util.stream.Collectors;

/**
 * 自定义全局异常处理器
 *
 * @author bing-qian
 */
@RestControllerAdvice
public class FrontierExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(FrontierExceptionHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseVo<String> handleArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        logger.error("参数校验异常,异常信息:{}", methodArgumentNotValidException.getMessage());
        return BaseResponseUtil.fail(methodArgumentNotValidException.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.joining(",")));
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseVo<String> handleBindException(BindException bindException){
        logger.error("表参参数校验异常,异常信息:{}", bindException.getMessage());
        return BaseResponseUtil.fail(bindException.getMessage());
    }

    @ExceptionHandler(value = ServiceException.class)
    public ResponseVo<String> handleServiceException(ServiceException serviceException){
        logger.error("发生业务异常,异常信息:{}", serviceException.getMessage());
        return BaseResponseUtil.fail(serviceException.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseVo<String> handleArgumentNotValidException(Exception exception){
        logger.error("发生系统异常,异常信息:{}", exception.getMessage());
        return BaseResponseUtil.fail(exception.getMessage());
    }
}

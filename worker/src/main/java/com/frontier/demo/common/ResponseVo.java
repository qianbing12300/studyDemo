package com.frontier.demo.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 公共返回结果
 * @author bing-qian
 *
 * @param <T>
 */
@Data
@Accessors(chain = true)
public class ResponseVo<T> {

    /**
     * 返回值code
     */
    private Integer code;

    /**
     * 返回值msg
     */
    private String msg;

    /**
     * 返回对象
     */
    private T data;
}

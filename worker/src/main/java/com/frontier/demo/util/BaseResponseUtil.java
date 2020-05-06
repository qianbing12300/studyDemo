package com.frontier.demo.util;


import com.frontier.demo.common.ResponseVo;

/**
 * 响应包装工具类
 *
 * @author: bing-qian
 */
public final class BaseResponseUtil {

    /**
     * 构造函数私有化
     */
    private BaseResponseUtil(){
    }

    /**
     * 成功编码
     */
    private static final Integer SUCCESS_CODE = 200;

    /**
     * 失败编码
     */
    private static final Integer ERROR_CODE = 500;

    /**
     * 默认操作成功提示
     */
    private static final String DEFAULT_SUCCESS_CODE = "操作成功";

    /**
     * 包裹响应对象,此方法适用于写操作没有数据实体场景下使用
     *
     * @return 响应实体
     */
    public static ResponseVo success(){
        return new ResponseVo().setCode(SUCCESS_CODE).setMsg(DEFAULT_SUCCESS_CODE);
    }

    /**
     *包裹响应对象,此方法适用于返回数据类型的枚举
     *
     * @param operationEnum
     * @return 响应实体
     */
    public static ResponseVo success(OperationEnum operationEnum){
        return success().setMsg(operationEnum.getMessage());
    }

    /**
     *包裹响应对象,此方法适用于写操作有数据实体场景下使用
     *
     * @param data
     * @return 响应实体
     */
    public static ResponseVo success(Object data){
        return success().setData(data);
    }

    /**
     *包裹响应对象,此方法适用于发生异常(校验框架异常、业务逻辑异常、系统异常)场景下使用
     *
     * @param msg 异常消息
     * @return 响应实体
     */
    public static ResponseVo fail(String msg){
        return fail().setMsg(msg);
    }

    /**
     * 设置失败标志位
     *
     * @return 响应实体
     */
    public static ResponseVo fail(){
        return new ResponseVo().setCode(ERROR_CODE);
    }


}

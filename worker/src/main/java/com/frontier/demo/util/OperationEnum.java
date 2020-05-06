package com.frontier.demo.util;

public enum OperationEnum {
    ADD_SUCCESS("新增成功"),
    UPDATE_SUCCESS("修改成功"),
    DELETE_SUCCESS("删除成功"),
    QUERY_SUCCESS("查询成功");

    private String message;

    OperationEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

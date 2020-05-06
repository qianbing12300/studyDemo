package com.frontier.demo.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkerDTO {

    /**
     * 用户编号
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 生日
     */
    private LocalDateTime birthday;
}

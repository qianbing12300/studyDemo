package com.frontier.demo.controller.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 查询工人请求实体
 *
 * @author bing-qian
 */
@Data
public class QueryWorkerRequest {

    @NotBlank(message = "工人名称不能为空")
    private String name;
}

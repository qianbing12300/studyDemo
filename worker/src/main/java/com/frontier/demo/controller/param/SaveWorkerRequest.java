package com.frontier.demo.controller.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 新增员工保存实体
 *
 * @author bing-qian
 */
@Data
public class SaveWorkerRequest implements Serializable {

    @NotBlank(message = "员工名称不能为空")
    private String name;

    @NotNull(message = "员工年龄不能为空")
    private Integer age;

    @NotNull(message = "员工生日不能为空")
    private String birthday;

}

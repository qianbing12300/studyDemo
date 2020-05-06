package com.frontier.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Worker {

    private Long id;

    @NotBlank(message = "工人姓名不能为空")
    private String name;

    @NotNull(message = "年齡不能为空")
    private Integer age;

    @NotNull(message = "生日不能为空")
    private LocalDateTime birthday;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}

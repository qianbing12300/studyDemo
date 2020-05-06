package com.frontier.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.frontier.demo.mapper")
@SpringBootApplication
public class SpringBootApplicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationDemo.class, args);
    }
}

package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title: SpringDemoApplication</p>
 * <p>Description: 应用入口</p>
 * @author songy
 * @date 2021/9/24
 */
@SpringBootApplication
@MapperScan("com.example.dao")
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }
}

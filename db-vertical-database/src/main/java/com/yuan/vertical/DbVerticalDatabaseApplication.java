package com.yuan.vertical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yuan.vertical.dao")
@SpringBootApplication
public class DbVerticalDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbVerticalDatabaseApplication.class, args);
    }

}

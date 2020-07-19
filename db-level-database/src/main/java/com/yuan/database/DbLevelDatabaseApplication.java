package com.yuan.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yuan.database.dao")
@SpringBootApplication
public class DbLevelDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbLevelDatabaseApplication.class, args);
    }

}

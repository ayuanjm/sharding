package com.yuan.sharding.dbreadwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.yuan.sharding.dbreadwrite")
@SpringBootApplication
public class DbReadWriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbReadWriteApplication.class, args);
    }

}

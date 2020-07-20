package com.yuan.sharding.dbreadwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan("com.yuan.sharding.dbreadwrite.dao")
@SpringBootApplication
public class DbReadWriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbReadWriteApplication.class, args);
    }

}

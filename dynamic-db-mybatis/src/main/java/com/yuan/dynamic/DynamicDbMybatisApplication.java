package com.yuan.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DynamicDbMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDbMybatisApplication.class, args);
    }

}

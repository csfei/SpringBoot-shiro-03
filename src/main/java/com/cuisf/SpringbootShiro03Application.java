package com.cuisf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cuisf.mapper")
public class SpringbootShiro03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiro03Application.class, args);
    }

}

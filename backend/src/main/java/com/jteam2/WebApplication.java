package com.jteam2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.jteam2.mapper")
public class WebApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class);

    }
}



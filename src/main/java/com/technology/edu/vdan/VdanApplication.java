package com.technology.edu.vdan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.technology.edu.vdan.mapper")
@EnableScheduling
public class VdanApplication {

    public static void main(String[] args) {
        SpringApplication.run(VdanApplication.class, args);
    }
}

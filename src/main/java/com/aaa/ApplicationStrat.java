package com.aaa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.aaa.dao")
public class ApplicationStrat {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStrat.class);
    }

}

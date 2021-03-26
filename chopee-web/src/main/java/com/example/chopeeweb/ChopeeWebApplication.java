package com.example.chopeeweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.chopeedao")
@SpringBootApplication(scanBasePackages = {"com.example"})
public class ChopeeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChopeeWebApplication.class, args);
        System.out.println("系统启动成功");
    }

}

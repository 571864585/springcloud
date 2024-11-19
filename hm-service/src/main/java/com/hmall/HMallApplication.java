package com.hmall;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hmall.mapper")
@SpringBootApplication
@Slf4j
public class HMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(HMallApplication.class, args);
        log.info("项目启动成功！");
    }
}
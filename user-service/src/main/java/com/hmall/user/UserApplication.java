package com.hmall.user;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 徐
 * @CreateTime: 2024/11/15 8:58
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.hmall.api.client")
@MapperScan("com.hmall.user.mapper")
@Slf4j
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
        log.info("用户模块启动成功");
    }
}

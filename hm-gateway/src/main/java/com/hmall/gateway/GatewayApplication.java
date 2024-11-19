package com.hmall.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 徐
 * @CreateTime: 2024/11/15 14:08
 */
@SpringBootApplication
@Slf4j
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
        log.info("网关启动成功");
    }
}

package com.hmall.pay;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 徐
 * @CreateTime: 2024/11/15 12:00
 */
@SpringBootApplication
@MapperScan("com.hmall.pay.mapper")
@EnableFeignClients(basePackages = "com.hmall.api.client")
@Slf4j
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class);
        log.info("支付模块启动");
    }
}

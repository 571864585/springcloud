package com.hmall.trade;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 徐
 * @CreateTime: 2024/11/15 10:41
 */
@SpringBootApplication
@MapperScan("com.hmall.trade.mapper")
@EnableFeignClients(basePackages = "com.hmall.api.client")
@Slf4j
public class TradeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeApplication.class);
        log.info("交易模块启动");
    }
}

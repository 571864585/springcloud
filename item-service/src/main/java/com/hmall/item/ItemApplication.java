package com.hmall.item;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 徐
 * @CreateTime: 2024/11/14 9:02
 */
@SpringBootApplication
@MapperScan("com.hmall.item.mapper")
@Slf4j
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class);
        log.info("商品模块启动成功");
    }
}

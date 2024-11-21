package com.hmall.cart;

import com.hmall.api.filter.DefaultFeignConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 徐
 * @CreateTime: 2024/11/14 9:47
 */
@EnableFeignClients(basePackages = "com.hmall.api.client",defaultConfiguration = DefaultFeignConfig.class)
@SpringBootApplication
@MapperScan("com.hmall.cart.mapper")
@Slf4j
public class CartApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class);
        log.info("购物模块启动成功");
    }

    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }
}

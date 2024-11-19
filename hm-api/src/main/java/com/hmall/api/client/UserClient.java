package com.hmall.api.client;

import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 徐
 * @CreateTime: 2024/11/15 12:10
 */
@FeignClient("user-service")
public interface UserClient {
    @PutMapping("/users/money/deduct")
    void deductMoney(@RequestParam("pw") String pw, @RequestParam("amount") Integer amount);
}

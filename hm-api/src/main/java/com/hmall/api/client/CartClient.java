package com.hmall.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

/**
 * @Author: 徐
 * @CreateTime: 2024/11/15 11:15
 */
@FeignClient("cart-service")
public interface CartClient {
    @DeleteMapping("/cart")
    void deleteCartItemByIds(@RequestParam("ids") Collection<Long> ids);
}

package com.hmall.api.filter;


import com.hmall.common.utils.UserContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Long userInfo = UserContext.getUser();
                if (userInfo != null){
                    requestTemplate.header("user-info",userInfo.toString());
                }
            }
        };
    }
}

package com.hmall.gateway.route;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

@Slf4j
@Component
@RequiredArgsConstructor
public class DynamicRouteLoader {

    private final NacosConfigManager nacosConfigManager;
    private final RouteDefinitionWriter writer;

    private final String dataId = "gateway-routes.json";
    private final String grop = "DEFAULT_GROUP";

    private final Set<String> routeIds = new HashSet<>();

    @PostConstruct
    public void initRouteConfigListener() throws NacosException {
        //1.注册监听器并首次拉取配置
        String configInfo = nacosConfigManager.getConfigService()
                .getConfigAndSignListener(dataId, grop, 5000, new Listener() {
                    @Override
                    public Executor getExecutor() {
                        return null;
                    }

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        updateConfigInfo(configInfo);
                    }
                });
        //2.首次启动时，更新一次配置
        updateConfigInfo(configInfo);
    }

    public void updateConfigInfo(String configInfo){
        log.debug("监听到路由变更:{}", configInfo);
        //1.反序列化
        List<RouteDefinition> routeDefinitions = JSONUtil.toList(configInfo, RouteDefinition.class);
        //2更新前清空旧路由表
        for (String routeId : routeIds) {
            writer.delete(Mono.just(routeId)).subscribe();
        }
        routeIds.clear();
        //2.2判断是否有新的路由
        if (CollUtil.isEmpty(routeDefinitions)) {
            //无新路由配置
            return;
        }
        //3.更新路由
        routeDefinitions.forEach(routeDefinition -> {
            //3.1更新路由
            writer.save(Mono.just(routeDefinition)).subscribe();
            //3.2记录路由id，方便将来进行删除
            routeIds.add(routeDefinition.getId());
        });
    }
}

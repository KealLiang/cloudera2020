package com.kealliang.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lsr
 * @ClassName GatewayConfig
 * @Date 2020-03-28
 * @Vertion 1.0
 */
@Configuration
public class GatewayConfig {

    /**
     * gateway完成路由跳转的两种方式
     * 方法一：使用yml配置的方式
     * 方法二：使用BeanConfig的方式
     * @author lsr
     * @description customRouteLocator
     * @Date 2020/3/28
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("map_local2baidu",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}

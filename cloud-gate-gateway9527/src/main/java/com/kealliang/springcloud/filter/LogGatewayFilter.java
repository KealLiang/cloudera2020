package com.kealliang.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * gateway三要素 路由、断言、过滤器
 * @author lsr
 * @ClassName LogGatewayFilter
 * @Date 2020-03-28
 * @Vertion 1.0
 */
@Component
@Slf4j
public class LogGatewayFilter implements GlobalFilter,Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入了[{}]的过滤器，记录日志(*^_^*)", this.getClass().getName());
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if(name == null) {
            log.error("请求[{}]没有带上name参数！！！(╯▔皿▔)╯", exchange.getRequest().getURI());
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

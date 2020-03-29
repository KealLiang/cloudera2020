package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 消息总线的服务端刷新
 * 广播让客户端能拿到最新配置 curl -X POST "http://localhost:3344/actuator/bus-refresh"
 * 向特定的客户端广播 curl -X POST "http://localhost:3344/actuator/bus-refresh/${clientName}:${clientPort}"
 * @author lsr
 * @ClassName ConfigCenter3344
 * @Date 2020-03-28
 * @Vertion 1.0
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344.class, args);
    }
}

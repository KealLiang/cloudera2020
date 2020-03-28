package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
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

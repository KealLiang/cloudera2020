package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lsr
 * @ClassName ConsumerNacosCombine84
 * @Date 2020-04-18
 * @Vertion 1.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerNacosCombine84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosCombine84.class, args);
    }
}

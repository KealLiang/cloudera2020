package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Nacos的provider
 * Nacos是一个支持 AP\CP 的注册中心
 * @author lsr
 * @ClassName PaymentNacos9001
 * @Date 2020-04-12
 * @Vertion 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentNacos9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacos9001.class, args);
    }
}

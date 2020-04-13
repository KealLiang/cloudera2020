package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lsr
 * @ClassName OrderNacos83
 * @Date 2020-04-12
 * @Vertion 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacos83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacos83.class, args);
    }
}

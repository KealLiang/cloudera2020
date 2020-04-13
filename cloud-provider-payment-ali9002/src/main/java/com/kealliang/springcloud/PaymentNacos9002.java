package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lsr
 * @ClassName PaymentNacos9002
 * @Date 2020-04-12
 * @Vertion 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentNacos9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacos9002.class, args);
    }
}

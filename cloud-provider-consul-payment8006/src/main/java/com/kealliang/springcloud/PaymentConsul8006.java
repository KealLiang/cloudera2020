package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lsr
 * @ClassName PaymentConsul8006
 * @Date 2020-03-29
 * @Vertion 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentConsul8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsul8006.class, args);
    }
}

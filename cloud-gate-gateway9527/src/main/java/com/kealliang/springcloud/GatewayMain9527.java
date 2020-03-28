package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lsr
 * @ClassName GatewayMain9527
 * @Date 2020-03-26
 * @Vertion 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayMain9527 {
    
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}

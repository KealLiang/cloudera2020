package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lsr
 * @ClassName PaymentMain8004
 * @Date 2020-03-17
 * @Vertion 1.0
 */
@EnableDiscoveryClient // 此注解用于向consul或者zookeeper中注册服务
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}

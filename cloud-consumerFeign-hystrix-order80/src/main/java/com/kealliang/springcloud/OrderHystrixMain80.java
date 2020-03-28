package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lsr
 * @ClassName OrderHystrixMain80
 * @Date 2020-03-22
 * @Vertion 1.0
 */
// 客户端启用hystrix
@EnableHystrix
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}

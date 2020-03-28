package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lsr
 * @ClassName OrderFeignMain80
 * @Date 2020-03-19
 * @Vertion 1.0
 */
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}

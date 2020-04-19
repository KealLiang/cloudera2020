package com.kealliang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lsr
 * @ClassName SeataStorage10003
 * @Date 2020-04-19
 * @Vertion 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 不用这个，用自己配置的seata的
public class SeataStorage10003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorage10003.class, args);
    }
}

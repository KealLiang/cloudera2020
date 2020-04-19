package com.kealliang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lsr
 * @ClassName SeataOrder10001
 * @Date 2020-04-19
 * @Vertion 1.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 不用这个，用自己配置的seata的
public class SeataOrder10001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder10001.class, args);
    }
}

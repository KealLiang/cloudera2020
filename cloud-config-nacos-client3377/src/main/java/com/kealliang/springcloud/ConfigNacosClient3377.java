package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lsr
 * @ClassName ConfigNacosClient3377
 * @Date 2020-04-12
 * @Vertion 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigNacosClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosClient3377.class, args);
    }
}

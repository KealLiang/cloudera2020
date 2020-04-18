package com.kealliang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lsr
 * @ClassName ProviderAliCombine9003
 * @Date 2020-04-18
 * @Vertion 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderAliCombine9003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAliCombine9003.class, args);
    }
}

package com.kealliang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lsr
 * @ClassName ApplicationContextConfig
 * @Date 2020-03-15
 * @Vertion 1.0
 */
@Configuration
public class ApplicationContextConfig {

    // 配置负载均衡，才能避免UnknownHostException: CLOUD-PAYMENT-SERVICE
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
}

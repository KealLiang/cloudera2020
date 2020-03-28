package com.kealliang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lsr
 * @ClassName ApplicaitonContextConfig
 * @Date 2020-03-18
 * @Vertion 1.0
 */
@Configuration
public class ApplicaitonContextConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

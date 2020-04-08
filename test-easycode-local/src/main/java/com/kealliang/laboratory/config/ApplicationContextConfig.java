package com.kealliang.laboratory.config;

import com.kealliang.laboratory.aop.ResultAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lsr
 * @ClassName ApplicationContextConfig
 * @Date 2020-04-08
 * @Vertion 1.0
 */
@EnableAspectJAutoProxy
@Configuration
public class ApplicationContextConfig {

    @Bean
    public ResultAspects resultAspects() {
        System.out.println("加载aop切面");
        return new ResultAspects();
    }
}

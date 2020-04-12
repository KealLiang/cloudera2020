package com.kealliang.laboratory.config.web;

import com.kealliang.laboratory.aop.ResultAspects;
import com.kealliang.laboratory.interceptor.ReturnHandlerBeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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

    @ConditionalOnProperty(prefix = "keal.web.response.processor", name = "return-value", havingValue = "true")
    @Bean
    public ReturnHandlerBeanPostProcessor returnHandlerBeanPostProcessor() {
        System.out.println("加载了自定义的返回值处理器！");
        return new ReturnHandlerBeanPostProcessor();
    }
}

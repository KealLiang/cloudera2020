package com.kealliang.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意：ribbon官网上说了，自定义的LB配置不能放在 @ComponentScan 能扫描到的地方，否则此配置将被所有ribbon客户端共享，达不到特殊化配置的目的
 * 注解 @ComponentScan 在 @SpringBootApplication 中
 * ComponentScan能扫描的范围为当前类所在包及其子包，因此com.kealliang.rule不会被扫描
 * @author lsr
 * @ClassName MyLBRule
 * @Date 2020-03-18
 * @Vertion 1.0
 */
@Configuration
public class MyLBRule {

    @Bean
    public IRule lbRule(){
        return new RandomRule();
    }
}

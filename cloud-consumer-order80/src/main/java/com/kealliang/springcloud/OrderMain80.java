package com.kealliang.springcloud;

import com.kealliang.rule.MyLBRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lsr
 * @ClassName OrderMain80
 * @Date 2020-03-15
 * @Vertion 1.0
 */
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyLBRule.class) // 配置自定义的负载均衡算法
@EnableEurekaClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 避免 Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}

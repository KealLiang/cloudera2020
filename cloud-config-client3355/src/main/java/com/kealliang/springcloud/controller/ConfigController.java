package com.kealliang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsr
 * @ClassName ConfigController
 * @Date 2020-03-29
 * @Vertion 1.0
 */
// 手动版动态刷新
// 暴露监控端点，加了如下注解，再执行 curl -X POST "http://localhost:3355/actuator/refresh" 刷新配置后才能读取最新
@RefreshScope
@RestController
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping("configInfo")
    public String configInfo() {
        return String.format("客户端读到的info信息[%s]", info);
    }
}

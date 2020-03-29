package com.kealliang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
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
// 即使是自动版的消息总线式的，client端要刷新的端点bean也必须打上此注解，否则本应用不能拿到最新配置
@RefreshScope
@RestController
@Slf4j
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("configInfo")
    public String configInfo() {
        return String.format("客户端[%s]读到的info信息[%s]", serverPort, info);
    }
}

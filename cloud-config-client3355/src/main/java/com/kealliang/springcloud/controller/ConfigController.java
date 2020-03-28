package com.kealliang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsr
 * @ClassName ConfigController
 * @Date 2020-03-29
 * @Vertion 1.0
 */
@RestController
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping("configInfo")
    public String configInfo() {
        return String.format("客户端读到的info信息[%s]", info);
    }
}

package com.kealliang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lsr
 * @ClassName PaymentController
 * @Date 2020-03-17
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/zk")
    public String paymentzk() {
        return "spring-cloud with zookeeper " + serverPort + "\t" + UUID.randomUUID().toString().replace("-", "");
    }
}

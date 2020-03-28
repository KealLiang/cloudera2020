package com.kealliang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lsr
 * @ClassName PaymentController
 * @Date 2020-03-29
 * @Vertion 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/consul")
    public String paymentzk() {
        return "spring-cloud with consul " + serverPort + "\t" + UUID.randomUUID().toString().replace("-", "");
    }
}

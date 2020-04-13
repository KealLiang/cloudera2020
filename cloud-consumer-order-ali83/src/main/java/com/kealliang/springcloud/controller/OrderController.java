package com.kealliang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lsr
 * @ClassName OrderController
 * @Date 2020-04-12
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-payment-service}")
    private String serviceURL;

    @GetMapping("consumer/nacos/order/{id}")
    public String paymentInfo (@PathVariable Integer id) {
        return restTemplate.getForObject(serviceURL + "/payment/nacos/" + id, String.class);
    }
}

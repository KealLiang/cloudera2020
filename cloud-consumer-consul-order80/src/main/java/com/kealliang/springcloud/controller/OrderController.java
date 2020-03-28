package com.kealliang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lsr
 * @ClassName OrderController
 * @Date 2020-03-29
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PROVIDER_URI = "http://consul-provider-payment/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/consul")
    public String consumerOrder() {
        String result = restTemplate.getForObject(PROVIDER_URI + "payment/consul", String.class);
        if (result != null) {
            result = "consul:<br/>" + result;
        }
        return result;
    }
}

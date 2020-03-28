package com.kealliang.springcloud.controller;

import com.kealliang.springcloud.entities.dto.CommonResult;
import com.kealliang.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsr
 * @ClassName OrderController
 * @Date 2020-03-19
 * @Vertion 1.0
 */
@RestController
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("consumer/feign/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("consumer/feign/payment/timeout")
    public String feignPaymentTimeout() {
        // openFeign-ribbon 客户端默认等待1秒
        return paymentFeignService.feignPaymentTimeout();
    }
}

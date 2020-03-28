package com.kealliang.springcloud.controller;

import com.kealliang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsr
 * @ClassName PaymentController
 * @Date 2020-03-22
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("server.port")
    private String serverPort;

    @GetMapping("provider/hystrix/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("provider/hystrix/payment/slow/{id}")
    public String paymentInfo_SLOW(@PathVariable Integer id){
        return paymentService.paymentInfo_SLOW(id);
    }


    @GetMapping("provider/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}

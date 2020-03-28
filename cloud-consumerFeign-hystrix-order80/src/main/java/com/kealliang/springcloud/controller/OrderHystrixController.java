package com.kealliang.springcloud.controller;

import com.kealliang.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsr
 * @ClassName OrderHystrixController
 * @Date 2020-03-22
 * @Vertion 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_fallback_method")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/hystrix/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }


//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @HystrixCommand
    @GetMapping("consumer/hystrix/payment/slow/{id}")
    public String paymentInfo_SLOW(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfo_SLOW(id);
    }

    // 写在这里并不好，和业务代码混乱了，应该用更优雅的方式
    public String paymentTimeoutFallback(Integer id) {
        return "我是客户端，这里定的超时时间是2秒，服务端超时或者异常了惹/(ㄒoㄒ)/~~";
    }

    public String global_fallback_method() {
        return "全局方法处理-服务端超时或者异常了 /(ㄒoㄒ)/~~";
    }
}

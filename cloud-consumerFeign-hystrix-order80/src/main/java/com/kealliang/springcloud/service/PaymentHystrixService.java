package com.kealliang.springcloud.service;

import com.kealliang.springcloud.service.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lsr
 * @ClassName PaymentHystrixService
 * @Date 2020-03-22
 * @Vertion 1.0
 */
// FeignFallback
// 这里必须加上fallback 指明调用失败后的服务类，此为80端的服务保护（降级）
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixServiceImpl.class)
@Component
public interface PaymentHystrixService {

    // feign接口 使用@PathVariable时不能省略参数
    @GetMapping("provider/hystrix/payment/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);


    @GetMapping("provider/hystrix/payment/slow/{id}")
    String paymentInfo_SLOW(@PathVariable("id") Integer id);
}

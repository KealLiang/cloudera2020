package com.kealliang.springcloud.service;

import com.kealliang.springcloud.entities.Payment;
import com.kealliang.springcloud.entities.dto.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lsr
 * @ClassName PaymentFeignService
 * @Date 2020-03-19
 * @Vertion 1.0
 */
@FeignClient("CLOUD-PAYMENT-SERVICE") // 1
@Component
public interface PaymentFeignService {

    // 注意这里的GetMapping不能少，且不能错，否则将异常：FeignException$NotFound: status 404 reading PaymentFeignService#getPaymentById(Long)
    // 1 + 2 才能找到正确的服务
    @GetMapping("payment/get/{id}") // 2
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("feign/payment/timeout")
    String feignPaymentTimeout();
}

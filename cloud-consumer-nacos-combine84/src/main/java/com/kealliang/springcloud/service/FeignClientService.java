package com.kealliang.springcloud.service;

import com.kealliang.springcloud.entities.dto.CommonResult;
import com.kealliang.springcloud.service.impl.FeignClientServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lsr
 * @ClassName FeignClientService
 * @Date 2020-04-18
 * @Vertion 1.0
 */
@FeignClient(value = "cloud-payment-provider-combine", fallback = FeignClientServiceFallbackImpl.class)
public interface FeignClientService {

    @GetMapping("paymentSql/{id}")
    CommonResult paymentSql(@PathVariable("id") Long id);
}

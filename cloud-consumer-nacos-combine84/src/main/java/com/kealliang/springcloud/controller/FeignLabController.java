package com.kealliang.springcloud.controller;

import com.kealliang.springcloud.entities.dto.CommonResult;
import com.kealliang.springcloud.service.FeignClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lsr
 * @ClassName CircuitBreakController
 * @Date 2020-04-18
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class FeignLabController {

    @Value("${service-url.nacos-payment-service}")
    private String serviceUrl;

    @Resource
    private FeignClientService feignClientService;

    @GetMapping("consumer/openfeign/{id}")
    CommonResult paymentSql(@PathVariable Long id) {
        return feignClientService.paymentSql(id);
    }
}

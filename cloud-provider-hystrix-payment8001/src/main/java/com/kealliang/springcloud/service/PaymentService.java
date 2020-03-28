package com.kealliang.springcloud.service;

/**
 * @author lsr
 * @ClassName PaymentService
 * @Date 2020-03-22
 * @Vertion 1.0
 */
public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_SLOW(Integer id);

    // 参数常量从HystrixCommandProperties中找
    String paymentCircuitBreaker(Integer id);
}

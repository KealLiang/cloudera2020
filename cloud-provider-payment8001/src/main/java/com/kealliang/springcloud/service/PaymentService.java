package com.kealliang.springcloud.service;

import com.kealliang.springcloud.entities.Payment;

/**
 * @author lsr
 * @ClassName PaymentService
 * @Date 2020-03-15
 * @Vertion 1.0
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}

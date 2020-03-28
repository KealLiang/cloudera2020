package com.kealliang.springcloud.service.impl;

import com.kealliang.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author lsr
 * @ClassName PaymentHystrixServiceImpl
 * @Date 2020-03-24
 * @Vertion 1.0
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "com.kealliang.springcloud.service.impl.PaymentHystrixServiceImpl.paymentInfo_OK 调用失败 இ௰இ";
    }

    @Override
    public String paymentInfo_SLOW(Integer id) {
        return "com.kealliang.springcloud.service.impl.PaymentHystrixServiceImpl.paymentInfo_SLOW 调用失败 இ௰இ";
    }
}

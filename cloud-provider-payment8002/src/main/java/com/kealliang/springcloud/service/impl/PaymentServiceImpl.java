package com.kealliang.springcloud.service.impl;

import com.kealliang.springcloud.dao.PaymentDao;
import com.kealliang.springcloud.entities.Payment;
import com.kealliang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lsr
 * @ClassName PaymentServiceImpl
 * @Date 2020-03-15
 * @Vertion 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

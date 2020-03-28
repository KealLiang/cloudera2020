package com.kealliang.springcloud.dao;

import com.kealliang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lsr
 * @ClassName PaymentDao
 * @Date 2020-03-15
 * @Vertion 1.0
 */
// @Repository 可能在插入时有问题，推荐使用 @Mapper
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

package com.kealliang.springcloud.controller;

import com.kealliang.springcloud.entities.Payment;
import com.kealliang.springcloud.entities.dto.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author lsr
 * @ClassName PaymentController
 * @Date 2020-04-18
 * @Vertion 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static HashMap<Long, Payment> datas = new HashMap<>();

    static {
        datas.put(1L, new Payment(1L, "abcde1"));
        datas.put(2L, new Payment(2L, "abcdef2"));
        datas.put(3L, new Payment(3L, "abcdefg3"));
        datas.put(4L, new Payment(4L, "abcdefgh4"));
    }

    @GetMapping("paymentSql/{id}")
    public CommonResult paymentSql(@PathVariable Long id) {
        Payment payment = datas.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from MySql, serverPort: " + serverPort, payment);
        return result;
    }

}

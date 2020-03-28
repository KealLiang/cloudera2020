package com.kealliang.springcloud.controller;

import com.kealliang.springcloud.entities.dto.CommonResult;
import com.kealliang.springcloud.entities.Payment;
import com.kealliang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author lsr
 * @ClassName PaymentController
 * @Date 2020-03-15
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 插入payment
     * @author lsr
     * @description create
     * @Date 2020/3/15
     */
    @PostMapping("payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("com.kealliang.springcloud.controller.PaymentController.create 插入数据 result:{}", result);
        if (result > 0) {
            return new CommonResult(200, "插入成功, server: "+serverPort, result);
        }
        return new CommonResult(444, "插入失败");
    }

    /**
     * id查询payment
     * @author lsr
     * @description getPaymentById
     * @Date 2020/3/15
     */
    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult(200, "查询成功, server: "+serverPort, result);
        }
        return new CommonResult(444, id + " 查询失败");
    }


    @GetMapping("provider/loadBalance")
    public String lbControler() {
        return "my load balance -> " + serverPort;
    }
}

package com.kealliang.springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.kealliang.springcloud.entities.Payment;
import com.kealliang.springcloud.entities.dto.CommonResult;
import com.kealliang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("discovery")
    public Object discovery() {
        return discoveryClient;
    }

    @GetMapping("payment/discovery")
    public String serviceDiscovery() {
        List<String> services = discoveryClient.getServices();
        String r1 = JSONUtil.toJsonStr(services);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        StringBuilder sb = new StringBuilder();
        for (ServiceInstance instance : instances) {
            sb.append("\thost=" + instance.getHost());
            sb.append("\tport=" + instance.getPort());
            sb.append("\turi=" + instance.getUri());
        }

        return r1 + "\n\n" + sb.toString();
    }


    @GetMapping("provider/loadBalance")
    public String lbTestNode() {
        return "my load balance -> " + serverPort + "\t" + UUID.randomUUID().toString();
    }

    @GetMapping("feign/payment/timeout")
    public String feignPaymentTimeout() {
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return "feignPaymentTimeout -> " + serverPort;
    }


    @GetMapping("provider/zipkin")
    public String zipkinTestNode() {
        return "Hi, I'm zipkin test node -> " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}

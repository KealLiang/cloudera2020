package com.kealliang.springcloud.controller;

import com.kealliang.springcloud.algorithm.MyLoadBalance;
import com.kealliang.springcloud.entities.Payment;
import com.kealliang.springcloud.entities.dto.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lsr
 * @ClassName OrderController
 * @Date 2020-03-15
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT = "http://localhost:8001/";
    public static final String PAYMENT = "http://CLOUD-PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate template;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLoadBalance myLoadBalance;

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPaymentById (@PathVariable Long id) {
        String url = PAYMENT + "payment/get/{id}";
        return template.getForObject(url, CommonResult.class, id);
    }

    @GetMapping("consumer/payment/create")
    public CommonResult create(@RequestParam String serial) {
        String url = PAYMENT + "payment/create";
        Payment payment = new Payment();
        payment.setSerial(StringUtils.isEmpty(serial) ? "未设置serial" : serial);
        return template.postForObject(url, payment, CommonResult.class);
    }

    @GetMapping("consumer/provider/loadBalance")
    public String lbTest() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myLoadBalance.getInstance(instances);
        RestTemplate rt = new RestTemplate();
        return rt.getForObject(instance.getUri() + "/provider/loadBalance", String.class);
    }

    // sleuth + zipkin 监控调用
    @GetMapping("consumer/zipkin")
    public String zipkinTestNode() {
        String result = template.getForObject(PAYMENT + "provider/zipkin", String.class);
        return result;
    }

}

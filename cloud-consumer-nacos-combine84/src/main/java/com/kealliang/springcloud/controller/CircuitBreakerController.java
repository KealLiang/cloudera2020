package com.kealliang.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kealliang.springcloud.entities.Payment;
import com.kealliang.springcloud.entities.dto.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lsr
 * @ClassName CircuitBreakController
 * @Date 2020-04-18
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class CircuitBreakerController {

    @Value("${service-url.nacos-payment-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate template;

    /**
     * 实验sentinel的熔断、降级、异常处理
     * @author lsr
     * @description fallback
     * @Date 2020/4/18
     */
//    @SentinelResource("fallback") // 啥也不配置
//    @SentinelResource(value = "fallback", fallback = "handler_fallback") // fallback只负责业务异常（服务降级）
//    @SentinelResource(value = "fallback", blockHandler = "handler_blocked") // blockHandler只负责sentinel配置限流规则（服务降级）
    @SentinelResource(value = "fallback", fallback = "handler_fallback", blockHandler = "handler_blocked") // 都配置（服务降级）
    @GetMapping("consumer/fallback/{id}")
    public CommonResult fallback (@PathVariable Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("非法的id参数！！");
        }
        CommonResult result = template.getForObject(serviceUrl + "/paymentSql/" + id, CommonResult.class, id);

        if (result.getData() == null) {
            throw new NullPointerException(String.format("不存在id为%s的数据！！", id));
        }
        return result;
    }

    public CommonResult handler_fallback (@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "兜底的服务器异常处理方法, exception: " + e.getMessage(), payment);
    }

    public CommonResult handler_blocked (@PathVariable Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(445, "handler_blocked处理sentinel控制台配置的{降级}规则, exception: " + e.getMessage(), payment);
    }
}

package com.kealliang.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.kealliang.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lsr
 * @ClassName PaymentServiceImpl
 * @Date 2020-03-22
 * @Vertion 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return String.format("payment ok, 线程：%s, id：%s;  O(∩_∩)O", Thread.currentThread().getName(), id);
    }


    // 服务端启用hystrix
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            // 此线程执行的超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfo_SLOW(Integer id) {
//        int i = 10/0;
        int timeout = 3;
        try { TimeUnit.SECONDS.sleep(timeout); } catch (InterruptedException e) { e.printStackTrace(); }
        return String.format("payment slow, 线程：%s, id：%s, 耗时%s秒钟;  ￣へ￣", Thread.currentThread().getName(), id, timeout);
    }

    // 回调方法形参要和原方法一致，这里是Integer
    public String paymentInfo_timeoutHandler(Integer id) {
        return String.format("调用支付方法超时或异常/(ㄒoㄒ)/~~\t当前线程：%s，ID为 %s", Thread.currentThread().getName(), id);
    }

    
    /** 
     * 服务熔断
     * @author lsr
     * @description paymentCircuitBreaker
     * @Date 2020/3/24
     */
    // 参数常量从HystrixCommandProperties中找
    // 下面四个参数，意为：开启段断路器，在10秒内有至少10次请求，且其中60%请求都失败时便断开电路
    // 半断路状态：断路一定时间后（默认5秒），开始放入试探性的请求，若成功则闭合，否则继续断路
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0) {
            throw new IllegalArgumentException("id不能为负数！！！！！！！！！！！");
        }
        String uuid = IdUtil.simpleUUID();
        return String.format("[%s]调用[%s]成功，流水号：%s", Thread.currentThread().getName(), id, uuid);
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return String.format("[%s]干活[%s]时异常/(ㄒoㄒ)/~~，这是paymentCircuitBreaker的fallback方法！", Thread.currentThread().getName(), id);
    }
}

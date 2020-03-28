package com.kealliang.springcloud.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lsr
 * @ClassName MyLoadBalance
 * @Date 2020-03-19
 * @Vertion 1.0
 */
@Component
@Slf4j
public class MyLoadBalance {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 自定义负载均衡 - 轮询（Round Robin）
     * @author lsr
     * @description getInstance
     * @Date 2020/3/19
     */
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        Assert.notEmpty(instances, "可用的实例集合为空！！");
//        int next = nextValue(instances.size());
        int next = nextValueIncr(instances.size());
        log.info("这是第{}次请求，返回的是{}号instance", atomicInteger.get(), next);
        return instances.get(next);
    }

    /** 
     * 使用CAS实现自旋锁（无锁）
     * @author lsr
     * @description nextValue
     * @Date 2020/3/19
     */
    private int nextValue(int size) {
        for(;;) {
            int current = atomicInteger.get();
            int next = (current + 1) % size;
            if(atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    private int nextValueIncr(int size) {
        for(;;) {
            int current = atomicInteger.get();
            int next = current == Integer.MAX_VALUE ? 0 : current + 1;
            if(atomicInteger.compareAndSet(current, next)) {
                return next % size;
            }
        }
    }
}

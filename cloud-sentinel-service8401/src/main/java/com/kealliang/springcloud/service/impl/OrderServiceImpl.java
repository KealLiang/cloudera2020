package com.kealliang.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.kealliang.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lsr
 * @ClassName OrderServiceImpl
 * @Date 2020-04-16
 * @Vertion 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @SentinelResource("getOrder")
    @Override
    public String getOrder() {
        log.debug("============= order =============");
        return "order";
    }
}

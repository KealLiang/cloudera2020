package com.kealliang.springcloud.service.impl;

import com.kealliang.springcloud.entities.Payment;
import com.kealliang.springcloud.entities.dto.CommonResult;
import com.kealliang.springcloud.service.FeignClientService;
import org.springframework.stereotype.Service;

/**
 * @author lsr
 * @ClassName FeignClientServiceFallbackImpl
 * @Date 2020-04-18
 * @Vertion 1.0
 */
@Service
public class FeignClientServiceFallbackImpl implements FeignClientService {
    @Override
    public CommonResult paymentSql(Long id) {
        return new CommonResult(444, "FeignClientService服务调用失败，降级返回！！", new Payment(id, "errorService"));
    }
}

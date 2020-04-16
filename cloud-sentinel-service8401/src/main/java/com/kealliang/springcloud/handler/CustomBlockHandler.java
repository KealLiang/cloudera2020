package com.kealliang.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kealliang.springcloud.bean.OrderBean;
import com.kealliang.springcloud.entities.dto.CommonResult;

/**
 * @author lsr
 * @ClassName CustomBlockHandler
 * @Date 2020-04-16
 * @Vertion 1.0
 */
public class CustomBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(403, "global 用户自定义的限流处理，解决耦合和代码膨胀问题。----1", new OrderBean("史蒂夫", 5678));
    }
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(403, "global 用户自定义的限流处理，解决耦合和代码膨胀问题。----2", new OrderBean("士大夫", 6789));
    }
}

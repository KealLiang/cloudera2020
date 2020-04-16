package com.kealliang.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kealliang.springcloud.bean.OrderBean;
import com.kealliang.springcloud.entities.dto.CommonResult;
import com.kealliang.springcloud.handler.CustomBlockHandler;
import com.kealliang.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lsr
 * @ClassName FlowLimitController
 * @Date 2020-04-15
 * @Vertion 1.0
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private OrderService orderService;

    @GetMapping("testA")
    public String testA () {
        String order = orderService.getOrder();
        return "sentinel service ==> testA " + order;
    }

    @GetMapping("testB")
    public String testB () {
        log.debug(Thread.currentThread().getName() + " ----------> testB");
        String order = orderService.getOrder();
        return "sentinel service ==> testB " + order;
    }

    @GetMapping("testD")
    public String testD () {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.debug("testD 测试 RT");
        return "sentinel service ==> testD";
    }

    @GetMapping("testE")
    public String testE () {
        log.debug("testE 测试 异常比例");
        int i = 10/0;
        return "sentinel service ==> testE";
    }

    @GetMapping("testF")
    public String testF () {
        log.debug("testF 测试 异常数");
        int i = 10/0;
        return "sentinel service ==> testF";
    }


    /**
     * SentinelResource 的埋点不支持private方法
     * @author lsr
     * @description testHotKey
     * @Date 2020/4/17
     */
    @GetMapping("testHotKey")
    @SentinelResource(value = "hotKey", blockHandler = "deal_testHotKey")
    public String testHotKey (@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {
        return "sentinel service ==> testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "testHotKey 处理失败 /(ㄒoㄒ)/~~";
    }

    /**
     * global 自定义的限流处理类，解决耦合和代码膨胀问题。
     * @author lsr
     * @description customBlockHandler
     * @Date 2020/4/17
     */
    @GetMapping("customBlockHandler")
    @SentinelResource(value = "customBlockHandler",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customBlockHandler () {
        return new CommonResult(200, "走用户自定义的限流处理方法", new OrderBean("善良的", 1234));
    }
}

package com.kealliang.cloud.controller;

import com.kealliang.cloud.entity.OrderTbl;
import com.kealliang.cloud.service.OrderTblService;
import com.kealliang.springcloud.entities.dto.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OrderTbl)表控制层
 *
 * @author lsr
 * @since 2020-04-19 16:14:16
 */
@RestController
@RequestMapping("orderTbl")
public class OrderTblController {
    /**
     * 服务对象
     */
    @Resource
    private OrderTblService orderTblService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderTbl selectOne(Integer id) {
        return this.orderTblService.queryById(id);
    }

    /**
     * 创建订单
     * http://localhost:10001/orderTbl/create/order?userId=zhangsan&commodityCode=101&count=10&money=150
     * @author lsr
     * @description createOrder
     * @Date 2020/4/19
     */
    @GetMapping("create/order")
    public CommonResult createOrder(@Validated OrderTbl order) {
        OrderTbl result = orderTblService.insert(order);
        return new CommonResult(200, String.format("创建订单%s成功！！", result.getId()));
    }

    /**
     * 消费订单
     * 查询订单 -> 更新库存 -> 更新账户 -> 更新订单状态
     * http://localhost:10001/orderTbl/consumer/order/{id}
     * @author lsr
     * @description buyCommodity
     * @Date 2020/4/19
     */
    @GetMapping("consumer/order/{id}")
    public CommonResult consumerOrder(@PathVariable Integer id) {
        OrderTbl orderTbl = orderTblService.consumerOrder(id);
        return new CommonResult(200, String.format("订单%s消费成功！！", orderTbl.getId()));
    }

}
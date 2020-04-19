package com.kealliang.cloud.service;

import com.kealliang.cloud.entity.OrderTbl;
import com.kealliang.springcloud.entities.dto.CommonResult;

import java.util.List;

/**
 * (OrderTbl)表服务接口
 *
 * @author lsr
 * @since 2020-04-19 16:14:16
 */
public interface OrderTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderTbl queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderTbl> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    OrderTbl insert(OrderTbl orderTbl);

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    OrderTbl update(OrderTbl orderTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 消费订单
     * @author lsr
     * @description consumerOrder
     * @Date 2020/4/19
     */
    OrderTbl consumerOrder(Integer id);
}
package com.kealliang.cloud.service.impl;

import com.kealliang.cloud.constant.OrderStatus;
import com.kealliang.cloud.dao.OrderTblDao;
import com.kealliang.cloud.entity.OrderTbl;
import com.kealliang.cloud.service.AccountService;
import com.kealliang.cloud.service.OrderTblService;
import com.kealliang.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderTbl)表服务实现类
 *
 * @author lsr
 * @since 2020-04-19 16:14:16
 */
@Service("orderTblService")
@Slf4j
public class OrderTblServiceImpl implements OrderTblService {
    @Resource
    private OrderTblDao orderTblDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderTbl queryById(Integer id) {
        return this.orderTblDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderTbl> queryAllByLimit(int offset, int limit) {
        return this.orderTblDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    @Transactional
    @Override
    public OrderTbl insert(OrderTbl orderTbl) {
        if (StringUtils.isEmpty(orderTbl.getStatus())) {
            orderTbl.setStatus(OrderStatus.EFFECT.getCode());
        }
        this.orderTblDao.insert(orderTbl);
        return orderTbl;
    }

    /**
     * 修改数据
     *
     * @param orderTbl 实例对象
     * @return 实例对象
     */
    @Override
    public OrderTbl update(OrderTbl orderTbl) {
        this.orderTblDao.update(orderTbl);
        return this.queryById(orderTbl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderTblDao.deleteById(id) > 0;
    }

    @GlobalTransactional(name = "keal_tx_order_consume", rollbackFor = Exception.class)
    @Override
    public OrderTbl consumerOrder(Integer id) {
        // 查询订单 -> 更新库存 -> 更新账户 -> 更新订单状态
        log.info("============ 查询订单 ============");
        OrderTbl order = orderTblDao.queryById(id);
        if (order == null) {
            throw new IllegalArgumentException(String.format("订单%s不存在！！", id));
        }
        if (!OrderStatus.EFFECT.getCode().equals(order.getStatus())) {
            throw new IllegalStateException(String.format("订单%s状态有误！！", id));
        }
        log.info("============ 更新库存 ============");
        storageService.updateStorage(order.getCommodityCode(), -order.getCount());
        log.info("============ 更新账户 ============");
        accountService.updateAccount(order.getUserId(), -order.getMoney());
        log.info("============ 更新更新订单状态 ============");
        order.setStatus(OrderStatus.COMPLETE.getCode());
        orderTblDao.update(order);
        return order;
    }
}
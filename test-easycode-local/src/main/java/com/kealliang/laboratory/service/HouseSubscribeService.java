package com.kealliang.laboratory.service;

import com.kealliang.laboratory.entity.HouseSubscribe;
import java.util.List;

/**
 * 预约看房信息表(HouseSubscribe)表服务接口
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
public interface HouseSubscribeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HouseSubscribe queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HouseSubscribe> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param houseSubscribe 实例对象
     * @return 实例对象
     */
    HouseSubscribe insert(HouseSubscribe houseSubscribe);

    /**
     * 修改数据
     *
     * @param houseSubscribe 实例对象
     * @return 实例对象
     */
    HouseSubscribe update(HouseSubscribe houseSubscribe);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
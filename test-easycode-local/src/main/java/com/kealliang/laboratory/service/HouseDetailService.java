package com.kealliang.laboratory.service;

import com.kealliang.laboratory.entity.HouseDetail;
import java.util.List;

/**
 * (HouseDetail)表服务接口
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
public interface HouseDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HouseDetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HouseDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param houseDetail 实例对象
     * @return 实例对象
     */
    HouseDetail insert(HouseDetail houseDetail);

    /**
     * 修改数据
     *
     * @param houseDetail 实例对象
     * @return 实例对象
     */
    HouseDetail update(HouseDetail houseDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
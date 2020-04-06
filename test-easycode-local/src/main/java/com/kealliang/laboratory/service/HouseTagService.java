package com.kealliang.laboratory.service;

import com.kealliang.laboratory.entity.HouseTag;
import java.util.List;

/**
 * 房屋标签映射关系表(HouseTag)表服务接口
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
public interface HouseTagService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HouseTag queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HouseTag> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param houseTag 实例对象
     * @return 实例对象
     */
    HouseTag insert(HouseTag houseTag);

    /**
     * 修改数据
     *
     * @param houseTag 实例对象
     * @return 实例对象
     */
    HouseTag update(HouseTag houseTag);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
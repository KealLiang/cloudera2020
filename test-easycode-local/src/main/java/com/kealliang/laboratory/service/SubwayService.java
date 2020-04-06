package com.kealliang.laboratory.service;

import com.kealliang.laboratory.entity.Subway;
import java.util.List;

/**
 * (Subway)表服务接口
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
public interface SubwayService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Subway queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Subway> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param subway 实例对象
     * @return 实例对象
     */
    Subway insert(Subway subway);

    /**
     * 修改数据
     *
     * @param subway 实例对象
     * @return 实例对象
     */
    Subway update(Subway subway);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
package com.kealliang.laboratory.dao;

import com.kealliang.laboratory.entity.Subway;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Subway)表数据库访问层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Mapper
public interface SubwayDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Subway queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Subway> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subway 实例对象
     * @return 对象列表
     */
    List<Subway> queryAll(Subway subway);

    /**
     * 新增数据
     *
     * @param subway 实例对象
     * @return 影响行数
     */
    int insert(Subway subway);

    /**
     * 修改数据
     *
     * @param subway 实例对象
     * @return 影响行数
     */
    int update(Subway subway);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
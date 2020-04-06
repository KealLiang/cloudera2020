package com.kealliang.laboratory.dao;

import com.kealliang.laboratory.entity.SubwayStation;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SubwayStation)表数据库访问层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Mapper
public interface SubwayStationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubwayStation queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SubwayStation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param subwayStation 实例对象
     * @return 对象列表
     */
    List<SubwayStation> queryAll(SubwayStation subwayStation);

    /**
     * 新增数据
     *
     * @param subwayStation 实例对象
     * @return 影响行数
     */
    int insert(SubwayStation subwayStation);

    /**
     * 修改数据
     *
     * @param subwayStation 实例对象
     * @return 影响行数
     */
    int update(SubwayStation subwayStation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
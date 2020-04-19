package com.kealliang.cloud.dao;

import com.kealliang.cloud.entity.StorageTbl;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (StorageTbl)表数据库访问层
 *
 * @author lsr
 * @since 2020-04-19 17:39:44
 */
@Mapper
public interface StorageTblDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StorageTbl queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<StorageTbl> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param storageTbl 实例对象
     * @return 对象列表
     */
    List<StorageTbl> queryAll(StorageTbl storageTbl);

    /**
     * 新增数据
     *
     * @param storageTbl 实例对象
     * @return 影响行数
     */
    int insert(StorageTbl storageTbl);

    /**
     * 修改数据
     *
     * @param storageTbl 实例对象
     * @return 影响行数
     */
    int update(StorageTbl storageTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
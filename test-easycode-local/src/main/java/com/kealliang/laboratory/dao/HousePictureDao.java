package com.kealliang.laboratory.dao;

import com.kealliang.laboratory.entity.HousePicture;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 房屋图片信息(HousePicture)表数据库访问层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Mapper
public interface HousePictureDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HousePicture queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HousePicture> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param housePicture 实例对象
     * @return 对象列表
     */
    List<HousePicture> queryAll(HousePicture housePicture);

    /**
     * 新增数据
     *
     * @param housePicture 实例对象
     * @return 影响行数
     */
    int insert(HousePicture housePicture);

    /**
     * 修改数据
     *
     * @param housePicture 实例对象
     * @return 影响行数
     */
    int update(HousePicture housePicture);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
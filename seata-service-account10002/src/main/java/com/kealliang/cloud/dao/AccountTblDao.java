package com.kealliang.cloud.dao;

import com.kealliang.cloud.entity.AccountTbl;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (AccountTbl)表数据库访问层
 *
 * @author lsr
 * @since 2020-04-19 17:38:12
 */
@Mapper
public interface AccountTblDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AccountTbl queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AccountTbl> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param accountTbl 实例对象
     * @return 对象列表
     */
    List<AccountTbl> queryAll(AccountTbl accountTbl);

    /**
     * 新增数据
     *
     * @param accountTbl 实例对象
     * @return 影响行数
     */
    int insert(AccountTbl accountTbl);

    /**
     * 修改数据
     *
     * @param accountTbl 实例对象
     * @return 影响行数
     */
    int update(AccountTbl accountTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
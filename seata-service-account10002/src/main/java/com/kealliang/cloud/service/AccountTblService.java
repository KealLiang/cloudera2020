package com.kealliang.cloud.service;

import com.kealliang.cloud.entity.AccountTbl;
import java.util.List;

/**
 * (AccountTbl)表服务接口
 *
 * @author lsr
 * @since 2020-04-19 17:38:12
 */
public interface AccountTblService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AccountTbl queryById(Integer id);

    AccountTbl queryByCondition(AccountTbl account);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AccountTbl> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param accountTbl 实例对象
     * @return 实例对象
     */
    AccountTbl insert(AccountTbl accountTbl);

    /**
     * 修改数据
     *
     * @param accountTbl 实例对象
     * @return 实例对象
     */
    AccountTbl update(AccountTbl accountTbl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    boolean updateAccount(String userId, Integer money);
}
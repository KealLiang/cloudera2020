package com.kealliang.cloud.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.kealliang.cloud.dao.AccountTblDao;
import com.kealliang.cloud.entity.AccountTbl;
import com.kealliang.cloud.service.AccountTblService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AccountTbl)表服务实现类
 *
 * @author lsr
 * @since 2020-04-19 17:38:12
 */
@Service("accountTblService")
@Slf4j
public class AccountTblServiceImpl implements AccountTblService {
    @Resource
    private AccountTblDao accountTblDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AccountTbl queryById(Integer id) {
        return this.accountTblDao.queryById(id);
    }

    @Override
    public AccountTbl queryByCondition(AccountTbl account) {
        List<AccountTbl> accountTbls = accountTblDao.queryAll(account);
        if (CollectionUtil.isEmpty(accountTbls)) {
            return null;
        }
        return accountTbls.get(0);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AccountTbl> queryAllByLimit(int offset, int limit) {
        return this.accountTblDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param accountTbl 实例对象
     * @return 实例对象
     */
    @Transactional
    @Override
    public AccountTbl insert(AccountTbl accountTbl) {
        AccountTbl account = getAccountTblByUserId(accountTbl.getUserId());
        if (account != null) {
            throw new IllegalArgumentException("该账户已存在！！");
        }
        this.accountTblDao.insert(accountTbl);
        if (accountTbl.getMoney() > 2000) {
            throw new IllegalArgumentException("您的账户余额太多了，创建失败！！");
        }
        return accountTbl;
    }

    private AccountTbl getAccountTblByUserId(String userId) {
        AccountTbl query = AccountTbl.builder().userId(userId).build();
        return queryByCondition(query);
    }

    /**
     * 修改数据
     *
     * @param accountTbl 实例对象
     * @return 实例对象
     */
    @Override
    public AccountTbl update(AccountTbl accountTbl) {
        this.accountTblDao.update(accountTbl);
        return this.queryById(accountTbl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.accountTblDao.deleteById(id) > 0;
    }

    @Transactional
    @Override
    public boolean updateAccount(String userId, Integer money) {
        log.info("============ 开始更新账户 user[{}] money[{}] ============", userId, money);
        AccountTbl account = getAccountTblByUserId(userId);
        if (account == null) {
            throw new IllegalArgumentException("该账户不存在！！");
        }
        account.setMoney(account.getMoney() + money);
        if (account.getMoney() < 0) {
            throw new IllegalArgumentException("账户余额不足了！！ /(ㄒoㄒ)/~~");
        }
        int update = accountTblDao.update(account);
        return update == 1;
    }
}
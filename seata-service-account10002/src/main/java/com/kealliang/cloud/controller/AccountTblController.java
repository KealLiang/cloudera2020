package com.kealliang.cloud.controller;

import com.kealliang.cloud.entity.AccountTbl;
import com.kealliang.cloud.service.AccountTblService;
import com.kealliang.springcloud.entities.dto.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AccountTbl)表控制层
 *
 * @author lsr
 * @since 2020-04-19 17:38:12
 */
@RestController
@RequestMapping("accountTbl")
public class AccountTblController {
    /**
     * 服务对象
     */
    @Resource
    private AccountTblService accountTblService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AccountTbl selectOne(Integer id) {
        return this.accountTblService.queryById(id);
    }

    /**
     * 创建账户
     * http://localhost:10001/accountTbl/create/account?userId=zhangsan&money=2000
     * @author lsr
     * @description createAccount
     * @Date 2020/4/19
     */
    @GetMapping("create/account")
    public CommonResult createAccount(@Validated AccountTbl account) {
        AccountTbl result = accountTblService.insert(account);
        return new CommonResult(200, String.format("创建账户%s成功！！", result.getId()));
    }

    /**
     * 更新账户余额
     * @author lsr
     * @description updateAccount
     * @Date 2020/4/19
     */
    @PutMapping("account/{userId}/{money}")
    public boolean updateAccount(@PathVariable("userId") String userId, @PathVariable("money") Integer money) {
        return accountTblService.updateAccount(userId, money);
    }
}
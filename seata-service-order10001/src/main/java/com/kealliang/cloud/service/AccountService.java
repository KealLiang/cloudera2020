package com.kealliang.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author lsr
 * @ClassName AccountService
 * @Date 2020-04-19
 * @Vertion 1.0
 */
@FeignClient("seata-service-account")
public interface AccountService {

    @PutMapping("/accountTbl/account/{userId}/{money}")
    boolean updateAccount(@PathVariable("userId") String userId, @PathVariable("money") Integer money);
}

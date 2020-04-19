package com.kealliang.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author lsr
 * @ClassName StorageService
 * @Date 2020-04-19
 * @Vertion 1.0
 */
@FeignClient("seata-service-storage")
public interface StorageService {

    @PutMapping("/storageTbl/storage/{commodityCode}/{count}")
    boolean updateStorage(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") Integer count);
}

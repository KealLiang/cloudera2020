package com.kealliang.cloud.controller;

import com.kealliang.cloud.entity.StorageTbl;
import com.kealliang.cloud.service.StorageTblService;
import com.kealliang.springcloud.entities.dto.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (StorageTbl)表控制层
 *
 * @author lsr
 * @since 2020-04-19 17:39:44
 */
@RestController
@RequestMapping("storageTbl")
public class StorageTblController {
    /**
     * 服务对象
     */
    @Resource
    private StorageTblService storageTblService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public StorageTbl selectOne(Integer id) {
        return this.storageTblService.queryById(id);
    }

    /**
     * 创建库存
     * http://localhost:10003/storageTbl/create/storage?commodityCode=101&count=200
     * @author lsr
     * @description createStorage
     * @Date 2020/4/19
     */
    @GetMapping("create/storage")
    public CommonResult createStorage(@Validated StorageTbl storage) {
        StorageTbl result = storageTblService.insert(storage);
        return new CommonResult(200, String.format("创建库存%s成功！！", result.getId()));
    }

    /**
     * 更新库存
     * @author lsr
     * @description updateStorage
     * @Date 2020/4/19
     */
    @PutMapping("storage/{commodityCode}/{count}")
    public boolean updateStorage(@PathVariable("commodityCode") String commodityCode, @PathVariable("count") Integer count) {
        return storageTblService.updateStorage(commodityCode, count);
    }
}
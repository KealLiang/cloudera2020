package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.entity.SupportAddress;
import com.kealliang.laboratory.service.SupportAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SupportAddress)表控制层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@RestController
@RequestMapping("supportAddress")
public class SupportAddressController {
    /**
     * 服务对象
     */
    @Resource
    private SupportAddressService supportAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SupportAddress selectOne(Integer id) {
        return this.supportAddressService.queryById(id);
    }

}
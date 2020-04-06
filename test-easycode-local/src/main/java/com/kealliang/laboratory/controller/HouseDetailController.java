package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.entity.HouseDetail;
import com.kealliang.laboratory.service.HouseDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (HouseDetail)表控制层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@RestController
@RequestMapping("houseDetail")
public class HouseDetailController {
    /**
     * 服务对象
     */
    @Resource
    private HouseDetailService houseDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HouseDetail selectOne(Integer id) {
        return this.houseDetailService.queryById(id);
    }

}
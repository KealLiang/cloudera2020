package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.entity.House;
import com.kealliang.laboratory.service.HouseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 房屋信息表(House)表控制层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@RestController
@RequestMapping("house")
public class HouseController {
    /**
     * 服务对象
     */
    @Resource
    private HouseService houseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public House selectOne(Integer id) {
        return this.houseService.queryById(id);
    }

}
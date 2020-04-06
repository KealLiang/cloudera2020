package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.entity.SubwayStation;
import com.kealliang.laboratory.service.SubwayStationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SubwayStation)表控制层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@RestController
@RequestMapping("subwayStation")
public class SubwayStationController {
    /**
     * 服务对象
     */
    @Resource
    private SubwayStationService subwayStationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SubwayStation selectOne(Integer id) {
        return this.subwayStationService.queryById(id);
    }

}
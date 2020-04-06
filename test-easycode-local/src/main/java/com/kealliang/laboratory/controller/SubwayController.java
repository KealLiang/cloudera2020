package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.entity.Subway;
import com.kealliang.laboratory.service.SubwayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Subway)表控制层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@RestController
@RequestMapping("subway")
public class SubwayController {
    /**
     * 服务对象
     */
    @Resource
    private SubwayService subwayService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Subway selectOne(Integer id) {
        return this.subwayService.queryById(id);
    }

}
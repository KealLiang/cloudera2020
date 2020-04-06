package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.entity.HouseTag;
import com.kealliang.laboratory.service.HouseTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 房屋标签映射关系表(HouseTag)表控制层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@RestController
@RequestMapping("houseTag")
public class HouseTagController {
    /**
     * 服务对象
     */
    @Resource
    private HouseTagService houseTagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HouseTag selectOne(Integer id) {
        return this.houseTagService.queryById(id);
    }

}
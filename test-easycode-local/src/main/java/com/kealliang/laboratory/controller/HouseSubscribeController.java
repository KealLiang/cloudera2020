package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.entity.HouseSubscribe;
import com.kealliang.laboratory.service.HouseSubscribeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 预约看房信息表(HouseSubscribe)表控制层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@RestController
@RequestMapping("houseSubscribe")
public class HouseSubscribeController {
    /**
     * 服务对象
     */
    @Resource
    private HouseSubscribeService houseSubscribeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HouseSubscribe selectOne(Integer id) {
        return this.houseSubscribeService.queryById(id);
    }

}
package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.service.HouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    // 得把返回类型改成Object 否则切面修改返回值类型后会抛出类型转换异常
    public Object selectOne(Integer id) {
        return this.houseService.queryById(id);
    }

}
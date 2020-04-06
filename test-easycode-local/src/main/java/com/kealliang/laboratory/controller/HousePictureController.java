package com.kealliang.laboratory.controller;

import com.kealliang.laboratory.entity.HousePicture;
import com.kealliang.laboratory.service.HousePictureService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 房屋图片信息(HousePicture)表控制层
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@RestController
@RequestMapping("housePicture")
public class HousePictureController {
    /**
     * 服务对象
     */
    @Resource
    private HousePictureService housePictureService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HousePicture selectOne(Integer id) {
        return this.housePictureService.queryById(id);
    }

}
package com.kealliang.laboratory.service.impl;

import com.kealliang.laboratory.entity.HouseDetail;
import com.kealliang.laboratory.dao.HouseDetailDao;
import com.kealliang.laboratory.service.HouseDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HouseDetail)表服务实现类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Service("houseDetailService")
public class HouseDetailServiceImpl implements HouseDetailService {
    @Resource
    private HouseDetailDao houseDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HouseDetail queryById(Integer id) {
        return this.houseDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HouseDetail> queryAllByLimit(int offset, int limit) {
        return this.houseDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param houseDetail 实例对象
     * @return 实例对象
     */
    @Override
    public HouseDetail insert(HouseDetail houseDetail) {
        this.houseDetailDao.insert(houseDetail);
        return houseDetail;
    }

    /**
     * 修改数据
     *
     * @param houseDetail 实例对象
     * @return 实例对象
     */
    @Override
    public HouseDetail update(HouseDetail houseDetail) {
        this.houseDetailDao.update(houseDetail);
        return this.queryById(houseDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.houseDetailDao.deleteById(id) > 0;
    }
}
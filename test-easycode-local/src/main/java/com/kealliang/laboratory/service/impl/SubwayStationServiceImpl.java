package com.kealliang.laboratory.service.impl;

import com.kealliang.laboratory.entity.SubwayStation;
import com.kealliang.laboratory.dao.SubwayStationDao;
import com.kealliang.laboratory.service.SubwayStationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SubwayStation)表服务实现类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Service("subwayStationService")
public class SubwayStationServiceImpl implements SubwayStationService {
    @Resource
    private SubwayStationDao subwayStationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubwayStation queryById(Integer id) {
        return this.subwayStationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SubwayStation> queryAllByLimit(int offset, int limit) {
        return this.subwayStationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param subwayStation 实例对象
     * @return 实例对象
     */
    @Override
    public SubwayStation insert(SubwayStation subwayStation) {
        this.subwayStationDao.insert(subwayStation);
        return subwayStation;
    }

    /**
     * 修改数据
     *
     * @param subwayStation 实例对象
     * @return 实例对象
     */
    @Override
    public SubwayStation update(SubwayStation subwayStation) {
        this.subwayStationDao.update(subwayStation);
        return this.queryById(subwayStation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.subwayStationDao.deleteById(id) > 0;
    }
}
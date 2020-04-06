package com.kealliang.laboratory.service.impl;

import com.kealliang.laboratory.entity.Subway;
import com.kealliang.laboratory.dao.SubwayDao;
import com.kealliang.laboratory.service.SubwayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Subway)表服务实现类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Service("subwayService")
public class SubwayServiceImpl implements SubwayService {
    @Resource
    private SubwayDao subwayDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Subway queryById(Integer id) {
        return this.subwayDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Subway> queryAllByLimit(int offset, int limit) {
        return this.subwayDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param subway 实例对象
     * @return 实例对象
     */
    @Override
    public Subway insert(Subway subway) {
        this.subwayDao.insert(subway);
        return subway;
    }

    /**
     * 修改数据
     *
     * @param subway 实例对象
     * @return 实例对象
     */
    @Override
    public Subway update(Subway subway) {
        this.subwayDao.update(subway);
        return this.queryById(subway.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.subwayDao.deleteById(id) > 0;
    }
}
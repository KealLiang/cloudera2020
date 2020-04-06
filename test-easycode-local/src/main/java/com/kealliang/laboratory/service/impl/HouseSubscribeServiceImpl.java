package com.kealliang.laboratory.service.impl;

import com.kealliang.laboratory.entity.HouseSubscribe;
import com.kealliang.laboratory.dao.HouseSubscribeDao;
import com.kealliang.laboratory.service.HouseSubscribeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 预约看房信息表(HouseSubscribe)表服务实现类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Service("houseSubscribeService")
public class HouseSubscribeServiceImpl implements HouseSubscribeService {
    @Resource
    private HouseSubscribeDao houseSubscribeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HouseSubscribe queryById(Integer id) {
        return this.houseSubscribeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HouseSubscribe> queryAllByLimit(int offset, int limit) {
        return this.houseSubscribeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param houseSubscribe 实例对象
     * @return 实例对象
     */
    @Override
    public HouseSubscribe insert(HouseSubscribe houseSubscribe) {
        this.houseSubscribeDao.insert(houseSubscribe);
        return houseSubscribe;
    }

    /**
     * 修改数据
     *
     * @param houseSubscribe 实例对象
     * @return 实例对象
     */
    @Override
    public HouseSubscribe update(HouseSubscribe houseSubscribe) {
        this.houseSubscribeDao.update(houseSubscribe);
        return this.queryById(houseSubscribe.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.houseSubscribeDao.deleteById(id) > 0;
    }
}
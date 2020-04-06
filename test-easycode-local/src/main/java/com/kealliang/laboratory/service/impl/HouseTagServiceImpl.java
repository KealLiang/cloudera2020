package com.kealliang.laboratory.service.impl;

import com.kealliang.laboratory.entity.HouseTag;
import com.kealliang.laboratory.dao.HouseTagDao;
import com.kealliang.laboratory.service.HouseTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房屋标签映射关系表(HouseTag)表服务实现类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Service("houseTagService")
public class HouseTagServiceImpl implements HouseTagService {
    @Resource
    private HouseTagDao houseTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HouseTag queryById(Integer id) {
        return this.houseTagDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HouseTag> queryAllByLimit(int offset, int limit) {
        return this.houseTagDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param houseTag 实例对象
     * @return 实例对象
     */
    @Override
    public HouseTag insert(HouseTag houseTag) {
        this.houseTagDao.insert(houseTag);
        return houseTag;
    }

    /**
     * 修改数据
     *
     * @param houseTag 实例对象
     * @return 实例对象
     */
    @Override
    public HouseTag update(HouseTag houseTag) {
        this.houseTagDao.update(houseTag);
        return this.queryById(houseTag.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.houseTagDao.deleteById(id) > 0;
    }
}
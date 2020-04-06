package com.kealliang.laboratory.service.impl;

import com.kealliang.laboratory.entity.SupportAddress;
import com.kealliang.laboratory.dao.SupportAddressDao;
import com.kealliang.laboratory.service.SupportAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SupportAddress)表服务实现类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Service("supportAddressService")
public class SupportAddressServiceImpl implements SupportAddressService {
    @Resource
    private SupportAddressDao supportAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SupportAddress queryById(Integer id) {
        return this.supportAddressDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SupportAddress> queryAllByLimit(int offset, int limit) {
        return this.supportAddressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param supportAddress 实例对象
     * @return 实例对象
     */
    @Override
    public SupportAddress insert(SupportAddress supportAddress) {
        this.supportAddressDao.insert(supportAddress);
        return supportAddress;
    }

    /**
     * 修改数据
     *
     * @param supportAddress 实例对象
     * @return 实例对象
     */
    @Override
    public SupportAddress update(SupportAddress supportAddress) {
        this.supportAddressDao.update(supportAddress);
        return this.queryById(supportAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.supportAddressDao.deleteById(id) > 0;
    }
}
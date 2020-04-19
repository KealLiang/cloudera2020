package com.kealliang.cloud.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.kealliang.cloud.dao.StorageTblDao;
import com.kealliang.cloud.entity.StorageTbl;
import com.kealliang.cloud.service.StorageTblService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (StorageTbl)表服务实现类
 *
 * @author lsr
 * @since 2020-04-19 17:39:44
 */
@Service("storageTblService")
@Slf4j
public class StorageTblServiceImpl implements StorageTblService {
    @Resource
    private StorageTblDao storageTblDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StorageTbl queryById(Integer id) {
        return this.storageTblDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<StorageTbl> queryAllByLimit(int offset, int limit) {
        return this.storageTblDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param storageTbl 实例对象
     * @return 实例对象
     */
    @Override
    public StorageTbl insert(StorageTbl storageTbl) {
        this.storageTblDao.insert(storageTbl);
        return storageTbl;
    }

    /**
     * 修改数据
     *
     * @param storageTbl 实例对象
     * @return 实例对象
     */
    @Override
    public StorageTbl update(StorageTbl storageTbl) {
        this.storageTblDao.update(storageTbl);
        return this.queryById(storageTbl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.storageTblDao.deleteById(id) > 0;
    }

    @Transactional
    @Override
    public boolean updateStorage(String commodityCode, Integer count) {
        log.info("============ 开始更新库存 commodityCode[{}] count[{}] ============", commodityCode, count);
        StorageTbl storage = queryByCondition(commodityCode);
        if (storage == null) {
            throw new IllegalArgumentException("该商品库存不存在！！");
        }
        storage.setCount(storage.getCount() + count);
        if (storage.getCount() < 0) {
            throw new IllegalArgumentException("商品库存不足了！！ (╯▔皿▔)╯");
        }
        int update = storageTblDao.update(storage);
        return update == 1;
    }

    @Override
    public StorageTbl queryByCondition(String commodityCode) {
        StorageTbl query = StorageTbl.builder().commodityCode(commodityCode).build();
        List<StorageTbl> storageTbls = storageTblDao.queryAll(query);
        if (CollectionUtil.isEmpty(storageTbls)) {
            return null;
        }
        return storageTbls.get(0);
    }
}
package com.kealliang.laboratory.service.impl;

import com.kealliang.laboratory.entity.HousePicture;
import com.kealliang.laboratory.dao.HousePictureDao;
import com.kealliang.laboratory.service.HousePictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房屋图片信息(HousePicture)表服务实现类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@Service("housePictureService")
public class HousePictureServiceImpl implements HousePictureService {
    @Resource
    private HousePictureDao housePictureDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HousePicture queryById(Integer id) {
        return this.housePictureDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HousePicture> queryAllByLimit(int offset, int limit) {
        return this.housePictureDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param housePicture 实例对象
     * @return 实例对象
     */
    @Override
    public HousePicture insert(HousePicture housePicture) {
        this.housePictureDao.insert(housePicture);
        return housePicture;
    }

    /**
     * 修改数据
     *
     * @param housePicture 实例对象
     * @return 实例对象
     */
    @Override
    public HousePicture update(HousePicture housePicture) {
        this.housePictureDao.update(housePicture);
        return this.queryById(housePicture.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.housePictureDao.deleteById(id) > 0;
    }
}
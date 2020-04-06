package com.kealliang.laboratory.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 房屋信息表(House)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class House implements Serializable {
    private static final long serialVersionUID = 731243671520647115L;
    /**
    * house唯一标识
    */
    private Integer id;
    
    private String title;
    /**
    * 价格
    */
    private Integer price;
    /**
    * 面积
    */
    private Integer area;
    /**
    * 卧室数量
    */
    private Integer room;
    /**
    * 楼层
    */
    private Integer floor;
    /**
    * 总楼层
    */
    private Integer totalFloor;
    /**
    * 被看次数
    */
    private Integer watchTimes;
    /**
    * 建立年限
    */
    private Integer buildYear;
    /**
    * 房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
    */
    private Integer status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 最近数据更新时间
    */
    private Date lastUpdateTime;
    /**
    * 城市标记缩写 如 北京bj
    */
    private String cityEnName;
    /**
    * 地区英文简写 如昌平区 cpq
    */
    private String regionEnName;
    /**
    * 封面
    */
    private String cover;
    /**
    * 房屋朝向
    */
    private Integer direction;
    /**
    * 距地铁距离 默认-1 附近无地铁
    */
    private Integer distanceToSubway;
    /**
    * 客厅数量
    */
    private Integer parlour;
    /**
    * 所在小区
    */
    private String district;
    /**
    * 所属管理员id
    */
    private Integer adminId;
    
    private Integer bathroom;
    /**
    * 街道
    */
    private String street;


}
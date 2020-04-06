package com.kealliang.laboratory.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 预约看房信息表(HouseSubscribe)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HouseSubscribe implements Serializable {
    private static final long serialVersionUID = 862425995307491037L;
    
    private Integer id;
    /**
    * 房源id
    */
    private Integer houseId;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 用户描述
    */
    private String desc;
    /**
    * 预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
    */
    private Integer status;
    /**
    * 数据创建时间
    */
    private Date createTime;
    /**
    * 记录更新时间
    */
    private Date lastUpdateTime;
    /**
    * 预约时间
    */
    private Date orderTime;
    /**
    * 联系电话
    */
    private String telephone;
    /**
    * 房源发布者id
    */
    private Integer adminId;


}
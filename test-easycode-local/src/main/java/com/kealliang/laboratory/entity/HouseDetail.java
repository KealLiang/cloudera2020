package com.kealliang.laboratory.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * (HouseDetail)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HouseDetail implements Serializable {
    private static final long serialVersionUID = 379230602556002885L;
    
    private Integer id;
    /**
    * 详细描述
    */
    private String description;
    /**
    * 户型介绍
    */
    private String layoutDesc;
    /**
    * 交通出行
    */
    private String traffic;
    /**
    * 周边配套
    */
    private String roundService;
    /**
    * 租赁方式
    */
    private Integer rentWay;
    /**
    * 详细地址 
    */
    private String address;
    /**
    * 附近地铁线id
    */
    private Integer subwayLineId;
    /**
    * 附近地铁线名称
    */
    private String subwayLineName;
    /**
    * 地铁站id
    */
    private Integer subwayStationId;
    /**
    * 地铁站名
    */
    private String subwayStationName;
    /**
    * 对应house的id
    */
    private Integer houseId;


}
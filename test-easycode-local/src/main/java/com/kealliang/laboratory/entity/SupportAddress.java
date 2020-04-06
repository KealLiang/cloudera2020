package com.kealliang.laboratory.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * (SupportAddress)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SupportAddress implements Serializable {
    private static final long serialVersionUID = 107774966319457829L;
    
    private Integer id;
    /**
    * 上一级行政单位名
    */
    private String belongTo;
    /**
    * 行政单位英文名缩写
    */
    private String enName;
    /**
    * 行政单位中文名
    */
    private String cnName;
    /**
    * 行政级别 市-city 地区-region
    */
    private String level;
    /**
    * 百度地图经度
    */
    private Object baiduMapLng;
    /**
    * 百度地图纬度
    */
    private Object baiduMapLat;


}
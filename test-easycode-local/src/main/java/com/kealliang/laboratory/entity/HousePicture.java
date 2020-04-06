package com.kealliang.laboratory.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 房屋图片信息(HousePicture)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HousePicture implements Serializable {
    private static final long serialVersionUID = -30118328666510741L;
    
    private Integer id;
    /**
    * 所属房屋id
    */
    private Integer houseId;
    /**
    * 图片路径
    */
    private String cdnPrefix;
    /**
    * 宽
    */
    private Integer width;
    /**
    * 高
    */
    private Integer height;
    /**
    * 所属房屋位置
    */
    private String location;
    /**
    * 文件名
    */
    private String path;


}
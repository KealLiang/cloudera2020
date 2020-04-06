package com.kealliang.laboratory.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 房屋标签映射关系表(HouseTag)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HouseTag implements Serializable {
    private static final long serialVersionUID = 239877974764130757L;
    /**
    * 房屋id
    */
    private Integer houseId;
    /**
    * 标签id
    */
    private Integer id;
    
    private String name;


}
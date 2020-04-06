package com.kealliang.laboratory.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * (Subway)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Subway implements Serializable {
    private static final long serialVersionUID = 729444079001831827L;
    
    private Integer id;
    /**
    * 线路名
    */
    private String name;
    /**
    * 所属城市英文名缩写
    */
    private String cityEnName;


}
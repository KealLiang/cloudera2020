package com.kealliang.laboratory.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * (SubwayStation)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SubwayStation implements Serializable {
    private static final long serialVersionUID = -48684930460957780L;
    
    private Integer id;
    /**
    * 所属地铁线id
    */
    private Integer subwayId;
    /**
    * 站点名称
    */
    private String name;


}
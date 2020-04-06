package com.kealliang.laboratory.entity;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 用户角色表(Role)实体类
 *
 * @author kealliang
 * @since 2020-04-06 17:50:03
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Role implements Serializable {
    private static final long serialVersionUID = -83102189413403238L;
    
    private Integer id;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 用户角色名
    */
    private String name;


}
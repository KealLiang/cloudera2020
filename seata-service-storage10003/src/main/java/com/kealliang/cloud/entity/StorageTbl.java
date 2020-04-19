package com.kealliang.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * (StorageTbl)实体类
 *
 * @author lsr
 * @since 2020-04-19 17:39:44
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StorageTbl implements Serializable {
    private static final long serialVersionUID = -27382261676973589L;
    
    private Integer id;

    @NotBlank(message = "商品code不能为空！")
    private String commodityCode;

    @NotNull(message = "库存不能为空！")
    private Integer count;


}
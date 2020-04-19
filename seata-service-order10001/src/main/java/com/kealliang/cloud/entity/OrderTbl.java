package com.kealliang.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * (OrderTbl)实体类
 *
 * @author lsr
 * @since 2020-04-19 16:14:16
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderTbl implements Serializable {
    private static final long serialVersionUID = 288465044644965500L;
    
    private Integer id;

    @NotBlank(message = "用户id不能为空！")
    private String userId;

    @NotBlank(message = "商品code不能为空！")
    private String commodityCode;

    @NotNull(message = "购买数量不能为空！")
    private Integer count;

    @NotNull(message = "金额不能为空！")
    private Integer money;
    /**
    * 状态 1启动，2完成
    */
    private String status;


}
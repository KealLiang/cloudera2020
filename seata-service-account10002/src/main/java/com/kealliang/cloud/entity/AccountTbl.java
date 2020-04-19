package com.kealliang.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * (AccountTbl)实体类
 *
 * @author lsr
 * @since 2020-04-19 17:38:12
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountTbl implements Serializable {
    private static final long serialVersionUID = 421945071110419428L;
    
    private Integer id;

    @NotBlank(message = "用户id不能为空！")
    private String userId;

    @NotNull(message = "账户余额不能为空！")
    private Integer money;


}
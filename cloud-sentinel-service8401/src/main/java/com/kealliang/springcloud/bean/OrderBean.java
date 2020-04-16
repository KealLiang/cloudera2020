package com.kealliang.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lsr
 * @ClassName OrderBean
 * @Date 2020-04-17
 * @Vertion 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBean implements Serializable {
    private String name;
    private Integer code;
}

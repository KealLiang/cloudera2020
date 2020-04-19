package com.kealliang.cloud.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lsr
 * @ClassName OrderStatus
 * @Date 2020-04-19
 * @Vertion 1.0
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {
    EFFECT("生效", "1"),
    COMPLETE("已完成", "2")
    ;

    private String name;
    private String code;
}

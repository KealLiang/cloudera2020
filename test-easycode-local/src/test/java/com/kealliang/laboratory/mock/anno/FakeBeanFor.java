package com.kealliang.laboratory.mock.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 为指定的 Bean 创建 Mock 对象，需要继承原始 Bean
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FakeBeanFor {
    String value() default ""; // 需要替换的 Bean 的名称
}

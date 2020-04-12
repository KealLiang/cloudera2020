package com.kealliang.laboratory.config;

import com.kealliang.laboratory.config.web.HttpWebProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 配置属性类
 * 使用类的方式管理属性，替代传统方式（配置中定义，@Value注入使用）
 * 方便idea自动提示
 * 详见：https://blog.csdn.net/xiongmaojiuxianfly/article/details/86630219
 *
 * @author lsr
 * @ClassName KealConfigProperties
 * @Date 2020-04-11
 * @Vertion 1.0
 */
@Data
@ConfigurationProperties(prefix = "keal")
public class KealConfigProperties {

    @NestedConfigurationProperty
    private HttpWebProperties web = new HttpWebProperties();
}

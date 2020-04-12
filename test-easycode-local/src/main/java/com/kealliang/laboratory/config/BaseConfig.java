package com.kealliang.laboratory.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lsr
 * @ClassName BaseConfig
 * @Date 2020-04-11
 * @Vertion 1.0
 */
@Configuration
@EnableConfigurationProperties({ KealConfigProperties.class })
public class BaseConfig {
}

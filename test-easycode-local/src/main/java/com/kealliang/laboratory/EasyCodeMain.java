package com.kealliang.laboratory;

import com.kealliang.laboratory.config.KealConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author lsr
 * @ClassName EasyCodeMain
 * @Date 2020-04-06
 * @Vertion 1.0
 */
// 避免spring扫描dao接口找不到实现类报错，也可以在每个dao上添加@Mapper注解来解决
//@MapperScan("com.kealliang.laboratory.dao")
@EnableConfigurationProperties({ KealConfigProperties.class })
@SpringBootApplication
public class EasyCodeMain {
    public static void main(String[] args) {
        SpringApplication.run(EasyCodeMain.class, args);
    }
}

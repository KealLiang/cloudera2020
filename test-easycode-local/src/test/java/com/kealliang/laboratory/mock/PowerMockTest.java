package com.kealliang.laboratory.mock;

import cn.hutool.json.JSONUtil;
import com.kealliang.laboratory.EasyCodeMain;
import com.kealliang.laboratory.entity.House;
import com.kealliang.laboratory.service.HouseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 使用powermock模拟静态、final、构造方法等等
 * 要点：
 *  1）@RunWith(PowerMockRunner.class) 使用powermock的类加载器
 *  2）@PowerMockRunnerDelegate(SpringRunner.class) 兼容spring容器，因为runWith里不能指定springRunner了
 *  3）@PrepareForTest(JSONUtil.class) 对要mock的类进行准备
 *  4）@PowerMockIgnore( {"javax.management.*", "javax.crypto.*", "javax.net.ssl.*"}) 告诉powermock的类加载器忽略冲突的类
 *
 * @author lsr
 * @ClassName PowerMockTest
 * @Date 2020-11-20
 * @Vertion 1.0
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PowerMockIgnore( {"javax.management.*", "javax.crypto.*", "javax.net.ssl.*"})
@PrepareForTest(JSONUtil.class)
@SpringBootTest(classes={EasyCodeMain.class})
@EnableAutoConfiguration
@Transactional
public class PowerMockTest {

    @Autowired
    private HouseService service;

    @Test
    public void mockStaticTest() {
        // 使用powermock打桩
        PowerMockito.mockStatic(JSONUtil.class);
        PowerMockito.when(JSONUtil.toJsonPrettyStr(Mockito.any())).thenReturn("Hello PowerMock!");

        List<House> houses = service.queryAllByLimit(1, 1);
        System.out.println(JSONUtil.toJsonPrettyStr(houses));
    }

}

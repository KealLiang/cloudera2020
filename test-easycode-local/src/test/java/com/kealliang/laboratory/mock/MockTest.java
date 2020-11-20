package com.kealliang.laboratory.mock;

import cn.hutool.json.JSONUtil;
import com.github.javafaker.Faker;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.kealliang.laboratory.entity.Company;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lsr
 * @ClassName MockTest
 * @Date 2020-11-16
 * @Vertion 1.0
 */
public class MockTest {

    @Test
    public void getMockBeanTest() {
        Company company = getMockBean(Company.class);
        System.out.println(JSONUtil.toJsonPrettyStr(company));
    }

    /**
     * 使用枚举的方式获取单例bean
     * @author lsr
     * @description
     * @Date 2020/11/17
     */
    enum Single{
        INSTANCE;
        private Faker faker;

        Single() {
            faker = new Faker(Locale.CHINA);
        }
        public Faker getFaker() {
            return faker;
        }
    }
    public static Faker getFaker() {
        return Single.INSTANCE.getFaker();
    }

    /**
     * 获取mock的bean，排除final修饰的域
     * @author lsr
     * @description getMockBean
     * @Date 2020/11/16
     */
    public <T> T getMockBean(Class<T> tClass) {
        Field[] declaredFields = tClass.getDeclaredFields();
        List<String> excludes = Arrays.stream(declaredFields)
                .filter(f -> {
                    if (Modifier.isFinal(f.getModifiers()) || f.getType().equals(tClass)) {
                        return true;
                    }
                    // 排除未定义的泛型域
                    if (f.getGenericType() instanceof TypeVariable) {
                        return true;
                    }
                    // 避免递归创建导致的StackOverflowError
                    if (f.getType().equals(List.class) || f.getType().equals(Map.class)) {
                        if (Arrays.asList(((ParameterizedType) f.getGenericType()).getActualTypeArguments()).contains(tClass)) {
                            return true;
                        }
                    }
                    return false;
                })
                .map(f -> f.getName())
                .collect(Collectors.toList());
        MockConfig config = MockConfig.newInstance()
                .excludes(excludes.toArray(new String[excludes.size()]));
        return JMockData.mock(tClass, config);
    }

    /**
     * 获取mock的list
     * @author lsr
     * @description getMockList
     * @Date 2020/11/17
     */
    public <T> List<T> getMockList(Class<T> tClass) {
        Random r = new Random();
        int c = r.nextInt(5) + 2;
        List<T> result = new ArrayList<>(c);
        for (int i = 0; i < c; i++) {
            result.add(getMockBean(tClass));
        }
        return result;
    }
}

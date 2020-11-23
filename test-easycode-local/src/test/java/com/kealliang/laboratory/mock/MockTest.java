package com.kealliang.laboratory.mock;

import cn.hutool.json.JSONUtil;
import com.github.javafaker.Faker;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.kealliang.laboratory.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lsr
 * @ClassName MockTest
 * @Date 2020-11-16
 * @Vertion 1.0
 */
@Slf4j
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
     * 获取mock的bean，生成集合域，但只生成一层，避免StackOverflow
     * @author lsr
     * @description getMockBeanRecursion
     * @Date 2020/11/23
     */
    public <T> T getMockBeanRecursion(Class<T> tClass) {
        Field[] declaredFields = tClass.getDeclaredFields();
        Map<String, Type> listFieldMap = Arrays.stream(declaredFields)
                .filter(f -> f.getType().equals(List.class))
                .collect(Collectors.toMap(f -> f.getName(), f -> ((ParameterizedTypeImpl) f.getGenericType()).getActualTypeArguments()[0]));
        List<String> excludes = Arrays.stream(declaredFields)
                .filter(f -> filterField(tClass, f))
                .map(f -> f.getName())
                .collect(Collectors.toList());
//        excludes.addAll(listFieldMap.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList()));
        MockConfig config = MockConfig.newInstance()
                .excludes(excludes.toArray(new String[excludes.size()]));
        T mock = JMockData.mock(tClass, config);

        for (Map.Entry<String, Type> entry : listFieldMap.entrySet()) {
            try {
                Class<?> aClass = (Class) entry.getValue(); // 泛型的class
                List<?> mockList = getMockList(aClass);
                Field declaredField = mock.getClass().getDeclaredField(entry.getKey());
                declaredField.setAccessible(true);
                declaredField.set(mock, mockList);
            } catch (NoSuchFieldException e) {
                log.error("{}没有这个域", entry.getKey(), e);
            } catch (IllegalAccessException e) {
                log.error("{}非法访问", entry.getKey(), e);
            }
        }
        return mock;
    }

    /**
     * 获取mock的bean，不生成集合域
     * @author lsr
     * @description getMockBean
     * @Date 2020/11/16
     */
    public <T> T getMockBean(Class<T> tClass) {
        Field[] declaredFields = tClass.getDeclaredFields();
        List<String> excludes = Arrays.stream(declaredFields)
                .filter(f -> filterField(tClass, f))
                .map(f -> f.getName())
                .collect(Collectors.toList());
        MockConfig config = MockConfig.newInstance()
                .excludes(excludes.toArray(new String[excludes.size()]));
        return JMockData.mock(tClass, config);
    }

    private <T> boolean filterField(Class<T> tClass, Field f) {
        if (Modifier.isFinal(f.getModifiers()) || f.getType().equals(tClass)) {
            return true;
        }
        if (f.getGenericType() instanceof TypeVariable) {
            return true;
        }
        // 避免StackOverflowError
        if (f.getType().equals(List.class) || f.getType().equals(Map.class)) {
            return true;
            /*if (Arrays.asList(((ParameterizedType) f.getGenericType()).getActualTypeArguments()).contains(tClass)) {
                return true;
            }
            // 排除com.alibaba.fastjson.JSONObject
            if (((ParameterizedType) f.getGenericType()).getActualTypeArguments()[0].getTypeName()
                    .equals("com.alibaba.fastjson.JSONObject")) {
                return true;
            }*/
        }
        return false;
    }

    /**
     * 获取mock的list
     * @author lsr
     * @description getMockList
     * @Date 2020/11/17
     */
    public <T> List<T> getMockList(Class<T> tClass) {
        return getMockList(tClass, 3, 8);
    }

    public <T> List<T> getMockList(Class<T> tClass, int floor, int ceil) {
        if (floor > ceil) {
            return null;
        }
        Random r = new Random();
        int c = r.nextInt(ceil - floor) + floor;
        List<T> result = new ArrayList<>(c);
        for (int i = 0; i < c; i++) {
            result.add(getMockBean(tClass));
        }
        return result;
    }


    /********************************************************************
     * 旧方法，存在StackOverflowError的问题
     * 当tClass中的某个域为对象T，且T中有域使用了递归的结构时（例如组织DTO的children字段）
     * @author lsr
     * @description
     * @Date 2020/11/23
     ********************************************************************/

    /**
     * 获取mock的bean，排除final修饰的域
     * @author lsr
     * @description getMockBean
     * @Date 2020/11/16
     */
    /*public <T> T getMockBean(Class<T> tClass) {
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
    }*/
    /**
     * 获取mock的list
     * @author lsr
     * @description getMockList
     * @Date 2020/11/17
     */
    /*public <T> List<T> getMockList(Class<T> tClass) {
        Random r = new Random();
        int c = r.nextInt(5) + 2;
        List<T> result = new ArrayList<>(c);
        for (int i = 0; i < c; i++) {
            result.add(getMockBean(tClass));
        }
        return result;
    }*/
}

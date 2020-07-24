package com.kealliang.laboratory.spring;

import com.kealliang.laboratory.spring.bean.A;
import com.kealliang.laboratory.spring.bean.B;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 模拟spring解决循环依赖
 * @author lsr
 * @ClassName CycleDepandency
 * @Date 2020-07-24
 * @Vertion 1.0
 */
public class CycleDepandency {

    private static Map<String, Object> cacheMap = new HashMap<>(2);

    public static void main(String[] args) {
        // 类列表
        Class[] classes = {A.class, B.class};
        // 项目初始化所有bean
        for (Class clazz : classes) {
            getBean(clazz);
        }
        // 比较
        System.out.println(getBean(A.class).getB() == getBean(B.class));
        System.out.println(getBean(B.class).getA() == getBean(A.class));
    }

    /** 
     * 此问题的本质是 two sum (leetcode上的第一题)
     * 一次遍历 + HashMap
     *
     * class Solution {
     *     public int[] twoSum(int[] nums, int target) {
     *         Map<Integer, Integer> map = new HashMap<>();
     *         for (int i = 0; i < nums.length; i++) {
     *             int complement = target - nums[i];
     *             if (map.containsKey(complement)) {
     *                 return new int[] { map.get(complement), i };
     *             }
     *             map.put(nums[i], i);
     *         }
     *         throw new IllegalArgumentException("No two sum solution");
     *     }
     * }
     *
     * @author lsr
     * @description getBean
     * @Date 2020/7/24
     */
    @SneakyThrows
    private static <T> T getBean(Class<T> clazz) {
        // 简单代替bean的命名规则
        String beanName = clazz.getSimpleName().toLowerCase();
        // 已存在直接返回
        if (cacheMap.containsKey(beanName)) {
            return (T) cacheMap.get(beanName);
        }
        // 实例化对象并放入缓存
        T t = clazz.getDeclaredConstructor().newInstance();
        cacheMap.put(beanName, t);
        // 把所有字段当成要注入的bean，创建并注入到当前bean中
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> fieldClass = declaredField.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
            // 如果需要注入的bean已经在缓存中，则直接获取，否则继续创建
            declaredField.set(t, cacheMap.containsKey(fieldBeanName) ? cacheMap.get(fieldBeanName) : getBean(fieldClass));
        }
        return t;
    }

}

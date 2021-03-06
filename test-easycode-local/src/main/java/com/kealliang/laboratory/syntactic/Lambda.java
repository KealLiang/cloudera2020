package com.kealliang.laboratory.syntactic;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * lambda表达式高级运用
 * @author lsr
 * @ClassName Lambda
 * @Date 2020-10-29
 * @Vertion 1.0
 */
public class Lambda {
    public static void main(String[] args) {
//        sortedGrouping();

        sortedGroupingWithMostValue();

//        mapToNewMap();
    }

    /**
     * 分组排序
     * @author lsr
     * @description sortedGrouping
     * @Date 2020/11/9
     */
    private static void sortedGrouping() {
        List<Person> personList = getPeopleList();

        Map<String, List<Person>> collect = personList.stream()
                .sorted((a, b) -> b.getId() - a.getId())
                .collect(Collectors.groupingBy(Person::getGender));
        System.out.println(collect);
    }

    private static List<Person> getPeopleList() {
        String json = "[\n" +
                "{\"id\":1, \"name\":\"老李\", \"gender\": \"男\"},\n" +
                "{\"id\":2, \"name\":\"老王\", \"gender\": \"女\"},\n" +
                "{\"id\":3, \"name\":\"赵三\", \"gender\": \"男\"},\n" +
                "{\"id\":5, \"name\":\"刘二\", \"gender\": \"女\"},\n" +
                "{\"id\":4, \"name\":\"许多\", \"gender\": \"女\"}\n" +
                "]";

        return JSONUtil.toList(JSONUtil.parseArray(json), Person.class);
    }

    /**
     * grouping分组并根据某个字段的最值获取数据
     * @author lsr
     * @description sortedGroupingWithMostValue
     * @Date 2021/3/3
     */
    private static void sortedGroupingWithMostValue() {
        List<Person> peopleList = getPeopleList();

        Map<String, Person> result = peopleList.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.collectingAndThen(
                        Collectors.reducing((a, b) -> a.getId() >= b.getId() ? a : b), // 取id大的作为grouping的结果
                        Optional::get
                )));

        System.out.println(result);
    }

    /**
     * 将一个map转换为另一个新的map
     * @author lsr
     * @description mapToNewMap
     * @Date 2020/10/29
     */
    private static void mapToNewMap() {
        // 构造原始map
        Map<String, List<String>> originMap = new HashMap<>();
        List<String> l1 = new ArrayList<>();
        l1.add("11");
        l1.add("12");
        l1.add("13");
        List<String> l2 = new ArrayList<>();
        originMap.put("A", l1);
        originMap.put("B", l2);

        // 方式1
        Map<String, Integer> countMap1 = new HashMap<>();
        originMap.entrySet().stream().forEach(m -> countMap1.put(m.getKey(), m.getValue().size()));
        System.out.println(countMap1);

        // 方式2
        Map<String, Integer> countMap2 = originMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, m -> m.getValue().size()));
        System.out.println(countMap2);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person {
        private Integer id;
        private String name;
        private String gender;
    }
}

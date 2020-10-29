package com.kealliang.laboratory.syntactic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        mapToNewMap();
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
}

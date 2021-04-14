package com.kealliang.laboratory.algorithm.datastructure;

import com.kealliang.laboratory.algorithm.data.Node;

import java.util.function.Function;

/**
 * @author lsr
 * @ClassName Arr
 * @Date 2021-03-19
 * @Vertion 1.0
 */
public class Array {
    public static void main(String[] args) {

    }

    /**
     * 数组的遍历
     * @author lsr
     * @description traverse
     * @Date 2021/3/19
     */
    static void traverse(Node[] nodeArr, Function<? super Node, ?> func) {
        for (int i = 0; i < nodeArr.length; i++) {
            func.apply(nodeArr[i]);
        }
    }
}

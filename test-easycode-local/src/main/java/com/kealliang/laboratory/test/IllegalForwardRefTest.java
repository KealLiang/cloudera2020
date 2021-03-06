package com.kealliang.laboratory.test;

/**
 * java 变量定义其实也是有顺序的
 * @author lsr
 * @description
 * @Date 2021/3/1
 */
public class IllegalForwardRefTest {
    static {
        i = 0;                // 给变量赋值可以正常编译通过
//        System.out.print(i);  // 这句编译器会提示“非法向前引用”
    }
    static int i = 1;
}
package com.kealliang.laboratory.test;

/**
 * @author lsr
 * @ClassName FactorialTest
 * @Date 2020-05-08
 * @Vertion 1.0
 */
public class FactorialTest {
    public static int num = 100000000;

    public static long recursion (int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return n * recursion(n-1);
    }

    public static long dynamic(int n) {
        long[] slot = new long[n+1];
        slot[0] = 1;
        slot[1] = 1;
        for(int i=2;i<=n;i++) {
            slot[i] = i * slot[i-1];
        }
        return slot[n];
    }

    public static void run(int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
//            dynamic(n);
            recursion(n);
        }
        System.out.println("计算耗时（毫秒）：" + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
//        System.out.println(dynamic(6));
        run(50);
    }
}

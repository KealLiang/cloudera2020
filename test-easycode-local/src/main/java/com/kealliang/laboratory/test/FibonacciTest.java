package com.kealliang.laboratory.test;

/**
 * @author lsr
 * @ClassName FibbonacciTest
 * @Date 2020-05-08
 * @Vertion 1.0
 */
public class FibonacciTest {
    public static int num = 1;

    public static long recursion (int n) {
        if(n == 1 || n ==2) {
            return 1;
        }
        return recursion(n-1) + recursion(n-2);
    }

    public static long dynamic (int n) {
        long[] slot = new long[n];
        slot[0] = 1;
        slot[1] = 1;
        for (int i = 2; i < n; i++) {
            slot[i] = slot[i-1] + slot[i-2];
        }
        return slot[n-1];
    }

    public static void run(int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
//            dynamic(n);
//            System.out.println(recursion(n));
            System.out.println(dynamic(n));
        }
        System.out.println("计算耗时（毫秒）：" + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        run(50);
    }
}

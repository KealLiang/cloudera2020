package com.kealliang.laboratory.thread;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * cpu指令重排序演示
 * @author lsr
 * @ClassName ReorderedTest
 * @Date 2020-06-26
 * @Vertion 1.0
 */
public class ReorderedTest {
    private static int x, y, a, b;


    public static void main(String[] args) throws InterruptedException {
        proveInstructionsReordered();
    }

    public static void proveInstructionsReordered() throws InterruptedException {
        int i = 0;
        for(;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start(); other.start();
            one.join(); other.join();
            if (x == 0 && y == 0) {
                System.out.println(StrUtil.format("第{}次循环中，x = {}, y = {}", i, x, y));
                break;
            }
        }
    }
}

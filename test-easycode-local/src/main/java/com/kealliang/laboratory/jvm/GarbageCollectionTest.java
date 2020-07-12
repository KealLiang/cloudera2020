package com.kealliang.laboratory.jvm;

import java.util.concurrent.TimeUnit;

/**
 * 验证变量被重新赋值后，原来的对象是否会被回收
 * @author lsr
 * @ClassName GarbageCollectionTest
 * @Date 2020-07-08
 * @Vertion 1.0
 */
public class GarbageCollectionTest {

    public static Haha haha;
    
    public static void assignmentValue () {
        haha = new Haha();
    }

    public static void main(String[] args) {
        assignmentValue(); // haha1
        assignmentValue(); // 现指向haha2, haha1 实例丢失了引用后会被gc回收
        // haha = null; // 这样 haha1 和 haha2 都会被回收
        System.gc();
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }


    static class Haha {
        @Override
        protected void finalize() throws Throwable {
            System.err.println(Thread.currentThread().getName() + " --> haha对象被回收了！！！");
        }
    }
}

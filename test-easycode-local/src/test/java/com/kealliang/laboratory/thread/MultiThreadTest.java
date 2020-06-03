package com.kealliang.laboratory.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lsr
 * @ClassName MultiThreadTest
 * @Date 2020-06-03
 * @Vertion 1.0
 */
public class MultiThreadTest {
    private static int count = 0;
    private static int count2 = 0;

    private static AtomicInteger ai = new AtomicInteger(0);

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 1_000_000; ++i) {
                    // 原始
                    count += 1;

                    // ReentrantLock解决
                    lock.lock();
                    try { count2 += 1; } finally { lock.unlock(); }

                    // Atomic解决
                    ai.getAndIncrement();
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("count = " + count);
        System.out.println("count2 = " + count2);
        System.out.println("AtomicCount = " + ai.get());
    }
}

package com.kealliang.laboratory.thread;

import java.io.PrintStream;

/**
 * 两条线程，交替打印奇偶数
 * @author lsr
 * @ClassName OddEvenPrint
 * @Date 2021-03-12
 * @Vertion 1.0
 */
public class OddEvenPrint {
    public static void main(String[] args) {
        NumPrint p = new NumPrint();
        new Thread(p, "A").start();
        new Thread(p, "B").start();
    }

    static class NumPrint implements Runnable {
        int num = 0;
        @Override
        public void run() {
            synchronized (this) {
                while (true) {
                    this.notify(); // 唤醒等待在this上的线程
                    if (num <= 100) {
                        System.out.println(Thread.currentThread().getName() + " : " + num++);
                    } else {
                        break; // 最后一个数字打印完就不用wait了
                    }
                    try { this.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            }
        }
    }
}

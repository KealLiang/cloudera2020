package com.kealliang.laboratory.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author lsr
 * @ClassName ThreadStateTest
 * @Date 2020-05-20
 * @Vertion 1.0
 */
public class ThreadStateTest {

    static class MyThread extends Thread{
        public MyThread() {super();}
        public MyThread(String name) {
            super();
            this.setName(name);
        }
        @Override
        public void run() {
            if ("wait".equals(this.getName())) {
                synchronized (this) { // 调用wait()方法需要先获取当前对象的monitor，需要使用锁，否则将报错IllegalMonitorStateException
                    try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            } else {
                doSomething();
            }
        }
        // 静态+同步锁，保证t1和t2竞争的是统一把锁
        private synchronized static void doSomething() {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
    /**
     * 线程的6种状态演示
     * @author lsr
     * @description changeState
     * @Date 2020/5/20
     */
    @Test
    public void changeState() throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread("wait");
        System.out.println("t1.getState() = " + t1.getState()); //NEW
        t1.start();
        t2.start();
        t3.start();
        System.out.println("t1.getState() = " + t1.getState()); //RUNNABLE
        Thread.sleep(100); //主线程睡一下，保证下一句执行时t2确实进入doSomething()了
        System.out.println("t2.getState() = " + t2.getState()); //BLOCKED
        t1.sleep(200);
        System.out.println("t1.getState() = " + t1.getState()); //TIMED_WAITING
        System.out.println("t3.getState() = " + t3.getState()); //WAITING
        t1.join();
        System.out.println("t1.getState() = " + t1.getState()); //TERMINATED
    }
}

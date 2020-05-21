package com.kealliang.laboratory.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lsr
 * @ClassName DynamicDatasourceTest
 * @Date 2020-05-20
 * @Vertion 1.0
 */
public class DequeAndLockTest {


    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();
    /**
     * 可重入锁
     * @author lsr
     * @description reentrantLockTest
     * @Date 2020/5/20
     */
    public void reentrantLockTest () {
        // 读成员变量时，其实有两步
        // 1 将this压栈
        // 2 读取field
        final ReentrantLock lock = this.lock; // 这样做之后，就能直接从栈里读，循环的情况下效率高
        lock.lock();
        try {
            // ...
        } finally {
            lock.unlock();
        }
    }

    /**
     * 双向阻塞链表
     * @author lsr
     * @description dequeTest
     * @Date 2020/5/20
     */
    public static void dequeTest () throws InterruptedException {
        // double-ended queue
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>();
        deque.putFirst("0");
        deque.peekFirst(); // 看第一个
        deque.getFirst(); // 看第一个，空队列抛异常
        deque.pollFirst(); // 拿第一个
        deque.removeFirst(); // 拿第一个，空队列抛异常
    }

    public static void main(String[] args) throws Exception {
        dequeTest();
    }
}

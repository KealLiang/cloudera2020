package com.kealliang.laboratory.thread;

import lombok.SneakyThrows;

public class JoinTest extends Thread {
    int i;
    Thread previousThread; //上一个线程
    public JoinTest(Thread previousThread, int i){
        this.previousThread=previousThread;
        this.i=i;
    }

    @SneakyThrows(InterruptedException.class)
    @Override
    public void run() {
        /*
         * 在A中调用B.join()
         * 效果是A会等待B执行完并返回，才继续执行（B插队到A前面）
         */
        //调用上一个线程的join方法，可以把这行代码注释掉看看效果
        previousThread.join();
        System.out.println("num:"+i);
    }

    public static void main(String[] args) {
        Thread previousThread=Thread.currentThread();
        for(int i=0;i<10;i++){
            JoinTest joinTest =new JoinTest(previousThread,i);
            joinTest.start();
            previousThread= joinTest;
        }
        System.out.println("main done");
    }
}
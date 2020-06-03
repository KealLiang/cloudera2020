package com.kealliang.laboratory.thread;

public class MemoryVisibilityTest {

    /*
     * 多核处理器时，这个flag的可见性是不能保证的；
     * 如果正好是在flag被t2取出并缓存在L1、L2级缓存后内存中的flag才被t1修改，程序就将卡在 while (!flag) 上
     */
    private static boolean flag;

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10000; ++i) {
            flag = false;
            final int no = i;

            Thread t1 = new Thread(() -> {
                flag = true;
                System.out.println(String.format("No.%d loop, t1 is done.", no));
            });

            Thread t2 = new Thread(() -> {
                while (!flag); // 等待t1将flag变为true
                System.out.println(String.format("No.%d loop, t2 is done.", no));
            });

            t2.start();
            t1.start();

            t1.join();
            t2.join();
        }
    }

}
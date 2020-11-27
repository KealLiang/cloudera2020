package com.kealliang.laboratory.test;

public class JvmFastThrowTest {

    /**
     * JIT编译器对异常进行了优化，当代码中的某个位置抛出同一个异常很多次后，JIT服务端编译器(C2)
     * 会将其优化成抛出一个事先编译好的、类型匹配的异常，异常堆栈信息就看不到了。
     * @author lsr
     * @description 打印出 stackTrace omit after 115711 times
     * @Date 2020/11/25
     */
    public static void main(String[] args) {
       for(int i = 0; i < 200000; i++) {
           try {
               ((Object)null).getClass();
           } catch (Exception e) {
               System.out.println(i + ":" + e.getStackTrace().length);
               if (e.getStackTrace().length == 0) {
                   System.out.println("stackTrace omit after " + i + " times");
                   e.printStackTrace();
                   break;
               }
           }
       }
    }

}

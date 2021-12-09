package com.wk.juc1;

/**
 * @author wangkang
 * @Date 2021/10/15 17:46
 */
public class ThreadLocalExample1 {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal1 = new ThreadLocal<>();
        ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();

        Thread thread1 = new Thread(()->{
            threadLocal1.set(1);
            threadLocal2.set(1);
            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
        });
        Thread thread2 = new Thread(()->{
            System.out.println("======");
            threadLocal1.set(2);
            threadLocal2.set(2);

            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
        });

        thread1.start();
        thread2.start();
    }
}

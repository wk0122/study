package com.wk.juc1;

/**
 * @author wangkang
 * @Date 2021/10/15 17:27
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println("===");
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();
    }
}

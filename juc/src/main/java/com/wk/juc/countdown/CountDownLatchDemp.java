package com.wk.juc.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangkang
 * @Date 2021/9/29 15:12
 */
public class CountDownLatchDemp {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" go out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();//等待计数器归零 然后向下执行
        System.out.println("关门");
    }
}

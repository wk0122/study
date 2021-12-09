package com.wk.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author wangkang
 * @Date 2021/9/29 10:33
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Phone3 phone = new Phone3();

        new Thread(()->{phone.snedMsg();},"A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{phone.call();},"B").start();
    }
}

class Phone3 {

    public static synchronized void snedMsg() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    // 类锁 和 方法锁 不是同一把锁
    public synchronized void call(){
        System.out.println("打电话");
    }
}

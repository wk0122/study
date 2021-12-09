package com.wk.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author wangkang
 * @Date 2021/9/29 10:29
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Phone2 phone = new Phone2();

        new Thread(()->{phone.snedMsg();},"A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{phone.call();},"B").start();
    }
}

class Phone2 {
    //synchronized 锁的对象是方法的调用者
    // static 类一加载就有了 锁的是class
    public static synchronized void snedMsg() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }
}
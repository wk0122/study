package com.wk.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author wangkang
 * @Date 2021/9/29 10:14
 *
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();

        new Thread(()->{phone.snedMsg();},"A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{phone.call();},"B").start();
    }
}

class Phone {
    //synchronized 锁的对象是方法的调用者
    public synchronized void snedMsg() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}

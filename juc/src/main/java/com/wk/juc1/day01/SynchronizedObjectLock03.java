package com.wk.juc1.day01;

/**
 * @author wangkang
 * @Date 2021/10/18 15:52
 * synchronized 修饰普通方法 锁对象默认是this
 */
public class SynchronizedObjectLock03 implements Runnable {

    public static void main(String[] args) {
        SynchronizedObjectLock03 instance = new SynchronizedObjectLock03();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        System.out.println("我是线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }
}

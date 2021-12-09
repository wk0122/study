package com.wk.juc1.day01;

/**
 * @author wangkang
 * @Date 2021/10/18 15:55
 */
public class SynchronizedObjectLock04 implements Runnable {

    public static void main(String[] args) {
        SynchronizedObjectLock04 instance1 = new SynchronizedObjectLock04();
        SynchronizedObjectLock04 instance2 = new SynchronizedObjectLock04();
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        method();
    }

    /**
     * synchronized 锁住静态方法 其实是锁的class SynchronizedObjectLock04.class
     */
    public synchronized static void method(){
        System.out.println("我是线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }
}
